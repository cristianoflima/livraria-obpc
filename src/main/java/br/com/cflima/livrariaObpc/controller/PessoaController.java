package br.com.cflima.livrariaObpc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PessoaController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}

}
