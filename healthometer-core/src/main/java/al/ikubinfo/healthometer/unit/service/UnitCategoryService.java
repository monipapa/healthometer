package al.ikubinfo.healthometer.unit.service;

import al.ikubinfo.commons.service.ServiceTemplate;
import al.ikubinfo.healthometer.unit.dto.UnitCategoryDto;
import al.ikubinfo.healthometer.unit.entity.UnitCategoryEntity;
import al.ikubinfo.healthometer.unit.mappers.UnitCategoryMapper;
import al.ikubinfo.healthometer.unit.repository.UnitCategoryRepository;
import org.springframework.stereotype.Service;

@Service
//TODO
public class UnitCategoryService
        extends ServiceTemplate<
        UnitCategoryEntity, UnitCategoryDto, UnitCategoryMapper, UnitCategoryRepository> {
    public UnitCategoryService(UnitCategoryRepository repository, UnitCategoryMapper mapper) {
        super(repository, mapper);
    }
}
