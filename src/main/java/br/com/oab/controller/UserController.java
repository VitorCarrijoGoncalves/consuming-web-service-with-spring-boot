package br.com.oab.controller;

import br.com.oab.model.User;
import br.com.oab.response.Response;
import br.com.oab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping(produces = "application/json")
	public ResponseEntity<Response<User>> create(HttpServletRequest request, @RequestBody User user,
                                                   BindingResult result) {

		Response<User> response = new Response<User>();

		try {
			validateCreateUser(user, result);

			if (result.hasErrors()) {
				result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
				return ResponseEntity.badRequest().body(response);
			}

			User userPersisted = (User) userService.createOrUpdate(user);
			response.setData(userPersisted);

		} catch (DuplicateKeyException e) {

			response.getErrors().add("Username already registered");
			return ResponseEntity.badRequest().body(response);

		} catch (Exception e) {
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}

		return ResponseEntity.ok(response);
	}

	private void validateCreateUser(User user, BindingResult result) {
		if (user.getUserName() == null) {
			result.addError(new ObjectError("User", "UserName no information"));
		}
	}

	@PutMapping(produces = "application/json")
	public ResponseEntity<Response<User>> update(HttpServletRequest request, @RequestBody User user,
                                                   BindingResult result) {
		Response<User> response = new Response<User>();

		try {
			validateUpdateUser(user, result);
			if (result.hasErrors()) {
				result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
				return ResponseEntity.badRequest().body(response);
			}

			User userPersisted = (User) userService.createOrUpdate(user);
			response.setData(userPersisted);

		} catch (Exception e) {
			// TODO: handle exception
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}

		return ResponseEntity.ok(response);
	}

	private void validateUpdateUser(User user, BindingResult result) {
		if (user.getId() == null) {
			result.addError(new ObjectError("User", "Id no information"));
		}
		if (user.getUserName() == null) {
			result.addError(new ObjectError("User", "UserName no information"));
		}
	}

	@GetMapping(value = "{id}")
	public ResponseEntity<Response<User>> findById(@PathVariable("id") Long id) {
		Response<User> response = new Response<User>();
		Optional<User> optionalUser = userService.findById(id);

		User user = null;

		if (optionalUser.isPresent()) user = optionalUser.get();

		if (user == null) {
			response.getErrors().add("Register not found id: " + id);
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(user);
		return ResponseEntity.ok(response);
	}


	@DeleteMapping(value = "{id}")
	public ResponseEntity<Response<String>> delete(@PathVariable("id") Long id) {
		Response<String> response = new Response<String>();

		Optional<User> optionalUser = userService.findById(id);

		User user = null;

		if (optionalUser.isPresent()) user = optionalUser.get();

		if (user == null) {
			response.getErrors().add("Register not found id: " + id);
			return ResponseEntity.badRequest().body(response);
		}
		userService.delete(id);
		return ResponseEntity.ok(new Response<String>());
	}

	@GetMapping(value = "{page}/{count}")
	public ResponseEntity<Response<Page<User>>> findAll(@PathVariable int page, @PathVariable int count) {
		Response<Page<User>> response = new Response<Page<User>>();
		Page<User> users = userService.findAll(page, count);
		response.setData(users);
		return ResponseEntity.ok(response);
	}


}
