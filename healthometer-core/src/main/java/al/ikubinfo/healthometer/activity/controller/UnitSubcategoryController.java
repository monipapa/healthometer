package al.ikubinfo.healthometer.activity.controller;

import al.ikubinfo.healthometer.activity.dto.UnitSubcategoryDto;
import al.ikubinfo.healthometer.activity.entity.UnitSubcategoryEntity;
import al.ikubinfo.healthometer.activity.service.UnitSubcategoryService;
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
@RequestMapping("unitSubategories")
@AllArgsConstructor
public class UnitSubcategoryController {
  private final UnitSubcategoryService unitSubcategoryService;

  @PreAuthorize("hasAnyAuthority('admin','user')")
  @ApiOperation(value = "Get List of Unit Subcategories")
  @GetMapping
  public ResponseEntity<List<UnitSubcategoryDto>> getList() {
    return new ResponseEntity<>(unitSubcategoryService.getList(), HttpStatus.OK);
  }

  @PreAuthorize("hasAnyAuthority('admin','user')")
  @ApiOperation(value = "Get List of Unit Subcategory")
  @GetMapping("{id}")
  public ResponseEntity<UnitSubcategoryDto> getSingle(@PathVariable @NonNull Long id) {
    return new ResponseEntity<>(unitSubcategoryService.getSingle(id), HttpStatus.OK);
  }

  @PreAuthorize("hasAnyAuthority('admin')")
  @ApiOperation(value = "Add a new Unit Subcategory")
  @PostMapping
  public ResponseEntity<UnitSubcategoryDto> save(
      @RequestBody @NotNull UnitSubcategoryDto unitSubcategoryDto) {
    return new ResponseEntity<>(
        unitSubcategoryService.save(unitSubcategoryDto), HttpStatus.CREATED);
  }

  @PreAuthorize("hasAnyAuthority('admin')")
  @ApiOperation(value = "Update an existing Unit Subcategory")
  @PutMapping("/{id}")
  public ResponseEntity<UnitSubcategoryDto> update(
      @RequestBody @NotNull UnitSubcategoryDto unitSubcategoryDto, @PathVariable @NonNull Long id) {
    return new ResponseEntity<>(
        unitSubcategoryService.update(id, unitSubcategoryDto), HttpStatus.CREATED);
  }

  @PreAuthorize("hasAnyAuthority('admin')")
  @ApiOperation(value = "Delete an existing Unit Subcategory")
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id) {
    unitSubcategoryService.delete(id);
  }
}
