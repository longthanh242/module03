package crud.product.service;

import crud.product.model.dto.request.CategoryDTO;
import crud.product.model.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> renderAll();

    Category findById(int categoryId);

    boolean createNewCategory(CategoryDTO categoryDTO);

    boolean updateCategory(int categoryId, CategoryDTO categoryDTO);

    boolean deleteCategory(int categoryId);
}
