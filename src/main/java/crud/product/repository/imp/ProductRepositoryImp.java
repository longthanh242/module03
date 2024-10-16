package crud.product.repository.imp;

import crud.product.model.entity.Product;
import crud.product.repository.ProductRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProductRepositoryImp implements ProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> renderAll() {
        return entityManager.createQuery("from Product", Product.class).getResultList();
    }

    @Override
    public Product findById(int productId) {
        return entityManager.createQuery("from Product p where p.productId =: productId", Product.class)
                .setParameter("productId", productId).getSingleResult();
    }

    @Override
    @Transactional
    public boolean createNewProduct(Product product) {
        try {
            entityManager.persist(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean updateProduct(Product product) {
        try {
            entityManager.merge(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean deleteProduct(int productId) {
        try {
            Product productDelete = entityManager.find(Product.class, productId);
            entityManager.remove(productDelete);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
