package com.example.projectqa;

import java.sql.Date;

public class Gig {
	//create the gig variables
		private String artist;
		private String city;
		private String venue;
		private Date gigDate;
		private int gigTime;
		
		
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

		public Date getGigDate() {
			return gigDate;
		}

		public void setGigDate(Date gigDate) {
			this.gigDate = gigDate;
		}

		public int getGigTime() {
			return gigTime;
		}

		public void setGigTime(int gigTime) {
			this.gigTime = gigTime;
		}

}
