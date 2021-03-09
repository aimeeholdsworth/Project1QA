package rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstproject.Pug;

import domain.Gig;
import services.GigService;

@RestController 
public class GigController {
	
	private GigService service;
	
	public GigController(GigService service) {
		super();
		this.service = service;
	}
	
	//create functionality
	@PostMapping("/createGig")
	public Gig addGig(@RequestBody Gig gig) {
        return this.service.addGig(gig);
	}
	
	
	//get all the gigs (read)
	@GetMapping("/getAllGigs")
	public List<Gig> getAllGigs(){
		   return this.service.getAllGigs();
	}
	
	//get a gig by it's artist name
	@GetMapping("getGigByArtist/{artist}")
	public Gig getGigByArtist(@PathVariable String artist) {
		return this.service.getGigByArtist(artist);
	}
	

	
	@PutMapping("/update/{id}")
	public Gig updateGig(@PathVariable("id") Long id, @RequestBody Gig gig){
		return this.service.updateGig(id, gig);
	}
	
	@DeleteMapping("/delete/{id}")
	public boolean removeGig(@PathVariable Long id) {
		return this.service.removeGig(id);
	}
	
	
	

}
