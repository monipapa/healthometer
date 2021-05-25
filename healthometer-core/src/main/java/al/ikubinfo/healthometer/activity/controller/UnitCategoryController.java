package al.ikubinfo.healthometer.activity.controller;

import al.ikubinfo.healthometer.activity.dto.UnitCategoryDto;
import al.ikubinfo.healthometer.activity.entity.UnitCategoryEntity;
import al.ikubinfo.healthometer.activity.service.UnitCategoryService;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("unitCategories")
@AllArgsConstructor
public class UnitCategoryController {
  private final UnitCategoryService unitCategoryService;

  @PreAuthorize("hasAnyAuthority('admin','user')")
  @ApiOperation(value = "Get List of Unit Category")
  @GetMapping
  public ResponseEntity<List<UnitCategoryDto>> getList() {
    return new ResponseEntity<>(unitCategoryService.getList(), HttpStatus.OK);
  }

  @PreAuthorize("hasAnyAuthority('admin','user')")
  @ApiOperation(value = "Get List of Unit Category")
  @GetMapping("{id}")
  public ResponseEntity<UnitCategoryDto> getSingle(@PathVariable @NonNull Long id) {
    return new ResponseEntity<>(unitCategoryService.getSingle(id), HttpStatus.OK);
  }

  @PreAuthorize("hasAnyAuthority('admin')")
  @ApiOperation(value = "Add a new Unit Category")
  @PostMapping
  public ResponseEntity<UnitCategoryEntity> save(
      @RequestBody @NotNull UnitCategoryDto unitCategoryDto) {
    return new ResponseEntity<>(unitCategoryService.save(unitCategoryDto), HttpStatus.CREATED);
  }

  @PreAuthorize("hasAnyAuthority('admin')")
  @ApiOperation(value = "Update an existing Unit Category")
  @PutMapping("/{id}")
  public ResponseEntity<UnitCategoryEntity> update(
      @RequestBody UnitCategoryDto unitCategoryDto, @PathVariable Long id) {
    return new ResponseEntity<>(
        unitCategoryService.update(id, unitCategoryDto), HttpStatus.CREATED);
  }

  @PreAuthorize("hasAnyAuthority('admin')")
  @ApiOperation(value = "Delete an existing Unit Category")
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id) {
    unitCategoryService.delete(id);
  }
}
