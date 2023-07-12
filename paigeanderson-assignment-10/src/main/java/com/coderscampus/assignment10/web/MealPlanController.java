package com.coderscampus.assignment10.web;

import java.net.URI;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.coderscampus.assignment10.dto.DayResponse;
import com.coderscampus.assignment10.dto.WeekResponse;

@RestController
public class MealPlanController {

	@SuppressWarnings("unchecked")
	@GetMapping("mealplanner/week")
	public ResponseEntity<WeekResponse> getWeekMeals(
			@RequestParam(required = false) Integer numCalories,
			@RequestParam(required = false) String diet,
			@RequestParam(required = false) String exclusions) {
		
		return (ResponseEntity<WeekResponse>) getMealPlanResponse(numCalories, diet, exclusions, "week", WeekResponse.class);
	}

	@SuppressWarnings("unchecked")
	@GetMapping("mealplanner/day")
	public ResponseEntity<DayResponse> getDayMeals(
			@RequestParam(required = false) Integer numCalories,
			@RequestParam(required = false) String diet, 
			@RequestParam(required = false) String exclusions) {
		
		return (ResponseEntity<DayResponse>) getMealPlanResponse(numCalories, diet, exclusions, "day", DayResponse.class);
		
	}
	
	
	
	private ResponseEntity<?> getMealPlanResponse(Integer numCalories, String diet, String exclusions, String time,
			Class<?> responseClass) {

		URI uri = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate")
									  .queryParam("timeFrame", time).queryParam("apiKey", "c3ff53dc9a834807b17a29597bd2210c")
									  .queryParamIfPresent("numCalories", Optional.ofNullable(numCalories))
									  .queryParamIfPresent("diet", Optional.ofNullable(diet))
									  .queryParamIfPresent("exclude", Optional.ofNullable(exclusions))
									  .build()
									  .toUri();

		RestTemplate rt = new RestTemplate();
		ResponseEntity<?> responseEntity = rt.getForEntity(uri, responseClass);
		return responseEntity;

	}

}
