package al.ikubinfo.healthometer.activity.controller;

import al.ikubinfo.commons.utils.JsonUtils;
import al.ikubinfo.healthometer.HealthometerApp;
import al.ikubinfo.healthometer.HealthometerTestSupport;
import al.ikubinfo.healthometer.activity.dto.TargetDto;
import al.ikubinfo.healthometer.target.dto.TargetCategoryDto;
import al.ikubinfo.healthometer.unit.dto.UnitSubcategoryDto;
import al.ikubinfo.healthometer.users.dto.AuthDto;
import al.ikubinfo.healthometer.users.dto.UserDto;
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

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = HealthometerApp.class)
@Transactional
public class TargetRestControllerTest extends HealthometerTestSupport {
    private static String TOKEN = "";
    private String URL = "/targets";

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
    void getValidTarget() {
        assertEquals("admin", createGet(URL + "/1", TargetDto.class, TOKEN).getUserDto().getUsername());
    }

    @Test
    void getInvalidTarget() {
        assertThrows(Exception.class, () -> createGet(URL + "/100", TargetDto.class, TOKEN));
    }

    @Test
    void createValidTarget() {
        assertAll(() -> createPost(URL, getTarget(), TargetDto.class, TOKEN));
    }

    @Test
    void editValidTarget() {
        assertAll(() -> createPut(URL + "/1", getTarget(), TargetDto.class, TOKEN));
    }

    @Test
    void deleteValidTarget() {
        assertAll(() -> createDelete(URL + "/1", TOKEN));
    }

    private TargetDto getTarget() {
        TargetDto targetDto = new TargetDto();
        targetDto.setTargetCategoryDto(getTargetCategoryDto());
        targetDto.setTargetValue(new BigDecimal(2700));
        targetDto.setUserDto(getUser());
        targetDto.setUnitSubcategoryDto(getUnitSubcategory());
        return targetDto;
    }

    private TargetCategoryDto getTargetCategoryDto(){
        TargetCategoryDto targetCategoryDto=new TargetCategoryDto();
        targetCategoryDto.setId(2l);
        return targetCategoryDto;
    }

    private UnitSubcategoryDto getUnitSubcategory() {
        UnitSubcategoryDto unitSubcategoryDto = new UnitSubcategoryDto();
        unitSubcategoryDto.setId(4l);
        return unitSubcategoryDto;
    }

    private UserDto getUser() {
        UserDto userDto = new UserDto();
        userDto.setId(1l);
        return userDto;
    }
}
