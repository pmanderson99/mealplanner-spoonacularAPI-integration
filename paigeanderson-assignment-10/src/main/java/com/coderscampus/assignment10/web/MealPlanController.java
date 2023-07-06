package com.coderscampus.assignment10.web;

import java.net.URI;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.coderscampus.assignment10.dto.DayResponse;
import com.coderscampus.assignment10.dto.WeekResponse;

@RestController
public class MealPlanController {
	
	@SuppressWarnings("unchecked")
	@GetMapping("mealplanner/week")
	public ResponseEntity<WeekResponse> getWeekMeals(String numCalories, String diet, String exclusions){
		
		return (ResponseEntity<WeekResponse>) getMealResponse(WeekResponse.class, "week", numCalories, diet, exclusions);
		
	}

	@SuppressWarnings("unchecked")
	@GetMapping("mealplanner/day")
	public ResponseEntity<DayResponse> getDayMeals(String numCalories, String diet, String exclusions){
		
		return (ResponseEntity<DayResponse>) getMealResponse(DayResponse.class, "day", numCalories, diet, exclusions);
		
	}
	
	private ResponseEntity<?> getMealResponse(Class<?> responseClass, String numCalories, String diet, String exclusions, String time){
		
		RestTemplate rt = new RestTemplate();
		
		
		URI uri = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate")
									  .queryParam("timeFrame", time)
									  .queryParam("apiKey", "c3ff53dc9a834807b17a29597bd2210c")
									  .queryParam("targetCalories", numCalories)
									  .queryParam("diet", diet)
									  .queryParam("exclude", exclusions)
									  .build().toUri();
		
		ResponseEntity<?> responseEntity = rt.getForEntity(uri, responseClass);
		
		return responseEntity;
	}

}
