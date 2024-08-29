package crud.product.service;

import crud.product.dto.request.CategoryDTO;
import crud.product.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> renderAll();
    Category findById(int categoryId);
    boolean createNewCategory(CategoryDTO categoryDTO);
    boolean updateCategory(Category category);
    boolean deleteCategory(int categoryId);
}
