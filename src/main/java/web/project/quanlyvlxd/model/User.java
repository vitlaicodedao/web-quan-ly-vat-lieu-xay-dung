package web.project.quanlyvlxd.model;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User extends Base{
    private String name;
    private Integer age;
    private String phone;
    private String address;
    private String username;
    private String password;
}
