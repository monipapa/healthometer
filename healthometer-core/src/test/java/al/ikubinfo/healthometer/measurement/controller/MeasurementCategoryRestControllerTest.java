package al.ikubinfo.healthometer.measurement.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import al.ikubinfo.commons.utils.JsonUtils;
import al.ikubinfo.healthometer.HealthometerApp;
import al.ikubinfo.healthometer.HealthometerTestSupport;
import al.ikubinfo.healthometer.measurement.dto.MeasurementCategoryDto;
import al.ikubinfo.healthometer.unit.dto.UnitCategoryDto;
import al.ikubinfo.healthometer.users.dto.AuthDto;
import lombok.val;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = HealthometerApp.class)
@Transactional
public class MeasurementCategoryRestControllerTest extends HealthometerTestSupport {

  private String URL = "/measurementCategories";
  private static String TOKEN = "";

  @BeforeAll
  static void setup(@Autowired MockMvc mockMvc) {
    val authDto = AuthDto.builder().username("admin").password("password").valid(false).build();
    try {
      TOKEN =
          mockMvc
              .perform(
                  MockMvcRequestBuilders.post("/auth")
                      .contentType(MediaType.APPLICATION_JSON)
                      .content(JsonUtils.toJsonString(authDto)))
              .andExpect(status().isOk())
              .andReturn()
              .getResponse()
              .getHeader("Authorization");

    } catch (Exception e) {
      ExceptionUtils.rethrow(e);
      TOKEN = "";
    }
  }

  @Test
  void getValidMeasurementCategory() {
    assertEquals("Weight", createGet(URL + "/1", MeasurementCategoryDto.class, TOKEN).getName());
  }

  @Test
  void getInvalidMeasurementCategory() {
    assertThrows(
        Exception.class, () -> createGet(URL + "/100", MeasurementCategoryDto.class, TOKEN));
  }

  @Test
  // TODO
  void createValidMeasurementCategory() {
    assertAll(() -> createPost(URL, getMeasurementCategory(), MeasurementCategoryDto.class, TOKEN));
  }

  @Test
  void editValidMeasurementCategory() {
    assertAll(
        () -> createPut(URL + "/1", getMeasurementCategory(), MeasurementCategoryDto.class, TOKEN));
  }

  @Test
  void deleteValidMeasurementCategory() {
    assertAll(() -> createDelete(URL + "/1", TOKEN));
  }

  private MeasurementCategoryDto getMeasurementCategory() {
    MeasurementCategoryDto measurementCategoryDto = new MeasurementCategoryDto();
    measurementCategoryDto.setName("New measurement category");
    measurementCategoryDto.setDescription("New measurement category");
    measurementCategoryDto.setUnitCategoryDto(getUnitCategory());
    return measurementCategoryDto;
  }

  private UnitCategoryDto getUnitCategory() {
    UnitCategoryDto unitCategoryDto = new UnitCategoryDto();
    unitCategoryDto.setId(2l);
    return unitCategoryDto;
  }
}
