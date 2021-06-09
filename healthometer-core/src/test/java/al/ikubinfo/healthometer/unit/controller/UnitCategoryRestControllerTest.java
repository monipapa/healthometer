package al.ikubinfo.healthometer.unit.controller;

import al.ikubinfo.commons.utils.JsonUtils;
import al.ikubinfo.healthometer.HealthometerApp;
import al.ikubinfo.healthometer.HealthometerTestSupport;
import al.ikubinfo.healthometer.unit.dto.UnitCategoryDto;
import al.ikubinfo.healthometer.users.dto.*;
import lombok.val;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = HealthometerApp.class)
@Transactional
public class UnitCategoryRestControllerTest extends HealthometerTestSupport {

  private String URL = "/unitCategories";
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
  void getValidUnitCategory() {
    assertEquals("Weight", createGet(URL + "/1", UnitCategoryDto.class, TOKEN).getName());
  }

  @Test
  void getInvalidUnitCategory() {
    assertNotEquals("g", createGet(URL + "/1", UnitCategoryDto.class, TOKEN).getDefaultUnit());
  }

  @Test
  void getInvalidUnitCategory2() {
    assertThrows(Exception.class, () -> createGet(URL + "/100", UnitCategoryDto.class, TOKEN));
  }

  @Test
  void createValidUnitCategory() {
    assertAll(() ->  createPost(URL, getUnitCategory(), UnitCategoryDto.class, TOKEN));
  }

  @Test
  void editValidUnitCategory() {
    assertAll(() ->  createPut(URL + "/500", getUnitCategory(), UnitCategoryDto.class, TOKEN));
    // assertThrows(Exception.class, () ->  createPut(URL + "/500", getUnitCategory(), UnitCategoryDto.class, TOKEN));

  }

  @Test
  void deleteValidUnitCategory() {
    assertAll( () ->  createDelete(URL + "/1", TOKEN));
  }

  @Test
  void deleteInvalidUnitCategory() {
    assertThrows(Exception.class, () ->  createDelete(URL + "/100", TOKEN));
  }

  private UnitCategoryDto getUnitCategory(){
    UnitCategoryDto unitCategoryDto=new UnitCategoryDto();
    unitCategoryDto.setName("New measurement");
    unitCategoryDto.setDescription("New measurement");
    unitCategoryDto.setDefaultUnit("abb");
    return unitCategoryDto;
  }
}
