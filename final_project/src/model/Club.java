package model;

import java.io.Serializable;
public class Club implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String         country_name    ;
    private String            club_name;
    public String getCountry_name() {
		return country_name;
	}
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	public String getClub_name() {
		return club_name;
	}
	public void setClub_name(String club_name) {
		this.club_name = club_name;
	}
	public Club(String club_name,String country_name) {
		setCountry_name(country_name);
		setClub_name(club_name);
		
	}
	
	}
  


