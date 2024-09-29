package web.project.quanlyvlxd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.project.quanlyvlxd.model.Supplier;
import web.project.quanlyvlxd.service.SupplierService;

@Controller
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;
    @GetMapping("")
    public String suppliers(Model model){
        model.addAttribute("suppliers", supplierService.getAllSuppliers());
        return "supplier/index";
    }

    @GetMapping("/add")
    public String addSupplier(Model model){
        model.addAttribute("supplier", new Supplier());
        return "supplier/add-edit-supplier";
    }

    @GetMapping("/edit/{id}")
    public String editSupplier(@PathVariable Integer id, Model model){
        Supplier supplier = supplierService.findById(id);
        model.addAttribute("supplier", supplier);
        return "supplier/add-edit-supplier";
    }

    @PostMapping("/save")
    public String saveSupplier(@ModelAttribute Supplier supplier){
        supplierService.save(supplier);
        return "redirect:/supplier";
    }

    @GetMapping("/delete/{id}")
    public String deleteSupplier(@PathVariable Integer id){
        supplierService.delete(id);
        return "redirect:/supplier";
    }
}
