package product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.CachedRowSet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import app.Database;

@Controller
public class ProductController {

    @GetMapping("/product/{id}")
    public String getProduct(Model model, @PathVariable int id) {
    	String sql = "";

		try {
	    	sql = "Select * from products where id=" + id;
			CachedRowSet set = Database.Query(sql);
			set.last();
			
			Product prod = new Product(set.getInt("id"), set.getString("name"), set.getString("manufacturer"),
					set.getFloat("servingSize"), set.getString("unitOfMeasure"), set.getInt("calories"), 
					set.getString("ingredients"), set.getBoolean("ingredient"), set.getBoolean("premade"));
						
	    	sql = "Select * from nutrients where id=" + id;
	    	set = Database.Query(sql);
	    	
	    	while(set.next()) {
		    	prod.nutrients.add(new Nutrient(set.getInt("id"), set.getString("name"), set.getFloat("value"), set.getString("unitOfMeasure")));
	    	}
			model.addAttribute("product", prod);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return "product.html";
    }
    
    @GetMapping("/product")
    public String greetingForm(Model model) {
        model.addAttribute("product", new Product());
        return "form";
    }

    @PostMapping(value="/product", params= {"save"})
    public String greetingSubmit(@ModelAttribute Product product) {
        return "result";
    }
    
    @RequestMapping(value="/product", params={"addRow"})
    public String addRow(final Product product) {
        product.getNutrients().add(new Nutrient());
        return "form";
    }
    
    @RequestMapping(value="/product", params={"removeRow"})
    public String removeRow(final Product product, final HttpServletRequest req) {
        final Integer rowId = Integer.valueOf(req.getParameter("removeRow"));
        product.getNutrients().remove(rowId.intValue());
        product.getNutrients().trimToSize();
        return "form";
    }
}

