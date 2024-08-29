package crud.product.repository.imp;

import crud.product.model.Category;
import crud.product.repository.CategoryRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CategoryRepositoryImp implements CategoryRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Category> renderAll() {
        return entityManager.createQuery("from Category", Category.class).getResultList();
    }

    @Override
    public Category findById(int categoryId) {
        return entityManager.createQuery("from Category c where c.categoryId =: categoryId", Category.class)
                .setParameter("categoryId", categoryId).getSingleResult();
    }

    @Override
    @Transactional
    public boolean createNewCategory(Category category) {
        try {
            entityManager.persist(category);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean updateCategory(Category category) {
        try {
            entityManager.merge(category);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean deleteCategory(int categoryId) {
        try {
            Category categoryDelete = entityManager.find(Category.class, categoryId);
            entityManager.remove(categoryDelete);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
