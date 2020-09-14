package al.ikubinfo.healthometer.users.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import al.ikubinfo.healthometer.HealthometerApp;
import al.ikubinfo.healthometer.HealthometerTestSupport;
import al.ikubinfo.healthometer.users.dto.AuthDto;
import al.ikubinfo.healthometer.users.dto.UserDto;
import al.ikubinfo.healthometer.users.security.JWTFilter;
import al.ikubinfo.healthometer.users.service.AuthService;
import al.ikubinfo.healthometer.users.service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@SpringBootTest(classes = HealthometerApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserRestControllerTest extends HealthometerTestSupport {
  @Autowired
  private UserService userService;
  @Autowired
  private AuthService authService;
  private UserDto userDto;
  private RestTemplate restTemplate = new RestTemplate();
  private static final String URL = "/users/{id}";
  @LocalServerPort
  private String port;

//  @Test
//  void postUserTest() throws Exception {
//          val userDto = UserDto.builder().username("admin").password("password").build();
//          val response = createPost(URL, userDto, UserDto.class);
//          assertEquals(true, response.isValid());
//      }

    @Test
    void shouldGetUser() throws Exception {
      final Long userId = 2L;
      final String username = "user";
      final String getUserUrl = "http://localhost:" + port + "/users/{id}";
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
      AuthDto authDto = AuthDto.builder().username("user").password("password").valid(false).build();
      String token = authService.getToken(authDto);
      headers.add(JWTFilter.AUTHORIZATION_HEADER, "Bearer " + token);
      HttpEntity request = new HttpEntity<>(headers);
      ResponseEntity<UserDto> userDto = restTemplate.exchange(getUserUrl, HttpMethod.GET,
              request, UserDto.class, userId);
      assertThat(userDto).isNotNull();
      assertThat(userDto.getStatusCode()).isEqualTo(HttpStatus.OK);
      assertThat(userDto.getBody()).isNotNull();
      Assert.assertEquals(userDto.getBody().getUsername(), username);
    }

  @Test
  void shouldNotGetUser() {
    final Long userId = 1L;
    //final String assertResponse = '403 FORBIDDEN';
    final String getUserUrl = "http://localhost:" + port + "/users/{id}";
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    AuthDto authDto = AuthDto.builder().username("user").password("password").valid(false).build();
    String token = authService.getToken(authDto);
    headers.add(JWTFilter.AUTHORIZATION_HEADER, "Bearer " + token);
    HttpEntity request = new HttpEntity<>(headers);
    ResponseEntity<UserDto> userDto = null;
    try {
      userDto = restTemplate.exchange(getUserUrl, HttpMethod.GET,
              request, UserDto.class, userId);
    } catch (HttpClientErrorException e) {
      assertThat(userDto).isNull();
      assertThat(e.getStatusCode()).isEqualTo(HttpStatus.FORBIDDEN);
    }
  }

}
