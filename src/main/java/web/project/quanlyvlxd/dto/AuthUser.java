package web.project.quanlyvlxd.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthUser {
    private String username;
    private String password;
}
