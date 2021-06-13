package al.ikubinfo.healthometer.activity.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import al.ikubinfo.commons.utils.JsonUtils;
import al.ikubinfo.healthometer.HealthometerApp;
import al.ikubinfo.healthometer.HealthometerTestSupport;
import al.ikubinfo.healthometer.activity.dto.MeasurementDto;
import al.ikubinfo.healthometer.measurement.dto.MeasurementCategoryDto;
import al.ikubinfo.healthometer.unit.dto.UnitSubcategoryDto;
import al.ikubinfo.healthometer.users.dto.AuthDto;
import al.ikubinfo.healthometer.users.dto.UserDto;
import java.math.BigDecimal;
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
public class MeasurementRestControllerTest extends HealthometerTestSupport {

  private static String TOKEN = "";
  private String URL = "/bodyMeasurements";

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
  void getValidMeasurement() {
    assertEquals(
        "admin", createGet(URL + "/1", MeasurementDto.class, TOKEN).getUserDto().getUsername());
  }

  @Test
  void getInvalidMeasurement() {
    assertThrows(Exception.class, () -> createGet(URL + "/100", MeasurementDto.class, TOKEN));
  }

  @Test
  // TODO
  void createValidMeasurement() {
    assertAll(() -> createPost(URL, getMeasurement(), MeasurementDto.class, TOKEN));
  }

  @Test
  void editValidMeasurement() {
    assertAll(() -> createPut(URL + "/1", getMeasurement(), MeasurementDto.class, TOKEN));
  }

  @Test
  void deleteValidMeasurement() {
    assertAll(() -> createDelete(URL + "/1", TOKEN));
  }

  private MeasurementDto getMeasurement() {
    MeasurementDto measurementDto = new MeasurementDto();
    measurementDto.setValue(new BigDecimal(53));
    measurementDto.setBodyMeasurementCategoryDto(getMeasurementCategory());
    measurementDto.setUnitSubcategoryDto(getUnitSubcategory());
    measurementDto.setUserDto(getUser());
    return measurementDto;
  }

  private UnitSubcategoryDto getUnitSubcategory() {
    UnitSubcategoryDto unitSubcategoryDto = new UnitSubcategoryDto();
    unitSubcategoryDto.setId(1l);
    return unitSubcategoryDto;
  }

  private MeasurementCategoryDto getMeasurementCategory() {
    MeasurementCategoryDto measurementCategoryDto = new MeasurementCategoryDto();
    measurementCategoryDto.setId(1l);
    return measurementCategoryDto;
  }

  private UserDto getUser() {
    UserDto userDto = new UserDto();
    userDto.setId(1l);
    return userDto;
  }
}
