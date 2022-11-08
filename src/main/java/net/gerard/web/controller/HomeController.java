package net.gerard.web.controller;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.gerard.web.model.Solicitud;
import net.gerard.web.model.Usuario;
import net.gerard.web.repository.EducacionRepository;
import net.gerard.web.repository.SolicitudesRepository;
import net.gerard.web.repository.TrabajoRepository;


@Controller
public class HomeController{
	
	@Autowired
	private TrabajoRepository serviceTrabajo;
	
	@Autowired
	private EducacionRepository serviceEducacion;
	
	//@Autowired
	//private SolicitudesRepository serviceSolicitud;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@GetMapping("/")
	public String mostrarHome(Model model, Solicitud solicitud) {
		return "index";
	}
	/*
	@GetMapping("/solicitud")
	public String mostrarSolicitud(Solicitud solicitudl) {
		return "solicitud/fromContact";
	}
	
	@PostMapping("/solicitud")
	public String guardarSolicitud(Solicitud solicitud, Model model, BindingResult result, RedirectAttributes  attributes){
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println("Ocurrio un error: " + error.getDefaultMessage());
			}
			return "solicitud/fromContact";
		}
		
		Usuario user = new Usuario();
		user.setId(2);
		solicitud.setUsuario(user);
		solicitud.setFecha(new Date());
	
		serviceSolicitud.save(solicitud);
		attributes.addFlashAttribute("msg", "Solicitud enviada, me podré en contacto. Muchas gracias.");
		return "redirect:/";
	}*/
	
	
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
}