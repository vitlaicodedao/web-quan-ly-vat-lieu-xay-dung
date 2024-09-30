package web.project.quanlyvlxd.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.project.quanlyvlxd.model.ImportInvoice;

@Repository
public interface ImportInvoiceRepository extends JpaRepository<ImportInvoice, Integer> {
}
