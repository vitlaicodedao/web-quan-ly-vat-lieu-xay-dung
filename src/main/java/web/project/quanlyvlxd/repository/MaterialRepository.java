package web.project.quanlyvlxd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.project.quanlyvlxd.model.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer> {
}
