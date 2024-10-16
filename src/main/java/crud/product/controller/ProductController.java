package crud.product.controller;

import crud.product.model.dto.request.ProductDTO;
import crud.product.model.entity.Product;
import crud.product.service.CategoryService;
import crud.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/productController")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/renderAll")
    public String renderAllCategory(Model model) {
        model.addAttribute("productList", productService.renderAll());
        return "products";
    }

    @GetMapping("/initCreate")
    public String initCreateNewCategory(Model model) {
        model.addAttribute("productDTO", new ProductDTO());
        model.addAttribute("categoryList", categoryService.renderAll());
        return "createNewProduct";
    }

    @PostMapping("/create")
    public String createNewProduct(@Valid ProductDTO productDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categoryList", categoryService.renderAll());
            return "createNewProduct";
        }
        boolean result = productService.createNewProduct(productDTO);
        if (result)
            return "redirect:renderAll";
        return "error";
    }

    @GetMapping("/initUpdate")
    public String initUpdateProduct(int productId, Model model) {
        Product productUpdate = productService.findById(productId);
        model.addAttribute("productUpdate", productUpdate);
        model.addAttribute("categoryList", categoryService.renderAll());
        return "updateProduct";
    }

    @PostMapping("/update")
    public String updateProduct(@Valid @ModelAttribute("productUpdate") ProductDTO productDTO, int productId, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categoryList", categoryService.renderAll());
            return "updateProduct";
        }
        boolean result = productService.updateProduct(productId, productDTO);
        if (result)
            return "redirect:renderAll";
        return "error";
    }

    @GetMapping("/delete")
    public String deleteProduct(int productId) {
        boolean result = productService.deleteProduct(productId);
        if (result)
            return "redirect:renderAll";
        return "error";
    }
}
