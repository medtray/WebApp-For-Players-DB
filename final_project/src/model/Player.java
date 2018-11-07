package model;

import java.io.Serializable;
public class Player implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String         position    ;
    private String         country;
    private String          club;
    private String         first_name    ;
    private String         second_name    ;
    private Integer         id    ;

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getSecond_name() {
		return second_name;
	}

	public void setSecond_name(String second_name) {
		this.second_name = second_name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Player(Integer id,String first_name,String second_name,String club,String country, String position) {
		// TODO Auto-generated constructor stub
		setId(id);
		setSecond_name(second_name);
		setFirst_name(first_name);
		setClub(club);
		setCountry(country);
		setPosition(position);
		
	}

}
