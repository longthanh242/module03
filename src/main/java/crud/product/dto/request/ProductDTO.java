package crud.product.dto.request;

import crud.product.model.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDTO {
    @NotBlank(message = "Tên không để trống")
    private String productName;
    private String description;
    @Min(value = 1, message = "Giá phải lớn hơn 0")
    private double price;
    private MultipartFile image;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date created_at;
    private Category category;
}
