package crud.product.service.imp;

import crud.product.dto.request.CategoryDTO;
import crud.product.model.Category;
import crud.product.repository.CategoryRepository;
import crud.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> renderAll() {
        return categoryRepository.renderAll();
    }

    @Override
    public Category findById(int categoryId) {
        return categoryRepository.findById(categoryId);
    }

    @Override
    public boolean createNewCategory(CategoryDTO categoryDTO) {
        Category category = Category.builder()
                .categoryName(categoryDTO.getCategoryName())
                .description(categoryDTO.getDescription())
                .status(true)
                .build();
        return categoryRepository.createNewCategory(category);
    }

    @Override
    public boolean updateCategory(Category category) {
        return categoryRepository.updateCategory(category);
    }

    @Override
    public boolean deleteCategory(int categoryId) {
        return categoryRepository.deleteCategory(categoryId);
    }
}
