package com.lcwd.userservice.entity;

public class Hotel {

	private String Id;
	private String name;
	private String location;
	private String about;

	public Hotel(String id, String name, String location, String about) {
		super();
		Id = id;
		this.name = name;
		this.location = location;
		this.about = about;
	}

	public Hotel() {
		super();
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	@Override
	public String toString() {
		return "Hotel [Id=" + Id + ", name=" + name + ", location=" + location + ", about=" + about + "]";
	}

}
