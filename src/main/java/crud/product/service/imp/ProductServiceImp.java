package crud.product.service.imp;

import crud.product.model.dto.request.ProductDTO;
import crud.product.model.dto.response.ProductResponse;
import crud.product.model.entity.Product;
import crud.product.repository.ProductRepository;
import crud.product.service.ProductService;
import crud.product.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UploadFileService uploadFileService;

    @Override
    public List<ProductResponse> renderAll() {
        List<Product> productList = productRepository.renderAll();
        return productList.stream()
                .map(product -> new ProductResponse(
                        product.getProductId(),
                        product.getProductName(),
                        product.getDescription(),
                        product.getPrice(),
                        product.getImage_url(),
                        product.isStatus(),
                        product.getCreated_at(),
                        product.getCategory().getCategoryName()
                ))
                .collect(Collectors.toList());
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
    public boolean updateProduct(int productId, ProductDTO productDTO) {
        Product existingProduct = productRepository.findById(productId);
        String imgUrl = existingProduct.getImage_url(); // Default to the existing image URL

        // Check if a new image is provided
        if (productDTO.getImage() != null) {
            imgUrl = uploadFileService.uploadFileToLocal(productDTO.getImage());
        }
        Product product = Product.builder()
                .productId(productId)
                .productName(productDTO.getProductName())
                .description(productDTO.getDescription())
                .price(productDTO.getPrice())
                .image_url(imgUrl)
                .created_at(productDTO.getCreated_at())
                .category(productDTO.getCategory())
                .status(productDTO.isStatus())
                .build();
        return productRepository.updateProduct(product);
    }

    @Override
    public boolean deleteProduct(int productId) {
        return productRepository.deleteProduct(productId);
    }
}
