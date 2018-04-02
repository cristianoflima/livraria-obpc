package br.com.cflima.livrariaObpc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping("/logar")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/cadastrarUsuario")
	public String cadUsuario() {
		return "cadastroUsuario";
	}
	
}
