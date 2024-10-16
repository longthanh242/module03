package crud.product.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int categoryId;
    @Column(name = "category_name", length = 50, nullable = false, unique = true)
    private String categoryName;
    @Column(columnDefinition = "text")
    private String description;
    private boolean status;
    @OneToMany(mappedBy = "category")
    private List<Product> productList = new ArrayList<>();
}
