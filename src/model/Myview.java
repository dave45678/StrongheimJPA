package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the MYVIEW database table.
 * 
 */
@Entity
@NamedQuery(name="Myview.findAll", query="SELECT m FROM Myview m")
public class Myview implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal average;

	@Id
	private String student;

	public Myview() {
	}

	public BigDecimal getAverage() {
		return this.average;
	}

	public void setAverage(BigDecimal average) {
		this.average = average;
	}

	public String getStudent() {
		return this.student;
	}

	public void setStudent(String student) {
		this.student = student;
	}

}