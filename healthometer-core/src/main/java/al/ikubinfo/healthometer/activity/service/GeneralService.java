package al.ikubinfo.healthometer.activity.service;

import al.ikubinfo.commons.entity.BaseEntity;

import java.util.List;
import java.util.Map;

public interface GeneralService<T extends BaseEntity> {
    T save(T examEntity);

    T update(Long id, T examEntity);

    T getSingle(Long id);

    void delete(Long id);

    List<T> getList(Map<String, String> allParams);
}
