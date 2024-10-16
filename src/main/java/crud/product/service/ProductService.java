package crud.product.service;

import crud.product.model.dto.request.ProductDTO;
import crud.product.model.dto.response.ProductResponse;
import crud.product.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<ProductResponse> renderAll();

    Product findById(int productId);

    boolean createNewProduct(ProductDTO productDTO);

    boolean updateProduct(int productId, ProductDTO productDTO);

    boolean deleteProduct(int productId);
}
