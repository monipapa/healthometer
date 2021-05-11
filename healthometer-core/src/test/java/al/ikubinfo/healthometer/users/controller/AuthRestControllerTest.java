package al.ikubinfo.healthometer.users.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import al.ikubinfo.commons.utils.JsonUtils;
import al.ikubinfo.healthometer.HealthometerApp;
import al.ikubinfo.healthometer.users.dto.AuthDto;
import lombok.val;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ActiveProfiles("test")
@SpringBootTest(classes = HealthometerApp.class)
@AutoConfigureMockMvc
public class AuthRestControllerTest {

  @Autowired private MockMvc mockMvc;
  private String URL = "/auth";

  @Test
  void validAuthentication() {
    val authDto = AuthDto.builder().username("admin").password("password").valid(false).build();
    val response = authenticate(authDto);
    assertEquals(true, response.isValid());
  }

  @Test
  void invalidAuthentication() {
    val authDto = AuthDto.builder().username("admin").password("password1").valid(false).build();
    val response = authenticate(authDto);
    assertEquals(false, response.isValid());
  }

  private AuthDto authenticate(AuthDto authDto) {
    try {
      val result =
          mockMvc
              .perform(
                  MockMvcRequestBuilders.post(URL)
                      .contentType(MediaType.APPLICATION_JSON)
                      .content(JsonUtils.toJsonString(authDto)))
              .andExpect(status().isOk())
              .andReturn();

      return JsonUtils.toObject(result.getResponse().getContentAsString(), AuthDto.class);
    } catch (Exception e) {
      ExceptionUtils.rethrow(e);
    }
    return authDto;
  }
}
