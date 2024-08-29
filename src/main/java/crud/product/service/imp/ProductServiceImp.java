package crud.product.service.imp;

import crud.product.dto.request.ProductDTO;
import crud.product.model.Product;
import crud.product.repository.ProductRepository;
import crud.product.service.ProductService;
import crud.product.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UploadFileService uploadFileService;
    @Override
    public List<Product> renderAll() {
        return productRepository.renderAll();
    }

    @Override
    public Product findById(int productId) {
        return productRepository.findById(productId);
    }

    @Override
    public boolean createNewProduct(ProductDTO productDTO) {
        // 1. Upload File lên Firebase --> URL file trên firebase
        String imgUrlFirebase = uploadFileService.uploadFileToLocal(productDTO.getImage());
        // 2. Chuyển DTO --> entity
        Product product = Product.builder()
                .productName(productDTO.getProductName())
                .description(productDTO.getDescription())
                .price(productDTO.getPrice())
                .image_url(imgUrlFirebase)
                .status(true)
                .created_at(productDTO.getCreated_at())
                .category(productDTO.getCategory())
                .build();
        return productRepository.createNewProduct(product);
    }

    @Override
    public boolean updateProduct(Product product) {
        return productRepository.updateProduct(product);
    }

    @Override
    public boolean deleteProduct(int productId) {
        return productRepository.deleteProduct(productId);
    }
}
