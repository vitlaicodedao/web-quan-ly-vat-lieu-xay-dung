package web.project.quanlyvlxd.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {
    @RequestMapping({"/", "/dashboard"})
    public String home(HttpSession httpSession){
        if(httpSession.getAttribute("username") == null) {
            return "redirect:/login";
        }
        return "dashboard/index";
    }
}
