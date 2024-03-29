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

import com.bmdb.business.Actor;
import com.bmdb.db.ActorRepository;

@CrossOrigin
@RestController
@RequestMapping("/actors")
public class ActorController {

	@Autowired
	private ActorRepository actorRepo;
	
	//list - return all actors
	@GetMapping("/") //exposes the following method to the web.
	public JsonResponse listActors() {
	JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(actorRepo.findAll());
		}
		catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
	return jr;
	}
	
	//get - return 1 actor for the given id
	@GetMapping("/{id}") //exposes the following method to the web.
	public JsonResponse getActor(@PathVariable int id) {
	JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(actorRepo.findById(id));
		}
		catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
	return jr;
	}
	//URL = http://localhost:8080/actors/6
	
	//add - adds a new actor
	@PostMapping("/")
	public JsonResponse addActor(@RequestBody Actor a) {
	JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(actorRepo.save(a));
		}
		//Only use the following for add controllers/methods
		catch (DataIntegrityViolationException dive) {
			jr = JsonResponse.getInstance(dive.getRootCause().getMessage());
		}
	return jr;
	}
		
	//update - updates a actor
	@PutMapping("/")
	public JsonResponse updateActor(@RequestBody Actor a) {
	JsonResponse jr = null;
		try {
			if (actorRepo.existsById(a.getId())) {
				jr = JsonResponse.getInstance(actorRepo.save(a));
			} else {
				//record doesn't exist
				jr = JsonResponse.getInstance("Error updating Actor. ID: " + a.getId() + " does not exist.");
				}
			}
		catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
	return jr;
	}
		
		//delete - delete a actor
		@DeleteMapping("/{id}")
		public JsonResponse deleteActor(@PathVariable int id) {
		JsonResponse jr = null;	
			try {
				if (actorRepo.existsById(id)) {
					actorRepo.deleteById(id);
					jr = JsonResponse.getInstance("Delete sucessful!");
				} else {
				//record doesn't exist
				jr = JsonResponse.getInstance("Error deleting Actor. ID: " + id + " does not exist.");
				}
			}
			catch (Exception e) {
				jr = JsonResponse.getInstance(e);
			}
		return jr;
		}
}
