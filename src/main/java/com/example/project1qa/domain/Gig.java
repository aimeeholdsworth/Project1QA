package com.example.project1qa.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Gig {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//create the gig variables
	private String artist;
	private String city;
	private String venue;
	private String gigDate;
	private int gigTime;
	
//	private Date date = Date.valueOf(gigDate);
	
	//overload the methods
	public Gig() {
		super();
	}
	
	//constructor
	public Gig(String artist, String city, String venue, String gigDate, int gigTime) {
		super();
		this.artist = artist;
		this.city = city;
		this.venue = venue;
		this.gigDate = gigDate;
		this.gigTime = gigTime;
	}
	
	//constructor with long id
	public Gig(Long id,String artist, String city, String venue, String gigDate, int gigTime) {
		super();
		this.id = id;
		this.artist = artist;
		this.city = city;
		this.venue = venue;
		this.gigDate = gigDate;
		this.gigTime = gigTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getGigDate() {
		return gigDate;
	}

	public void setGigDate(String gigDate) {
		this.gigDate = gigDate;
	}

	public int getGigTime() {
		return gigTime;
	}

	public void setGigTime(int gigTime) {
		this.gigTime = gigTime;
	}
	
	

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((gigDate == null) ? 0 : gigDate.hashCode());
		result = prime * result + gigTime;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((venue == null) ? 0 : venue.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gig other = (Gig) obj;
		if (artist == null) {
			if (other.artist != null)
				return false;
		} else if (!artist.equals(other.artist))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (gigDate == null) {
			if (other.gigDate != null)
				return false;
		} else if (!gigDate.equals(other.gigDate))
			return false;
		if (gigTime != other.gigTime)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (venue == null) {
			if (other.venue != null)
				return false;
		} else if (!venue.equals(other.venue))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Gig [id=" + id + ", artist=" + artist + ", city=" + city + ", venue=" + venue + ", gigDate=" + gigDate
				+ ", gigTime=" + gigTime + "]";
	}
	
	

}
