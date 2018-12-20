package delectable.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import delectable.app.entity.Vendor;
import delectable.app.service.VendorService;

@Controller
public class VendorController {

	@Autowired
	private VendorService service;

	@GetMapping("/vendor/list")
	public String getVendorList(@PageableDefault(value = 15, page = 0) Pageable pageable, Model model) {
		model.addAttribute("vendorList", service.findAllByOrderByNameAsc(pageable));
		return "vendor/list";
	}

	@GetMapping("/vendor")
	public String addVendor(Model model) {
		model.addAttribute("vendor", new Vendor());
		return "vendor/form";
	}

	@GetMapping("/vendor/{id}")
	public String getVendor(Model model, @PathVariable int id) {
		return "vendor/form";
	}

	@GetMapping("/vendor/{id}/edit")
	public String editVendor(Model model, @PathVariable int id) {
		return "vendor/form";
	}

	@DeleteMapping("/vendor/{id}/remove")
	public void deleteVendor() {

	}
}
