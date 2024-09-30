package web.project.quanlyvlxd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.sql.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExportInvoice extends Base{
    @ManyToOne(fetch = FetchType.LAZY)
    private Material exportMaterial;

    private Integer exportQuantity;

    private Date exportDate;

    private String distributor;
}
