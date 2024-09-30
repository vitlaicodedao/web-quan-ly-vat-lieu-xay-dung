package web.project.quanlyvlxd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.project.quanlyvlxd.model.ImportInvoice;
import web.project.quanlyvlxd.model.Material;
import web.project.quanlyvlxd.service.ImportInvoiceService;
import web.project.quanlyvlxd.service.MaterialService;

@Controller
@RequestMapping("/import-invoice")
public class ImportInvoiceController {
    @Autowired
    private ImportInvoiceService importInvoiceService;
    @Autowired
    private MaterialService materialService;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("importInvoices", importInvoiceService.findAll());
        return "import-invoice/index";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("importInvoice", new ImportInvoice());
        model.addAttribute("materials", materialService.findAll());
        return "import-invoice/add-edit-import-invoice";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        ImportInvoice importInvoice = importInvoiceService.findById(id);
        Material material = materialService.getById(importInvoice.getImportMaterial().getId());
        material.setQuantity(material.getQuantity() - importInvoice.getImportQuantity());
        materialService.save(material);
        importInvoiceService.deleteById(id);
        return "redirect:/import-invoice";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute ImportInvoice importInvoice){
        importInvoiceService.save(importInvoice);
        Material material = materialService.getById(importInvoice.getImportMaterial().getId());
        material.setQuantity(material.getQuantity() + importInvoice.getImportQuantity());
        materialService.save(material);
        return "redirect:/import-invoice";
    }
}
