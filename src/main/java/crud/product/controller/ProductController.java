package crud.product.controller;

import crud.product.dto.request.ProductDTO;
import crud.product.model.Product;
import crud.product.service.CategoryService;
import crud.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productController")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/renderAllProduct")
    public String renderAllCategory(Model model){
        model.addAttribute("productList", productService.renderAll());
        return "products";
    }
    @GetMapping("/initCreateProduct")
    public String initCreateNewCategory(Model model){
        model.addAttribute("productDTO", new ProductDTO());
        model.addAttribute("categoryList", categoryService.renderAll());
        return "createNewProduct";
    }
    @PostMapping("/create")
    public String createNewProduct(ProductDTO productDTO){
        boolean result = productService.createNewProduct(productDTO);
        if (result)
            return "redirect:renderAllProduct";
        return "error";
    }
    @GetMapping("/initUpdateProduct")
    public String initUpdateProduct(int productId, Model model){
        Product productUpdate = productService.findById(productId);
        model.addAttribute("productUpdate", productUpdate);
        model.addAttribute("categoryList", categoryService.renderAll());
        return "updateProduct";
    }
    @PostMapping("/update")
    public String updateProduct(Product product){
        boolean result = productService.updateProduct(product);
        if (result)
            return "redirect:renderAllProduct";
        return "error";
    }
    @GetMapping("/delete")
    public String deleteProduct(int productId){
        boolean result = productService.deleteProduct(productId);
        if (result)
            return "redirect:renderAllProduct";
        return "error";
    }
}
