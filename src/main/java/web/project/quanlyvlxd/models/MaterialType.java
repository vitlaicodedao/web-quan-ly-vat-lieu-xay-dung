package web.project.quanlyvlxd.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class MaterialType extends Base{
    private String name;

    @OneToMany(mappedBy = "materialType", cascade = CascadeType.ALL)
    List<Material> materials;
}
