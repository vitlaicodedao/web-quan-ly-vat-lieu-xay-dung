package web.project.quanlyvlxd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.project.quanlyvlxd.dto.AuthUser;
import web.project.quanlyvlxd.model.User;
import web.project.quanlyvlxd.repository.UserRepository;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    public boolean hasCorrectCredentials(AuthUser authUser){
        User user = userRepository.findUserByUsernameAndPassword(authUser.getUsername(), authUser.getPassword());
        return user != null;
    }
}
