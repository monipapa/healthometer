package al.ikubinfo.healthometer.unit.controller;

import al.ikubinfo.commons.utils.JsonUtils;
import al.ikubinfo.healthometer.HealthometerApp;
import al.ikubinfo.healthometer.HealthometerTestSupport;
import al.ikubinfo.healthometer.unit.dto.UnitCategoryDto;
import al.ikubinfo.healthometer.unit.dto.UnitSubcategoryDto;
import al.ikubinfo.healthometer.users.dto.AuthDto;
import lombok.val;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
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
public class UnitSubcategoryRestControllerTest extends HealthometerTestSupport {

  private String URL = "/unitSubcategories";
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
  void getValidUnitSubcategory() {
    val response = createGet(URL + "/1", UnitSubcategoryDto.class, TOKEN);
    assertEquals(1, response.getUnitCategoryDto().getId());
  }

  @Test
  void getInvalidUnitSubcategory() {
    val response = createGet(URL + "/1", UnitSubcategoryDto.class, TOKEN);
    assertNotEquals("Weight", response.getName());
  }

  @Test
  void createInvalidUnitSubcategory() {
    assertThrows(Exception.class, () ->  createPost(URL, getUnitSubcategory(), UnitSubcategoryDto.class, TOKEN));
  }


  @Test
  void editInvalidUnitSubcategory() {
    assertAll(() ->  createPut(URL + "/1", getUnitSubcategory(), UnitSubcategoryDto.class, TOKEN));

  }

  @Test
  void deleteInvalidUnitSubcategory() {
    assertThrows(Exception.class, () ->  createDelete(URL + "/100", TOKEN));
  }

  @Test
    //TODO Check
  void deleteValidUnitSubcategory() {
    assertAll(() -> createDelete(URL + "/1", TOKEN));
  }

  private UnitCategoryDto getUnitCategory(){
    UnitCategoryDto unitCategoryDto=new UnitCategoryDto();
    unitCategoryDto.setName("New measurement");
    unitCategoryDto.setDescription("New measurement");
    unitCategoryDto.setDefaultUnit("abb");
    return unitCategoryDto;
  }

  private UnitSubcategoryDto getUnitSubcategory(){
    UnitSubcategoryDto unitSubcategoryDto=new UnitSubcategoryDto();
    unitSubcategoryDto.setName("New measurement");
    unitSubcategoryDto.setUnitCategoryDto(getUnitCategory());
    unitSubcategoryDto.setAbbreviation("abb");
    return unitSubcategoryDto;
  }
}
