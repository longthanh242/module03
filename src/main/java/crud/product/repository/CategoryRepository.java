package crud.product.repository;

import crud.product.model.entity.Category;

import java.util.List;

public interface CategoryRepository {
    List<Category> renderAll();

    Category findById(int categoryId);

    boolean createNewCategory(Category category);

    boolean updateCategory(Category category);

    boolean deleteCategory(int categoryId);
}
