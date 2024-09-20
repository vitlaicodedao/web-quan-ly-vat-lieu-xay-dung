package web.project.quanlyvlxd.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Material extends Base{
    private String name;
    private String image;
    private Double price;
    private Integer quantity;
    private Integer soldQuantity;
    private String origin;

    @ManyToOne(fetch = FetchType.LAZY)
    private MaterialType materialType;

    @OneToMany(mappedBy = "material")
    private List<OrderDetail> orderDetails;
}
