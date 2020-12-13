package hospitals.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import hospitals.model.Doctor;
import hospitals.service.DoctorService;

@Controller
//@CrossOrigin(origins = "*")

public class DoctorController {
	@Autowired
	private DoctorService doctorService;
	
	//display list of doctor
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listDoctors", doctorService.getAllDoctors());
		return "index";
	}
	
	@GetMapping("/showNewDoctorForm")
	public String showNewDoctorForm(Model model) {
		//create model attribute to bind form data
		Doctor doctor = new Doctor();
		model.addAttribute("doctor", doctor);
		return "new_doctor";
	}
	
	@PostMapping("/saveDoctor")
	public String saveDoctor(@ModelAttribute("doctor") Doctor doctor) {
		//save Doctor to database
		doctorService.saveDoctor(doctor);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable (value = "id") long id, Model model) {
		//get doctor from the service
		Doctor doctor = doctorService.getDoctorById(id);
		
		//set doctor as a model attribute to pre-populate the form
		model.addAttribute("doctor", doctor);
		return "update_doctor";
	}
	
	@GetMapping("/deleteDoctor/{id}")
	public String deleteDoctor(@PathVariable (value="id") long id) {
		//call delete doctor method
		this.doctorService.deleteDoctorById(id);
		return "redirect:/";
	}
}
