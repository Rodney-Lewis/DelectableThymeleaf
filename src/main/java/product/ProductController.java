package product;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import app.Database;

@Controller
public class ProductController {

    @GetMapping("/product/{id}")
    public String getProduct(Model model, @PathVariable int id) {
    	String sql = "Select * from products where id=" + id;
    	
		try {
			CachedRowSet set = Database.Query(sql);
			set.last();
			model.addAttribute("product", new Product(set.getInt("id"), set.getString("name"), set.getString("manufacturer"),
					set.getFloat("servingSize"), set.getString("unitOfMeasure"), set.getInt("calories"), 
					set.getString("ingredients"), set.getBoolean("ingredient"), set.getBoolean("premade")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return "product.html";
    }
}

