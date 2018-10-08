package product;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.CachedRowSet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import app.Database;

@Controller
public class ProductController {

	//Get individual product
    @GetMapping("/product/{id}")
    public String getProduct(Model model, @PathVariable int id) {
    	String sql = "";
    	CachedRowSet set = null;
    	
		try {
	    	sql = "Select * FROM `products` WHERE id=" + id;
			set = Database.Query(sql);
			set.last();
			
			Product prod = new Product(set.getInt("id"), set.getString("name"), set.getString("brand"),
					set.getFloat("servingSize"), set.getString("unitOfMeasure"), set.getInt("calories"), 
					set.getString("ingredients"), set.getBoolean("ingredient"), set.getBoolean("premade"));
					
//			Holding off on Nutrient until a proper format is determined.
//	    	sql = "Select * FROM `nutrients` WHERE id=" + id;
//	    	set = Database.Query(sql);
	    	
//	    	while(set.next()) {
//		    	prod.nutrients.add(new Nutrient(set.getInt("id"), set.getString("name"), set.getFloat("value"), set.getString("unitOfMeasure")));
//	    	}
			model.addAttribute("product", prod);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				set.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    	return "product";
    }
    
    //Get product list
    @GetMapping("/product/list")
    public String getProductList(Model model) {
    	String sql = "";
    	CachedRowSet set = null;

		try {
	    	sql = "Select * from products";
			set = Database.Query(sql);
			
			ArrayList<Product> productList = new ArrayList<Product>();
						
	    	while(set.next()) {
		    	productList.add(new Product(set.getInt("id"), set.getString("name"), set.getString("brand"),
						set.getFloat("servingSize"), set.getString("unitOfMeasure"), set.getInt("calories"), 
						set.getString("ingredients"), set.getBoolean("ingredient"), set.getBoolean("premade")));
	    	}
			model.addAttribute("productList", productList);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				set.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    	return "productList";
    }
    
    //Add product form
    @GetMapping("/product")
    public String greetingForm(Model model) {
        model.addAttribute("product", new Product());
        return "productAddForm";
    }

    @PostMapping(value="/product", params= {"save"})
    public String greetingSubmit(@ModelAttribute Product product) {
        return "result";
    }
    
    @PostMapping(value="/product", params={"addRow"})
    public String addRow(final Product product) {
        product.getNutrients().add(new Nutrient());
        return "productAddForm";
    }
    
    @PostMapping(value="/product", params={"removeRow"})
    public String removeRow(Product product, final HttpServletRequest req) {
        final Integer rowId = Integer.valueOf(req.getParameter("removeRow"));
        product.getNutrients().remove(rowId.intValue());
        product.getNutrients().trimToSize();
        return "productAddForm";
    }
    
    //Edit product from
    
    //Delete product
}

