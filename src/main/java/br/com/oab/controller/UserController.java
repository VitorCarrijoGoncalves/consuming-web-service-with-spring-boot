package br.com.oab.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.oab.model.User;
import br.com.oab.response.Response;
import br.com.oab.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private static final String url = "http://localhost:8080/users";

	@GetMapping(value = "{id}")
	public @ResponseBody ResponseEntity<Response<User>> findById(@PathVariable("id") Long id) {
		
		User user = restTemplate.getForObject(url, User.class);
		
		Response<User> response = new Response<User>();
		Optional<User> optionalUser = userService.findById(id);

		if (optionalUser.isPresent()) { user = optionalUser.get(); }

		if (user == null) {
			response.getErrors().add("Register not found id: ");
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(user);
		return ResponseEntity.ok(response);
	}


	@GetMapping(value = "{page}/{count}")
	public ResponseEntity<Response<Page<User>>> findAll(@PathVariable int page, @PathVariable int count) {
		Response<Page<User>> response = new Response<Page<User>>();
		Page<User> users = userService.findAll(page, count);
		response.setData(users);
		return ResponseEntity.ok(response);
	}


}
