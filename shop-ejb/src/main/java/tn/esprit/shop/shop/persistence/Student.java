package tn.esprit.shop.shop.persistence;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Student
 *
 */
@Entity

public class Student implements Serializable {

	   
	@Id
	private int id;
	private String name;
	private String level;
	private static final long serialVersionUID = 1L;

	public Student() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
   
}
