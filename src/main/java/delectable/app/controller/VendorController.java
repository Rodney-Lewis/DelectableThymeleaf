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
	public String getAddVendorForm(Model model) {
		model.addAttribute("vendor", new Vendor());
		return "vendor/form";
	}

	@PostMapping(value = "/vendor", params = { "save" })
	public String createVendor(@ModelAttribute Vendor vendor) {
		service.save(vendor);
		return "redirect:/vendor/list";
	}

	@PostMapping(value = "/vendor", params = { "delete" })
	public String deleteVendor(@ModelAttribute Vendor vendor) {
		service.deleteById(vendor.getId());
		return "redirect:/vendor/list";
	}

	@GetMapping("/vendor/{id}")
	public String getVendor(Model model, @PathVariable int id) {
		return "vendor/form";
	}

	@GetMapping("/vendor/{id}/edit")
	public String editVendor(Model model, @PathVariable int id) {
		Vendor vendor = service.findAllById(id);
		model.addAttribute("vendor", vendor);
		return "vendor/form";
	}

}
