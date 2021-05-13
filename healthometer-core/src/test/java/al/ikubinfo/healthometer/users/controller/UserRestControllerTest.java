package al.ikubinfo.healthometer.users.controller;

import al.ikubinfo.commons.utils.JsonUtils;
import al.ikubinfo.healthometer.HealthometerApp;
import al.ikubinfo.healthometer.HealthometerTestSupport;
import al.ikubinfo.healthometer.users.dto.*;
import lombok.val;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = HealthometerApp.class)
public class UserRestControllerTest extends HealthometerTestSupport {

  private String URL = "/users";
  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;


  @Test
  void getValidUser() {
    val response = createGet(URL + "/1", UserDto.class);
    assertEquals("admin@ikubinfo.al", response.getEmail());
  }

  @Test
  void getInvalidUser() {
    val response = createGet(URL + "/1", UserDto.class);
    assertEquals(false, "admin1@ikubinfo.al".equals(response.getEmail()));
  }

  @Test
  void createValidUser() {
    StatusDto statusDto = new StatusDto();
    statusDto.setId(1L);
    RoleDto roleDto = new RoleDto();
    roleDto.setId(1L);
    UserDto newUser = new UserDto();
    newUser.setId(1l);
    newUser.setEmail("new_user@gmail.com");
    newUser.setPassword("password");
    newUser.setUsername("new_user");
    newUser.setStatusDto(statusDto);
    newUser.setFirstname("Name");
    newUser.setLastname("Surname");
    newUser.setRoleDto(roleDto);
    val response = createPost(URL, newUser, UserDto.class);
    assertEquals("new_user@gmail.com", response.getEmail());
  }

  @Test
  void createInvalidUser1() {
    StatusDto statusDto = new StatusDto();
    statusDto.setId(1L);
    RoleDto roleDto = new RoleDto();
    roleDto.setId(1L);
    UserDto newUser = new UserDto();
    newUser.setId(1l);
    newUser.setEmail("new_user@gmail.com");
    newUser.setPassword("password");
    newUser.setUsername("new_user");
    newUser.setStatusDto(statusDto);
    newUser.setFirstname("Name");
    newUser.setLastname("Surname");
    newUser.setRoleDto(roleDto);
    val response = createPost(URL, newUser, UserDto.class);
    assertNotEquals("new_user1@gmail.com", response.getEmail());
  }

  @Test
  void createInvalidUser2() {
    StatusDto statusDto = new StatusDto();
    statusDto.setId(1L);
    RoleDto roleDto = new RoleDto();
    roleDto.setId(1L);
    UserDto newUser = new UserDto();
    newUser.setId(1l);
    newUser.setEmail("new_user@gmail.com");
    newUser.setPassword("password");
    newUser.setUsername("new_user");
    newUser.setStatusDto(statusDto);
    newUser.setFirstname("Name");
    newUser.setLastname("Surname");
    assertThrows(Exception.class, () -> createPost(URL, newUser, UserDto.class));
  }

  @Test
  void editValidUser() {
    UserDto userDto = new UserDto();
    userDto.setEmail("new_user@gmail.com");
    userDto.setPassword("password");
    val response = createPut(URL + "/1", userDto, UserDto.class);
    assertEquals("new_user@gmail.com", response.getEmail());
  }

  @Test
  void editInvalidUser() {
    UserDto userDto = new UserDto();
    userDto.setEmail("new_user@gmail.com");
    userDto.setPassword("password");
    val response = createPut(URL + "/1", userDto, UserDto.class);
    assertNotEquals("admin@gmail.com", response.getEmail());
  }

  @Test
  void deleteValidUser() {
    assertAll(() -> createDelete(URL + "/1")
    );
  }

  @Test
  void deleteInvalidUser() {
    assertThrows(Exception.class, () -> createDelete(URL + "/100"));
  }

  @Test
  void changeValidRole() {
    val response = createPut(URL + "/1/change-role/user", new UserDto(), UserDto.class);
    assertEquals("user", response.getRoleDto().getName());
  }

  @Test
  void changeNotValidRole() {
    val response = createPut(URL + "/1/change-role/user", new UserDto(), UserDto.class);
    assertNotEquals("admin", response.getRoleDto().getName());
  }

  @Test
  void changeValidPassword() {
    PasswordDto passwordDto = new PasswordDto();
    passwordDto.setCurrentPassword("password");
    passwordDto.setNewPassword("password1");

    val response = createPut(URL + "/1/change-password", passwordDto, UserDto.class);
    assertEquals(true, bCryptPasswordEncoder.matches("password1", response.getPassword()));
  }

  @Test
  void changeInvalidPassword() {
    PasswordDto passwordDto = new PasswordDto();
    passwordDto.setCurrentPassword("password");
    passwordDto.setNewPassword("password1");

    val response = createPut(URL + "/1/change-password", passwordDto, UserDto.class);
    assertEquals(false, bCryptPasswordEncoder.matches("password", response.getPassword()));
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
