package al.ikubinfo.commons.controller;

import al.ikubinfo.commons.dto.BaseDto;
import al.ikubinfo.commons.service.AbstractService;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
public class AbstractController<
        DTO extends BaseDto,
        SERVICE extends AbstractService> {

    protected final SERVICE service;

    @GetMapping
    public ResponseEntity<List<DTO>> getList() {
        return new ResponseEntity<>(service.getList(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<DTO> getSingle(@PathVariable @NonNull Long id) {
        return new ResponseEntity<DTO>((DTO) service.getSingle(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DTO> save(
            @RequestBody @NotNull DTO dto) {
        return new ResponseEntity<DTO>((DTO) service.save(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTO> update(
            @RequestBody DTO unitCategoryDto, @PathVariable Long id) {
        return new ResponseEntity<DTO>(
                (DTO) service.update(id, unitCategoryDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
