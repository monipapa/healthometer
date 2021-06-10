package al.ikubinfo.healthometer.activity.controller;

import al.ikubinfo.commons.utils.JsonUtils;
import al.ikubinfo.healthometer.HealthometerApp;
import al.ikubinfo.healthometer.HealthometerTestSupport;
import al.ikubinfo.healthometer.activity.dto.TargetDto;
import al.ikubinfo.healthometer.activity.dto.TargetTrackerDto;
import al.ikubinfo.healthometer.product.dto.ProductDto;
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
public class TargetTrackerRestControllerTest extends HealthometerTestSupport {
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


    @Test
    void getValidTargetTracker() {
        assertEquals(1l, createGet(URL + "/1", TargetTrackerDto.class, TOKEN).getUserTargetCategoryDto().getId());
    }

    @Test
    void getValidTargetTracker1() {
        assertEquals(1l, createGet(URL + "/1", TargetTrackerDto.class, TOKEN).getId());
    }

    @Test
    void getInvalidTargetTracker() {
        assertThrows(Exception.class, () -> createGet(URL + "/100", TargetTrackerDto.class, TOKEN));
    }

    @Test
    void createValidTargetTracker() {
        assertAll(() -> createPost(URL, getTargetTrackerDto(), TargetTrackerDto.class, TOKEN));
    }

    @Test
    void editValidTargetTracker() {
        assertAll(() -> createPut(URL + "/1", getTargetTrackerDto(), TargetTrackerDto.class, TOKEN));
    }

    @Test
    void deleteValidTargetTracker() {
        assertAll(() -> createDelete(URL + "/1", TOKEN));
    }


    private TargetTrackerDto getTargetTrackerDto(){
        TargetTrackerDto targetTrackerDto=new TargetTrackerDto();
        targetTrackerDto.setUserTargetCategoryDto(getTarget());
        targetTrackerDto.setProductDto(getProductDto());
        targetTrackerDto.setUnitSubcategoryDto(getUnitSubcategory());
        targetTrackerDto.setUnit(new BigDecimal(2));
        targetTrackerDto.setUnitValue(targetTrackerDto.getUnit().multiply(targetTrackerDto.getProductDto().getAmountValue()));
        return targetTrackerDto;
    }

    private TargetDto getTarget() {
        TargetDto targetDto = new TargetDto();
        targetDto.setId(1l);
        return targetDto;
    }

    private ProductDto getProductDto(){
        ProductDto productDto=new ProductDto();
        productDto.setId(1l);
        productDto.setAmountValue(new BigDecimal(45));
        return productDto;
    }

    private UnitSubcategoryDto getUnitSubcategory() {
        UnitSubcategoryDto unitSubcategoryDto = new UnitSubcategoryDto();
        unitSubcategoryDto.setId(4l);
        return unitSubcategoryDto;
    }

}
