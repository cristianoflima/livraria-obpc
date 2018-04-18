package br.com.cflima.livrariaObpc.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cflima.livrariaObpc.models.Permission;
import br.com.cflima.livrariaObpc.models.User;
import br.com.cflima.livrariaObpc.repositories.PermissionRepository;
import br.com.cflima.livrariaObpc.repositories.UserRepository;

@Controller
public class LoginController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PermissionRepository permissionRepository;
	
	@RequestMapping("/logar")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/cadastrarUsuario")
	public String cadUsuario(@ModelAttribute("user") User user, Model model) {
		if(user.getId() == null)
			model.addAttribute("user", new User());
		else
			model.addAttribute("user", user);
		
		return "cadastroUsuario";
	}
	
	@PostMapping(path="/salvar")
	public ModelAndView salvarCadastro(@ModelAttribute("user") User user, BindingResult result, RedirectAttributes ra) {
		
		ModelAndView mv = new ModelAndView("redirect:/cadastrarUsuario");
		
		/*
		 * TODO: verificar motivo por telefone não esta sendo capturado
		 * 		criar classe de validação 
		 * 		adicionar anotações de descrições dos campos
		 * 		verificar relacionamento entre User - Person
		 */
		
		
		if(user.getId() == null) {
			String pass = user.getPassword();
			
			Permission permissionUser = permissionRepository.findOne(Integer.valueOf(2));
			user.setPassword(new BCryptPasswordEncoder().encode(pass));
			user.setPermissoes(new ArrayList<Permission>());
			user.getPermissoes().add(permissionUser);
			user.setStatus(1);
			user.getPerson().setUser(user);
			user = userRepository.save(user);
			
			if(user.getId() != null)
				System.out.println("Usuário salvo com sucesso");
				
			else
				System.out.println("Uai, será que salvou? Olha lá no banco."); 
//				System.out.println(user);
		}
		
		return mv;
		
	}
	
}
