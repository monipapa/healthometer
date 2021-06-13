package al.ikubinfo.healthometer.target.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import al.ikubinfo.commons.utils.JsonUtils;
import al.ikubinfo.healthometer.HealthometerApp;
import al.ikubinfo.healthometer.HealthometerTestSupport;
import al.ikubinfo.healthometer.target.dto.TargetCategoryDto;
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
public class TargetCategoryRestControllerTest extends HealthometerTestSupport {

  private String URL = "/targetCategories";
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
  void getValidTargetCategory() {
    assertEquals("Water", createGet(URL + "/1", TargetCategoryDto.class, TOKEN).getName());
  }

  @Test
  void getInvalidTargetCategory() {
    assertNotEquals(
        "g",
        createGet(URL + "/1", TargetCategoryDto.class, TOKEN)
            .getUnitCategoryDto()
            .getDefaultUnit());
  }

  @Test
  // TODO
  void createInvalidTargetCategory() {
    //    assertThrows(Exception.class, () ->  createPost(URL, getTargetCategory(),
    // TargetCategoryDto.class, TOKEN));

  }

  @Test
  void editInvalidTargetCategory() {
    assertThrows(
        AssertionError.class,
        () -> createPut(URL + "/1", getTargetCategory(), TargetCategoryDto.class, TOKEN));
  }

  @Test
  void deleteInvalidTargetCategory() {

    // assertThrows(Exception.class, () ->  createDelete(URL + "/1", TOKEN));
    // assertAll( () ->  createDelete(URL + "/1", TOKEN));
  }

  private TargetCategoryDto getTargetCategory() {
    TargetCategoryDto targetCategoryDto = new TargetCategoryDto();
    targetCategoryDto.setName("New target category");
    targetCategoryDto.setDescription("New target category");
    // targetCategoryDto.setUnitCategoryDto();
    return targetCategoryDto;
  }
}
