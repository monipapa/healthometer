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
    val authDto = AuthDto.builder().username("user").password("password").valid(false).build();
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
    val response = createGet(URL + "/1", UnitCategoryDto.class, TOKEN);
    assertEquals("Weight", response.getName());
  }

  @Test
  void getInvalidUnitCategory() {
    val response = createGet(URL + "/1", UnitCategoryDto.class, TOKEN);
    assertNotEquals("g", response.getDefaultUnit());
  }

  @Test
  void createInvalidUnitCategory() {
    assertThrows(AssertionError.class, () ->  createPost(URL, getUnitCategory(), UnitCategoryDto.class, TOKEN));

  }


  @Test
  void editIvnalidUnitCategory() {
    assertThrows(AssertionError.class, () ->  createPut(URL + "/1", getUnitCategory(), UnitCategoryDto.class, TOKEN));

  }

  @Test
  void deleteInvalidUnitCategory() {
    assertThrows(AssertionError.class, () ->  createDelete(URL + "/1", TOKEN));
  }

    private UnitCategoryDto getUnitCategory(){
      UnitCategoryDto unitCategoryDto=new UnitCategoryDto();
      unitCategoryDto.setName("New measurement");
      unitCategoryDto.setDescription("New measurement");
      unitCategoryDto.setDefaultUnit("abb");
      return unitCategoryDto;
    }
  }
