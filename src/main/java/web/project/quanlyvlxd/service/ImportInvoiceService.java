package web.project.quanlyvlxd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.project.quanlyvlxd.model.ImportInvoice;
import web.project.quanlyvlxd.repository.ImportInvoiceRepository;

import java.util.List;

@Service
public class ImportInvoiceService {
    @Autowired
    private ImportInvoiceRepository importInvoiceRepository;

    public List<ImportInvoice> findAll(){
        return importInvoiceRepository.findAll();
    }

    public void save(ImportInvoice importInvoice) {
        importInvoiceRepository.save(importInvoice);
    }

    public ImportInvoice findById(Integer id) {
        return importInvoiceRepository.findById(id).get();
    }

    public void deleteById(Integer id) {
        importInvoiceRepository.deleteById(id);
    }
}
