package al.ikubinfo.healthometer.unit.repository.criteria;

import al.ikubinfo.commons.dto.BaseCriteria;
import al.ikubinfo.healthometer.unit.entity.UnitCategoryEntity;
import al.ikubinfo.healthometer.unit.entity.UnitSubcategoryEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Data
public class UnitCategoryCriteria extends BaseCriteria {

}
