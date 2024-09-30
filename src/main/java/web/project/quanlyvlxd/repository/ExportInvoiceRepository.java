package web.project.quanlyvlxd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.project.quanlyvlxd.model.ExportInvoice;

@Repository
public interface ExportInvoiceRepository extends JpaRepository<ExportInvoice, Integer> {

}
