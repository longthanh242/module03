package crud.product.repository;

import crud.product.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> renderAll();
    Product findById(int productId);
    boolean createNewProduct(Product product);
    boolean updateProduct(Product product);
    boolean deleteProduct(int productId);
}
