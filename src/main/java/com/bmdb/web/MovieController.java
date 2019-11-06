package com.bmdb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bmdb.business.Movie;
import com.bmdb.db.MovieRepository;

@CrossOrigin
@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	private MovieRepository movieRepo;
	
	//list - return all movies
	@GetMapping("/") //exposes the following method to the web.
	public JsonResponse listStuffies() {
	JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(movieRepo.findAll());
		}
		catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
	return jr;
	}
	
	//get - return 1 movie for the given id
	@GetMapping("/{id}") //exposes the following method to the web.
	public JsonResponse getStuffy(@PathVariable int id) {
	JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(movieRepo.findById(id));
		}
		catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
	return jr;
	}
	//URL = http://localhost:8080/movies/6
	
	//add - adds a new movie
	@PostMapping("/")
	public JsonResponse addStuffy(@RequestBody Movie m) {
	JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(movieRepo.save(m));
		}
		catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
	return jr;
	}
		
	//update - updates a movie
	@PutMapping("/")
	public JsonResponse updateStuffy(@RequestBody Movie m) {
	JsonResponse jr = null;
		try {
			if (movieRepo.existsById(m.getId())) {
				jr = JsonResponse.getInstance(movieRepo.save(m));
			} else {
				//record doesn't exist
				jr = JsonResponse.getInstance("Error updating Stuffy. ID: " + m.getId() + " does not exist.");
				}
			}
		catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
	return jr;
	}
		
		//delete - delete a movie
		@DeleteMapping("/{id}")
		public JsonResponse deleteStuffy(@PathVariable int id) {
		JsonResponse jr = null;	
			try {
				if (movieRepo.existsById(id)) {
					movieRepo.deleteById(id);
					jr = JsonResponse.getInstance("Delete sucessful!");
				} else {
				//record doesn't exist
				jr = JsonResponse.getInstance("Error deleting Stuffy. ID: " + id + " does not exist.");
				}
			}
			catch (Exception e) {
				jr = JsonResponse.getInstance(e);
			}
		return jr;
		}

}
