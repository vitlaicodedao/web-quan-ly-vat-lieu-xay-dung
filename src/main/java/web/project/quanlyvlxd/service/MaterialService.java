package web.project.quanlyvlxd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import web.project.quanlyvlxd.dto.MaterialDto;
import web.project.quanlyvlxd.model.Material;
import web.project.quanlyvlxd.model.MaterialType;
import web.project.quanlyvlxd.repository.MaterialRepository;
import web.project.quanlyvlxd.repository.MaterialTypeRepository;
import web.project.quanlyvlxd.util.FileUtil;

import java.util.List;

@Service
public class MaterialService {
    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private MaterialTypeRepository materialTypeRepository;

    public List<Material> findAll() {
        return materialRepository.findAll();
    }

    public void deleteById(Integer id) {
        materialRepository.deleteById(id);
    }

    public void save(MaterialDto materialDto) {
        Material material = mapDtoToObj(materialDto);
        materialRepository.save(material);
        String savedFileResult = FileUtil.saveFile(materialDto.getImage());
        System.out.println(savedFileResult);
    }

    public void save(Material material){
        materialRepository.save(material);
    }

    private Material mapDtoToObj(MaterialDto materialDto){
        MaterialType materialType = materialTypeRepository.findById(materialDto.getMaterialTypeId()).get();
        Material material = Material.builder()
                .name(materialDto.getName())
                .price(materialDto.getPrice())
                .origin(materialDto.getOrigin())
                .quantity(materialDto.getQuantity())
                .soldQuantity(materialDto.getSoldQuantity())
                .materialType(materialType)
                .image(materialDto.getImage().getOriginalFilename())
                .build();
        material.setId(materialDto.getId());
        return material;
    }

    public Material getById(Integer id){
        return materialRepository.findById(id).get();
    }

    public MaterialDto mapObjToDto(Material material) {
        return MaterialDto.builder()
                .id(material.getId())
                .name(material.getName())
                .price(material.getPrice())
                .origin(material.getOrigin())
                .quantity(material.getQuantity())
                .soldQuantity(material.getSoldQuantity())
                .materialTypeId(material.getMaterialType().getId())
                .imageName(material.getImage()).build();
    }
}
