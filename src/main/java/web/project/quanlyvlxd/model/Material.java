package web.project.quanlyvlxd.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
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
    @Positive
    private Double price;
    @Positive
    private Integer quantity;
    @Positive
    private Integer soldQuantity;
    private String origin;

    @ManyToOne(fetch = FetchType.LAZY)
    private MaterialType materialType;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "importMaterial")
    List<ImportInvoice> importInvoices;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "exportMaterial")
    List<ExportInvoice> exportInvoices;
}
