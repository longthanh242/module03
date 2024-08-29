package crud.product.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Category")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int categoryId;
    @Column(name = "category_name", columnDefinition = "varchar(50)", nullable = false, unique = true)
    private String categoryName;
    @Column(name = "category_desc", columnDefinition = "text")
    private String description;
    @Column(name = "status")
    private boolean status;
    @OneToMany(mappedBy = "category")
    private List<Product> productList = new ArrayList<>();
}
