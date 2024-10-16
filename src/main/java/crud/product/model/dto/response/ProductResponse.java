package crud.product.model.dto.response;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class ProductResponse {
    private int productId;
    private String productName;
    private String description;
    private double price;
    private String image_url;
    private boolean status;
    private Date created_at;
    private String catName;
}
