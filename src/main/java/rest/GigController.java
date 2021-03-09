package rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.projectqa.Gig;

public class GigController {
	private List<domain.Gig> gigs = new ArrayList<>();

	@PostMapping("/create")
	public void create(@RequestBody domain.Gig gig) {
		this.gigs.add(gig);
	}

	@GetMapping("/getAllGigs")
	public List<domain.Gig> getGig() {
		return this.gigs;
	}

	@GetMapping("/getGig/{id}")
	public domain.Gig getGigById(@PathVariable int id) {
		return this.gigs.get(id);
	}

	@DeleteMapping("/delete/{id}")
	public domain.Gig removeGig(@PathVariable int id) {
		return this.gigs.remove(id);
	}

}
