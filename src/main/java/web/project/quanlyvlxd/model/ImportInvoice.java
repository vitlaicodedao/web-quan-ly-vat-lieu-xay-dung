package web.project.quanlyvlxd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.sql.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImportInvoice extends Base{
    @ManyToOne(fetch = FetchType.LAZY)
    private Material importMaterial;

    private Date importDate;

    private Integer importQuantity;
}
