package net.gerard.web.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.gerard.web.model.Solicitud;
import net.gerard.web.model.Usuario;
import net.gerard.web.repository.SolicitudesRepository;

@Controller
@RequestMapping("/solicitud")
public class SolicitudController {
	@Autowired
	private SolicitudesRepository serviceSolicitud;
	
	@GetMapping("/fromContact")
	public String mostrarSolicitud(Solicitud solicitudl) {
		return "solicitud/fromContact";
	}
	
	@PostMapping("/save")
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
	}
	
	//admin
	@GetMapping("/lista")
	public String mostrarListaSolicitudes(Solicitud solicitudl, Model model) {
		List<Solicitud> lista = serviceSolicitud.findAll();
		model.addAttribute("solicitudes",lista);
		return "solicitud/listSolicitudes";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteSolicitud(@PathVariable("id") int id, Solicitud solicitudl, RedirectAttributes  attributes) {
		serviceSolicitud.deleteById(id);
		attributes.addFlashAttribute("msg", "Solicitud Eliminada");
		return "redirect:/solicitud/lista";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
}
