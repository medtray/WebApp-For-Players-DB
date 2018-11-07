package model;


import java.io.Serializable;
public class Country implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String         continent    ;
    private String          capital;
    private String          name;
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Country(String name, String capital, String continent ) {
		setName(name);
		setCapital(capital);
		setContinent(continent);
		// TODO Auto-generated constructor stub
	}

}
