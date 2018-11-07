package model;


import java.io.Serializable;
public class Users implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String         password    ;
    private String         id;
    private String first_name;
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



	private String second_name;
    
    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public Users(String Id,String Password, String first_name, String second_name) {
		setPassword(Password);
		setId(Id);
		setSecond_name(second_name);
		setFirst_name(first_name);
	}

}
