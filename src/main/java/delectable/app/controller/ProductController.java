package delectable.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import delectable.app.entity.Product;
import delectable.app.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService service;

	// Get individual product
	@GetMapping("/product/{id}")
	public String getProduct(Model model, @PathVariable int id) {
		// Product product = service.getProduct(id);
		// model.addAttribute("product", product);
		return "product/Test";
	}

	// Get product list
	@GetMapping("/product/list")
	public String getProductList(@PageableDefault(value = 15, page = 0) Pageable pageable, Model model) {
		model.addAttribute("productList", service.findAllByOrderByNameAsc(pageable));
		return "product/list";
	}

	// Add product form
	@GetMapping("/product")
	public String greetingForm(Model model) {
		model.addAttribute("product", new Product());
		return "productAddForm";
	}

	@PostMapping(value = "/product", params = { "save" })
	public String greetingSubmit(@ModelAttribute Product product) {
		return "result";
	}

	@PostMapping(value = "/product", params = { "addRow" })
	public String addRow(final Product product) {
		return "productAddForm";
	}

	@PostMapping(value = "/product", params = { "removeRow" })
	public String removeRow(Product product, final HttpServletRequest req) {

		return "productAddForm";
	}

}
