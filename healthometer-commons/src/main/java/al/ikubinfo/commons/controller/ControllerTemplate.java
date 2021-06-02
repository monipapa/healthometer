package al.ikubinfo.commons.controller;

import al.ikubinfo.commons.dto.BaseCriteria;
import al.ikubinfo.commons.dto.BaseDto;
import al.ikubinfo.commons.service.ServiceTemplate;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
public abstract class ControllerTemplate<
        DTO extends BaseDto,
        C extends BaseCriteria,
        SERVICE extends ServiceTemplate> {

    protected final SERVICE service;

    @GetMapping
    protected ResponseEntity<List<DTO>> getList() {
        return new ResponseEntity<>(service.getList(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    protected ResponseEntity<DTO> getSingle(@PathVariable @NonNull Long id) {
        return new ResponseEntity<>((DTO) service.getSingle(id), HttpStatus.OK);
    }

    @PostMapping
    protected ResponseEntity<DTO> save(
            @RequestBody @NotNull DTO dto) {
        return new ResponseEntity<>((DTO) service.save(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    protected ResponseEntity<DTO> update(
            @RequestBody DTO unitCategoryDto, @PathVariable Long id) {
        return new ResponseEntity<>(
                (DTO) service.update(id, unitCategoryDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    protected void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PostMapping(value = "/filter")
    public ResponseEntity<Page<?>> filter(@Nullable @RequestBody C criteria) {
        return new ResponseEntity<>(service.filter(criteria), HttpStatus.OK);
    }
}
