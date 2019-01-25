package delectable.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import delectable.app.entity.Restaurant;
import delectable.app.service.RestaurantService;
import delectable.app.utility.Day;

@Controller
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;

	@GetMapping("/restaurant/list")
	public String getrestaurantList(@PageableDefault(value = 20, page = 0) Pageable pageable, Model model) {
		model.addAttribute("restaurantList", restaurantService.findAllByOrderByNameAsc(pageable));
		return "restaurant/list";
	}

	@GetMapping("/restaurant")
	public String getAddRestaurantForm(Model model) {
		model.addAttribute("restaurant", new Restaurant());
		model.addAttribute("days", Day.values());
		return "restaurant/form";
	}

	@PostMapping(value = "/restaurant", params = { "save" })
	public String createRestaurant(@ModelAttribute Restaurant restaurant) {
		restaurantService.save(restaurant);
		return "redirect:/restaurant/list";
	}

	@GetMapping("/restaurant/{id}/remove")
	public String deleteRestaurant(@ModelAttribute Restaurant restaurant) {
		restaurantService.deleteById(restaurant.getId());
		return "redirect:/restaurant/list";
	}

	@GetMapping("/restaurant/{id}")
	public String getRestaurant(Model model, @PathVariable int id) {
		return "restaurant/form";
	}

	@GetMapping("/restaurant/{id}/edit")
	public String editRestaurant(Model model, @PathVariable int id) {
		Restaurant restaurant = restaurantService.findById(id);
		model.addAttribute("restaurant", restaurant);
		model.addAttribute("days", Day.values());
		return "restaurant/form";
	}

}
