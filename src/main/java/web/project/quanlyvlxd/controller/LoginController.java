package web.project.quanlyvlxd.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.project.quanlyvlxd.dto.AuthUser;
import web.project.quanlyvlxd.service.AuthService;

@Controller
public class LoginController {
    @Autowired
    private AuthService authService;
    @RequestMapping("/login")
    public String login(Model model, HttpSession httpSession){
        if(httpSession.getAttribute("username") != null) {
            return "redirect:/dashboard";
        }
        AuthUser authUser = new AuthUser();
        model.addAttribute("authUser", authUser);
        return "auth/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute AuthUser authUser, HttpSession httpSession){
        if("admin".equals(authUser.getUsername()) && "admin".equals(authUser.getPassword())){
            httpSession.setAttribute("username", authUser.getUsername());
            return "redirect:/dashboard";
        }
        return "auth/login";
    }
}
