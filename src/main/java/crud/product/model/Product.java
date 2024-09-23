package crud.product.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;
    @Column(name = "product_name", columnDefinition = "varchar(100)", nullable = false)
    private String productName;
    @Column(name = "description", columnDefinition = "text")
    private String description;
    @Column(name = "price", columnDefinition="double check(price>0)", nullable = false)
    private double price;
    @Column(name = "image_url", columnDefinition = "varchar(255)")
    private String image_url;
    @Column(name = "status")
    private boolean status;
    @Column(name = "created_at")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date created_at;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;
}
