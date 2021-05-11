package al.ikubinfo.healthometer.users.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import al.ikubinfo.commons.utils.JsonUtils;
import al.ikubinfo.healthometer.HealthometerApp;
import al.ikubinfo.healthometer.HealthometerTestSupport;
import al.ikubinfo.healthometer.users.dto.AuthDto;
import al.ikubinfo.healthometer.users.dto.UserDto;
import lombok.val;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(classes = HealthometerApp.class)
public class UserRestControllerTest extends HealthometerTestSupport {

  private String URL = "/users";

  @Test
  void getValidUser() {
    val response = createGet(URL + "/1", UserDto.class);
    assertEquals("admin@ikubinfo.al", response.getEmail());
  }

  @Override
  public String getToken() {
    val authDto = AuthDto.builder().username("admin").password("password").valid(false).build();
    try {
      return mockMvc
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
      return "";
    }
  }
}
