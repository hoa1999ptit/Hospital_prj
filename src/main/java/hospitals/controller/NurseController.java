package hospitals.controller;

import java.util.ArrayList;
import java.util.List;

import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import exception.ResourceNotFoundException;
import hospitals.model.Nurse;
import hospitals.repository.NurseRepository;
import hospitals.service.NurseService;

@RestController
@CrossOrigin

public class NurseController {
	
	List<Nurse> cust=new ArrayList<Nurse>();
	private NurseRepository nurseRepo;
	
	@Autowired
	private NurseService nurseService;
	
	public NurseController(@RequestBody NurseRepository nurseRepo) {
		this.nurseRepo=nurseRepo;
	}
	
	@GetMapping(value = "/all")
	public List<Nurse> getAllNurses(){
		return nurseService.getNurse();
	}
	@RequestMapping(value = "/getallcustomer", method = RequestMethod.GET)
	  public List<Nurse> getResource(){
		cust=nurseService.getNurse();
	      return cust;
	  }
	@RequestMapping(value="/{id}/update",method = RequestMethod.PUT)
	/*public List<Nurse> updateNurse(@ApiPathParam(name = "id") @PathVariable long id,
			@RequestBody Nurse nurse) throws ResourceNotFoundException{
		 nurse=nurseRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Nurse not found for this id :"+id));
		 
		 nurseRepo.save(nurse);
		 return nurseRepo.findAll();
		 
	}*/
	public void updateNurse(@PathVariable("id") long id,@RequestBody Nurse nurse) {
		nurseService.updateNurse(nurse);
	}
	
	@RequestMapping(value = "/postcustomer", method = RequestMethod.POST)
	/*public List<Nurse> create(@RequestBody Nurse nurse){
		nurseRepo.save(nurse);

        return nurseRepo.findAll();
    }*/
	public List<Nurse> postcustomer(@RequestBody Nurse nurse) {
		nurseRepo.save(nurse);

        return nurseRepo.findAll();
	}
	
	
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    /*(public List<Nurse> removeNurse(@ApiPathParam(name = "id") @PathVariable long id){
        nurseRepo.deleteById(id);

        return nurseRepo.findAll();
    }*/
	public void deleteNurse(@PathVariable("id")long id) {
		nurseService.deleteNurse(id);
	}

}
