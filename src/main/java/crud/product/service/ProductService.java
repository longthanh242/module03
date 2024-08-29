package crud.product.service;

import crud.product.dto.request.ProductDTO;
import crud.product.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> renderAll();

    Product findById(int productId);

    boolean createNewProduct(ProductDTO productDTO);

    boolean updateProduct(Product product);

    boolean deleteProduct(int productId);
}
