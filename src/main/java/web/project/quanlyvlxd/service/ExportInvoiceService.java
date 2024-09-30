package web.project.quanlyvlxd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.project.quanlyvlxd.model.ExportInvoice;
import web.project.quanlyvlxd.repository.ExportInvoiceRepository;

import java.util.List;

@Service
public class ExportInvoiceService {
    @Autowired
    private ExportInvoiceRepository exportInvoiceRepository;

    public List<ExportInvoice> findAll(){
        return exportInvoiceRepository.findAll();
    }

    public ExportInvoice findById(Integer id){
        return exportInvoiceRepository.findById(id).get();
    }

    public void save(ExportInvoice exportInvoice) {
        exportInvoiceRepository.save(exportInvoice);
    }

    public void deleteById(Integer id) {
        exportInvoiceRepository.deleteById(id);
    }
}
