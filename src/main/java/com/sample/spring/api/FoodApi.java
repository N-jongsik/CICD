package com.sample.spring.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.spring.api.request.CreateAndEditFoodRequest;
import com.sample.spring.api.response.FoodDetailView;
import com.sample.spring.api.response.FoodView;
import com.sample.spring.model.FoodEntity;
import com.sample.spring.service.FoodService;

@RestController
public class FoodApi {
	@Autowired
	private FoodService foodService;

	@GetMapping("/foods")
	public List<FoodView> getFoods() {
		return foodService.getAllFoods();
	}

	@GetMapping("/food/{foodId}")
	public FoodDetailView viewFood(@PathVariable("foodId") Long foodId) {
		return foodService.getFoodDetail(foodId);
	}

	@PostMapping("/food")
	public FoodEntity postFood(@RequestBody CreateAndEditFoodRequest request) {
		return foodService.createFood(request);
//		return "postFood name: " + request.getName() + " postFood address: " + request.getAddress() + ", 메뉴[0] : "
//				+ request.getMenus().get(0).getName();
	}

	@PutMapping("/food/{foodId}")
	public void editFood(@PathVariable("foodId") Long foodId, @RequestBody CreateAndEditFoodRequest request) {
		// return "editFood name: " + request.getName() + "editFood address: " +
		// request.getAddress();
		foodService.editFood(foodId, request);
	}

	@DeleteMapping("/food/{foodId}")
	public void deleteFood(@PathVariable("foodId") Long foodId) {
		foodService.deleteFood(foodId);
		// return "deleteFood " + foodId;
	}

}
