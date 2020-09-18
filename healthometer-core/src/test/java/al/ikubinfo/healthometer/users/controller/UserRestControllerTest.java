package al.ikubinfo.healthometer.users.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import al.ikubinfo.commons.utils.JsonUtils;
import static org.junit.Assert.assertEquals;
import al.ikubinfo.healthometer.HealthometerApp;
import al.ikubinfo.healthometer.HealthometerTestSupport;
import al.ikubinfo.healthometer.users.dto.AuthDto;
import al.ikubinfo.healthometer.users.dto.RoleDto;
import al.ikubinfo.healthometer.users.dto.StatusDto;
import al.ikubinfo.healthometer.users.dto.UserDto;
import al.ikubinfo.healthometer.users.enums.Status;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@SpringBootTest(classes = HealthometerApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UserRestControllerTest extends HealthometerTestSupport {

    private static String tokenUser;
    private static String tokenAdmin;
    private static final String baseURL = "/users";

    static String getAuth(MockMvc mockMvc, String username, String password) throws Exception {
        AuthDto authDto = AuthDto.builder().username(username).password(password).build();
        MvcResult result
                = mockMvc.perform(
                MockMvcRequestBuilders.post("/auth")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.toJsonString(authDto))
                        .accept("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn();
        return result.getResponse().getHeader("Authorization");
    }

    @BeforeAll
    static void loginTest(@Autowired MockMvc mockMvc) throws Exception {
        String usernameUser = "user", usernameAdmin = "admin", password = "password";
        tokenUser = getAuth(mockMvc, usernameUser, password);
        tokenAdmin = getAuth(mockMvc, usernameAdmin, password);
    }


    @Test
    void shouldGetUserTest() throws Exception {
        String getUserUrl = baseURL + "/{id}";
        mockMvc
                .perform(
                        MockMvcRequestBuilders.get(getUserUrl, 2).header("Authorization", tokenUser)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void shouldNotGetUserTest() throws Exception {
        String getUserUrl = baseURL + "/{id}";
        mockMvc
                .perform(
                        MockMvcRequestBuilders.get(getUserUrl, 2).header("Authorization", tokenAdmin)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden());
    }


    @Test
    void shouldCreateUserTest() throws Exception {
        String firstname = RandomStringUtils.randomAlphanumeric(10);
        String lastname = RandomStringUtils.randomAlphanumeric(10);
        RoleDto roleDto = new RoleDto();
        roleDto.setId(2L);
        roleDto.setName(RandomStringUtils.randomAlphanumeric(10));
        StatusDto statusDto = new StatusDto();
        statusDto.setName(Status.ACTIVE);
        statusDto.setId(1L);
        UserDto userDto = new UserDto();
        userDto.setEmail(RandomStringUtils.randomAlphanumeric(10));
        userDto.setFirstname(firstname);
        userDto.setLastname(lastname);
        userDto.setUsername(RandomStringUtils.randomAlphanumeric(10));
        userDto.setPassword(RandomStringUtils.randomAlphanumeric(10));
        userDto.setRoleDto(roleDto);
        userDto.setStatusDto(statusDto);
        mockMvc.perform( MockMvcRequestBuilders
                .post(baseURL)
                .content(JsonUtils.toJsonString(userDto))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON).header("Authorization",tokenAdmin))
                .andExpect(status().isOk());
        assertEquals(userDto.getFirstname(), firstname);
        assertEquals(userDto.getLastname(), lastname);
    }

    @Test
    void shouldEditUserTest() throws Exception {
        String email = RandomStringUtils.randomAlphanumeric(10);
        String getUserUrl = baseURL + "/{id}";
        UserDto userDto = new UserDto();
        userDto.setEmail(email);
        userDto.setPassword("password");
        MvcResult mvcResult = mockMvc
                .perform(
                        MockMvcRequestBuilders.put(getUserUrl, 1)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(JsonUtils.toJsonString(userDto))
                                .accept("application/json;charset=UTF-8")
                                .header("Authorization", tokenAdmin)
                )
                .andExpect(status().isOk())
                .andReturn();
        UserDto userDtoResult = JsonUtils.toObject(mvcResult.getResponse().getContentAsString(), UserDto.class);
        assertNotNull(mvcResult);
        assertEquals(userDtoResult.getEmail(), email);
    }

    @Test
    public void deleteUserTest() throws Exception
    {
        String getUserUrl = baseURL + "/{id}";
        mockMvc.perform( MockMvcRequestBuilders.delete(getUserUrl, 1)
                .header("Authorization", tokenAdmin)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
}
