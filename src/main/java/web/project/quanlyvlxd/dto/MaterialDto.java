package web.project.quanlyvlxd.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MaterialDto {
    private String id;
    private String name;
    private Double price;
    private Integer quantity;
    private Integer soldQuantity;
    private String origin;
    private Integer materialTypeId;
    private MultipartFile image;
}
