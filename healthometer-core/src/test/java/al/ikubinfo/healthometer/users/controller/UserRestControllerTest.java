package al.ikubinfo.healthometer.users.controller;

import al.ikubinfo.healthometer.HealthometerApp;
import al.ikubinfo.healthometer.HealthometerTestSupport;
import al.ikubinfo.healthometer.users.dto.AuthDto;
import al.ikubinfo.healthometer.users.dto.UserDto;
import al.ikubinfo.healthometer.users.entity.UserEntity;
import al.ikubinfo.healthometer.users.repository.UserRepository;
import al.ikubinfo.healthometer.users.service.AuthService;
import al.ikubinfo.healthometer.users.service.UserService;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(classes = HealthometerApp.class)

public class UserRestControllerTest extends HealthometerTestSupport {
  private UserService userService;
  private UserDto userDto;
  private static final String URL = "/users/{id}";

  @Autowired
  MockMvc mockMvc;


  @InjectMocks
  UserRestController userRestController;

  @Mock
  UserRepository userRepository;


  //    @Test
  //    void postUserTest() throws Exception {
  //        val userDto = UserDto.builder().username("admin").password("password").build();
  //        val response = createPost(URL, userDto, UserDto.class);
  //        assertEquals(true, response.isValid());
  //    }

//    @Test
//    void getUSerTest() throws Exception {
//      final Long userId = 2L;
//      val userDto = UserDto.builder().id(2L).username("user").firstname("User").lastname("MC User").email("user@ikub.al").password("$2a$10$bZuFl53cd20mgLFaprt3IuIZ5p9kFAXQHW26NvFAFyDFg/JCQdfni").roleDto(1).statusDto(2).build();
//
//
//    }

  @Test
  void getUserTest() throws Exception{
    ResultMatcher ok = MockMvcResultMatchers.status()
            .isOk();

    MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get(URL,2);
    this.mockMvc.perform(builder)
            .andExpect(ok);
  }
}
