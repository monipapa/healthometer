package al.ikubinfo.healthometer.product.controller;

import al.ikubinfo.commons.utils.JsonUtils;
import al.ikubinfo.healthometer.HealthometerApp;
import al.ikubinfo.healthometer.HealthometerTestSupport;
import al.ikubinfo.healthometer.product.dto.ProductDto;
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

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = HealthometerApp.class)
@Transactional
public class ProductRestControllerTest extends HealthometerTestSupport {

    private String URL = "/products";
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
    void getValidProduct() {
        assertEquals("Chocolate", createGet(URL + "/1", ProductDto.class, TOKEN).getName());
    }

    @Test
    void getInvalidProduct() {
        assertThrows(Exception.class,() ->createGet(URL + "/100", ProductDto.class, TOKEN));
    }

    @Test
    void createValidProduct() {
    assertAll( () ->  createPost(URL, getProduct(), ProductDto.class, TOKEN));
    }

    @Test
    void editValidTargetCategory() {
        assertAll(() ->  createPut(URL + "/1", getProduct(), ProductDto.class, TOKEN));
    }

    @Test
    void deleteValidTargetCategory() {
        assertAll( () ->  createDelete(URL + "/1", TOKEN));
    }

    private ProductDto getProduct(){
        ProductDto productDto=new ProductDto();
        productDto.setName("New product");
        productDto.setAmountValue(new BigDecimal(100));
        //productDto.setTargetCategoryDto();
        //productDto.setUnitSubcategoryDto();
        return productDto;
    }
}
