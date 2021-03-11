package com.example.project1qa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.project1qa.domain.Gig;
import com.example.project1qa.repo.GigRepo;


@Service
public class GigService {
	
	//Link to the gig repo
	private GigRepo repo;
	
	public GigService(GigRepo repo) {
		super();
		this.setRepo(repo);
	}
	
	//set up the crud functions
	
	//create 
	public Gig addGig(Gig gig) {
		return this.repo.save(gig);
	}
	
	//return
	//return all
	public List<Gig> getAllGigs(){
		return this.repo.findAll();
	}
	
	//return by artist
	public Gig getGigByArtist(String artist) {
		return this.repo.findByArtist(artist);
	}
	
//	public Gig getGigById(Long id) {
//		return this.repo.findById(id);
//	}
	
	
	//update
	public Gig updateGig(Long id, Gig newGig) {
	Optional <Gig> existingOptional = this.repo.findById(id);
	Gig existing = existingOptional.get();
	
	//update the existing gig with new data
	existing.setArtist(newGig.getArtist());
	existing.setCity(newGig.getCity());
	existing.setVenue(newGig.getVenue());
	existing.setGigDate(newGig.getGigDate());
	existing.setGigTime(newGig.getGigTime());
	
	//return the new data
	return this.repo.save(existing);
	}
	
	
	//delete
	public boolean removeGig(Long id) {
		this.repo.deleteById(id);
		boolean exists = this.repo.existsById(id);
		return !exists; //returns true if successfully deleted
	}
	
	//repo getters and setters
	
	
	

	public GigRepo getRepo() {
		return repo;
	}

	public void setRepo(GigRepo repo) {
		this.repo = repo;
	}

}
