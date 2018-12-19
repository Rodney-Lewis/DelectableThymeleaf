package delectable.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}
