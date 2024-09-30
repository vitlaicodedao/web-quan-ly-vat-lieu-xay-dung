package web.project.quanlyvlxd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.project.quanlyvlxd.model.ExportInvoice;
import web.project.quanlyvlxd.model.Material;
import web.project.quanlyvlxd.service.ExportInvoiceService;
import web.project.quanlyvlxd.service.MaterialService;

@Controller
@RequestMapping("/export-invoice")
public class ExportInvoiceController {
    @Autowired
    private ExportInvoiceService exportInvoiceService;

    @Autowired
    private MaterialService materialService;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("exportInvoices", exportInvoiceService.findAll());
        return "export-invoice/index";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("exportInvoice", new ExportInvoice());
        model.addAttribute("materials", materialService.findAll());
        return "export-invoice/add-edit-export-invoice";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute ExportInvoice exportInvoice, Model model){
        Material material = materialService.getById(exportInvoice.getExportMaterial().getId());
        if(material.getQuantity() <= exportInvoice.getExportQuantity()){
            model.addAttribute("error", "Vui lòng xuất số lượng nhỏ hơn. Số lượng tồn kho chỉ còn " + material.getQuantity());
            model.addAttribute("exportInvoice", exportInvoice);
            model.addAttribute("materials", materialService.findAll());
            return "export-invoice/add-edit-export-invoice";
        }
        else{
            material.setQuantity(material.getQuantity() - exportInvoice.getExportQuantity());
            materialService.save(material);
            exportInvoiceService.save(exportInvoice);
            return "redirect:/export-invoice";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        ExportInvoice exportInvoice = exportInvoiceService.findById(id);
        Material material = materialService.getById(exportInvoice.getExportMaterial().getId());
        material.setQuantity(material.getQuantity() + exportInvoice.getExportQuantity());
        materialService.save(material);
        exportInvoiceService.deleteById(id);
        return "redirect:/export-invoice";
    }
}
