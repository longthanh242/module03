package crud.product.controller;

import crud.product.dto.request.CategoryDTO;
import crud.product.model.Category;
import crud.product.service.CategoryService;
import crud.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/categoryController")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/renderAll")
    public String renderAllCategory(Model model){
        model.addAttribute("categoryList", categoryService.renderAll());
        return "categories";
    }
    @GetMapping("/initCreate")
    public String initCreateNewCategory(Model model){
        model.addAttribute("categoryDTO", new CategoryDTO());
        model.addAttribute("categoryList", categoryService.renderAll());
        return "createNewCategory";
    }
    @PostMapping("/create")
    public String createNewCategory(@Valid CategoryDTO categoryDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return "createNewCategory";
        boolean result = categoryService.createNewCategory(categoryDTO);
        if (result)
            return "redirect:renderAll";
        return "error";
    }
    @GetMapping("/initUpdate")
    public String initUpdateCategory(int categoryId, Model model){
        Category categoryUpdate = categoryService.findById(categoryId);
        model.addAttribute("categoryUpdate", categoryUpdate);
        return "updateCategory";
    }
    @PostMapping("/update")
    public String updateCategory(Category category){
        boolean result = categoryService.updateCategory(category);
        if (result)
            return "redirect:renderAll";
        return "error";
    }
    @GetMapping("/delete")
    public String deleteCategory(int categoryId){
        boolean result = categoryService.deleteCategory(categoryId);
        if (result)
            return "redirect:renderAll";
        return "error";
    }
}
