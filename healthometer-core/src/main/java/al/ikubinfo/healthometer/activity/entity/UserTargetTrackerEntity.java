package al.ikubinfo.healthometer.activity.entity;

import al.ikubinfo.commons.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(schema = "healthometer", name = "user_target_tracker")
@Getter
@Setter
public class UserTargetTrackerEntity extends BaseEntity {
}
