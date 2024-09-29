package web.project.quanlyvlxd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.project.quanlyvlxd.model.Supplier;
import web.project.quanlyvlxd.repository.SupplierRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> getAllSuppliers(){
        return supplierRepository.findAll();
    }

    public void save(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    public Supplier findById(Integer id) {
        Optional<Supplier> supplier =supplierRepository.findById(id);
        return supplier.orElse(null);
    }

    public void delete(Integer id) {
        supplierRepository.deleteById(id);
    }
}
