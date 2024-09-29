package web.project.quanlyvlxd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.project.quanlyvlxd.model.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}
