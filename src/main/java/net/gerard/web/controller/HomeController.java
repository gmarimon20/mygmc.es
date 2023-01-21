package net.gerard.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import net.gerard.web.model.Solicitud;
import net.gerard.web.repository.EducacionRepository;
import net.gerard.web.repository.TrabajoRepository;


@Controller
public class HomeController{
	
	@Autowired
	private TrabajoRepository serviceTrabajo;
	
	@Autowired
	private EducacionRepository serviceEducacion;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@GetMapping("/")
	public String mostrarHome(Model model, Solicitud solicitud) {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "formLogin";
	}
	
	//GENERICOS
	@ModelAttribute
	public void setGenericos(Model model) {
		model.addAttribute("trabajos", serviceTrabajo.findByOrderByFechaFinalDesc());
		model.addAttribute("educacion", serviceEducacion.findByOrderByFechaFinalDesc());
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
	
	@GetMapping("/bcrypt/{texto}")
	@ResponseBody
	public String encriptar(@PathVariable("texto") String texto) {
		System.out.println("PASS:   "  +  passwordEncoder.encode(texto));
		return texto + " Encriptado en Bcrypt: " + passwordEncoder.encode(texto);
	}
	
	//Aviso de cookies
	@GetMapping("/aviso-cookies")
	public String mostrarCookies(Model model) {
		return "aviso-cookies";
	}
}