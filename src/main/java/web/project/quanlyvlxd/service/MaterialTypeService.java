package web.project.quanlyvlxd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.project.quanlyvlxd.model.MaterialType;
import web.project.quanlyvlxd.repository.MaterialTypeRepository;

import java.util.List;

@Service
public class MaterialTypeService {
    @Autowired
    private MaterialTypeRepository materialTypeRepository;

    public List<MaterialType> findAll() {
        return materialTypeRepository.findAll();
    }

    public void save(MaterialType materialType) {
        materialTypeRepository.save(materialType);
    }

    public MaterialType findById(Integer id) {
        return materialTypeRepository.findById(id).get();
    }

    public void deleteById(Integer id) {
        materialTypeRepository.deleteById(id);
    }
}
