package com.thbs.HibernateBike;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity()
@Table(name="bikes") 
@org.hibernate.annotations.Entity(dynamicUpdate = true)
public class Bikes implements Serializable{
	@Id
	@GeneratedValue
	@Column(name="bike_id")
	 int bike_id;
	@Column(name="name")
	 String name;
	@Column(name="engine")
	 String engine;
	@Column(name="price")
	 String price;
	@Column(name="mileage")
	 String mileage;
	
	@Lob
	@Column(name="image")
	 byte[] image;
	
	
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public int getBike_id() {
		return bike_id;
	}
	public void setBike_id(int bike_id) {
		this.bike_id = bike_id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEngine() {
		return engine;
	}
	public void setEngine(String engine) {
		this.engine = engine;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getMileage() {
		return mileage;
	}
	public void setMileage(String mileage) {
		this.mileage = mileage;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bike_id;
		result = prime * result + ((engine == null) ? 0 : engine.hashCode());
		result = prime * result + ((mileage == null) ? 0 : mileage.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
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
		Bikes other = (Bikes) obj;
		if (bike_id != other.bike_id)
			return false;
		if (engine == null) {
			if (other.engine != null)
				return false;
		} else if (!engine.equals(other.engine))
			return false;
		if (mileage == null) {
			if (other.mileage != null)
				return false;
		} else if (!mileage.equals(other.mileage))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
}
	@Override
	public String toString() {
		return "Bikes [bike_id=" + bike_id + ", name=" + name + ", engine=" + engine + ", price=" + price + ", mileage="
				+ mileage + ", image=" + Arrays.toString(image) + "]";
	}
	
}