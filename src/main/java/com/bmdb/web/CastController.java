package com.bmdb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bmdb.business.Cast;
import com.bmdb.db.CastRepository;

@CrossOrigin
@RestController
@RequestMapping("/cast")
public class CastController {
	
	@Autowired
	private CastRepository castRepo;
	
	//list - return all casts
	@GetMapping("/") //exposes the following method to the web.
	public JsonResponse listCast() {
	JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(castRepo.findAll());
		}
		catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
	return jr;
	}
	
	//get - return 1 cast for the given id
	@GetMapping("/{id}") //exposes the following method to the web.
	public JsonResponse getCast(@PathVariable int id) {
	JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(castRepo.findById(id));
		}
		catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
	return jr;
	}
	//URL = http://localhost:8080/cast/6
	
	//add - adds a new cast
	@PostMapping("/")
	public JsonResponse addCast(@RequestBody Cast c) {
	JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(castRepo.save(c));
		}
		//Only use the following for add controllers/methods
		catch (DataIntegrityViolationException dive) {
			jr = JsonResponse.getInstance(dive.getRootCause().getMessage());
		}
	return jr;
	}
		
	//update - updates a cast
	@PutMapping("/")
	public JsonResponse updateCast(@RequestBody Cast c) {
	JsonResponse jr = null;
		try {
			if (castRepo.existsById(c.getId())) {
				jr = JsonResponse.getInstance(castRepo.save(c));
			} else {
				//record doesn't exist
				jr = JsonResponse.getInstance("Error updating Cast. ID: " + c.getId() + " does not exist.");
				}
			}
		catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
	return jr;
	}
		
		//delete - delete a cast
		@DeleteMapping("/{id}")
		public JsonResponse deleteCast(@PathVariable int id) {
		JsonResponse jr = null;	
			try {
				if (castRepo.existsById(id)) {
					castRepo.deleteById(id);
					jr = JsonResponse.getInstance("Delete sucessful!");
				} else {
				//record doesn't exist
				jr = JsonResponse.getInstance("Error deleting Cast. ID: " + id + " does not exist.");
				}
			}
			catch (Exception e) {
				jr = JsonResponse.getInstance(e);
			}
		return jr;
		}
}
