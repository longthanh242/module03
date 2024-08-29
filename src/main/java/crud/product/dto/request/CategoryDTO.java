package crud.product.dto.request;

import crud.product.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryDTO {
    @NotBlank(message = "Tên không để trống")
    private String categoryName;
    private String description;
    private List<Product> productList = new ArrayList<>();
}
