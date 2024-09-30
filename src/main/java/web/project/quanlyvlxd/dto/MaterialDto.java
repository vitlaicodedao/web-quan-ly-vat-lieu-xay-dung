package web.project.quanlyvlxd.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MaterialDto {
    private Integer id;
    private String name;
    private Double price;
    private Integer quantity;
    private Integer soldQuantity;
    private String origin;
    private Integer materialTypeId;
    private MultipartFile image;
    private String imageName;
}
