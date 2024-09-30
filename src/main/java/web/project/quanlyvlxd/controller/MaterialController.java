package web.project.quanlyvlxd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import web.project.quanlyvlxd.dto.MaterialDto;
import web.project.quanlyvlxd.model.Material;
import web.project.quanlyvlxd.service.MaterialService;
import web.project.quanlyvlxd.service.MaterialTypeService;

@Controller
@RequestMapping("/material")
public class MaterialController {
    @Autowired
    private MaterialService materialService;

    @Autowired
    private MaterialTypeService materialTypeService;

    @GetMapping("")
    public String materials(Model model){
        model.addAttribute("materials", materialService.findAll());
        return "material/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteMaterial(@PathVariable Integer id){
        materialService.deleteById(id);
        return "redirect:/material";
    }

    @GetMapping("/add")
    public String addMaterial(Model model){
        model.addAttribute("materialTypes", materialTypeService.findAll());
        model.addAttribute("material", new MaterialDto());
        return "material/add-edit-material";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("material") MaterialDto materialDto){
        materialService.save(materialDto);
        return "redirect:/material";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        Material material = materialService.getById(id);
        MaterialDto materialDto = materialService.mapObjToDto(material);
        model.addAttribute("material", materialDto);
        model.addAttribute("materialTypes", materialTypeService.findAll());
        return "material/add-edit-material";
    }
}
