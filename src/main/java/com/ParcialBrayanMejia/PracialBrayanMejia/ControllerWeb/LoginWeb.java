package com.ParcialBrayanMejia.PracialBrayanMejia.ControllerWeb;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ParcialBrayanMejia.PracialBrayanMejia.Repository.LoginRepositoty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ParcialBrayanMejia.PracialBrayanMejia.Documents.LoginDocuments;
import com.ParcialBrayanMejia.PracialBrayanMejia.NotFundException.NotFundException;

@RestController
@RequestMapping("/login")
public class LoginWeb {

	@Autowired
	private LoginRepositoty loginRepositoty;

	@GetMapping("/mostrarLogin")
	public List<LoginDocuments> finAll() {
		return loginRepositoty.findAll();
	}

	@GetMapping("/{id}")
	public LoginDocuments findById(@PathVariable String id) {
		return loginRepositoty.findById(id).orElseThrow(() -> new NotFundException("LOGIN NO ENCONTRADA"));
	}

	@PostMapping("/")
	public LoginDocuments save(@RequestBody Map<String, Object> body) {
		ObjectMapper mapper = new ObjectMapper();
		LoginDocuments login = mapper.convertValue(body, LoginDocuments.class);
		return loginRepositoty.save(login);
	}

	@PostMapping("/{id}")
	public LoginDocuments update(@PathVariable String id, LoginDocuments login) {
		login.setId(id);
		return loginRepositoty.save(login);
	}

	@DeleteMapping("/{id}")
	public LoginDocuments delete(@PathVariable String id) {
		LoginDocuments login = loginRepositoty.findById(id)
				.orElseThrow(() -> new NotFundException("LOGIN NO ENCONTRADA"));
		loginRepositoty.deleteById(id);
		return login;
	}
}
