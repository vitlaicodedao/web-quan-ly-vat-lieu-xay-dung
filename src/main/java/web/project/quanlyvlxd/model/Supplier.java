package web.project.quanlyvlxd.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Supplier extends Base{
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplier")
    List<MaterialType> materialTypes;
}
