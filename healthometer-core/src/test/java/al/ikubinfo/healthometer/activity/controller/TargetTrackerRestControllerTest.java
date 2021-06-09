package al.ikubinfo.healthometer.activity.controller;

import al.ikubinfo.commons.utils.JsonUtils;
import al.ikubinfo.healthometer.HealthometerApp;
import al.ikubinfo.healthometer.users.dto.AuthDto;
import lombok.val;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = HealthometerApp.class)
@Transactional
public class TargetTrackerRestControllerTest {
    private static String TOKEN = "";
    private String URL = "/targetTrackers";

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
}
