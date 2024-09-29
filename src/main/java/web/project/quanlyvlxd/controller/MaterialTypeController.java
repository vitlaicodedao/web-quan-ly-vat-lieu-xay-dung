package web.project.quanlyvlxd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.project.quanlyvlxd.model.MaterialType;
import web.project.quanlyvlxd.service.MaterialTypeService;
import web.project.quanlyvlxd.service.SupplierService;

@Controller
@RequestMapping("/material-type")
public class MaterialTypeController {
    @Autowired
    private MaterialTypeService materialTypeService;

    @Autowired
    private SupplierService supplierService;
    @GetMapping("")
    public String index(Model model){
        model.addAttribute("materialTypes", materialTypeService.findAll());
        return "material-type/index";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("suppliers", supplierService.getAllSuppliers());
        model.addAttribute("materialType", new MaterialType());
        return "material-type/add-edit-material-type";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Integer id){
        MaterialType materialType = materialTypeService.findById(id);
        model.addAttribute("materialType", materialType);
        model.addAttribute("suppliers", supplierService.getAllSuppliers());
        return "material-type/add-edit-material-type";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        materialTypeService.deleteById(id);
        return "redirect:/material-type";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute MaterialType materialType){
        materialTypeService.save(materialType);
        return "redirect:/material-type";
    }
}
