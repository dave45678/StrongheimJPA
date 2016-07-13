package model;

import java.io.Serializable;
import javax.persistence.*;
import org.eclipse.persistence.annotations.ReturnInsert;
import java.math.BigDecimal;


/**
 * The persistent class for the STRONGHEIM database table.
 * 
 */
@Entity
@NamedQuery(name="Strongheim.findAll", query="SELECT s FROM Strongheim s")
public class Strongheim implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	@ReturnInsert
	private long id;

	private BigDecimal assignmentgrade;

	private String assignmenttype;

	private String student;

	public Strongheim() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getAssignmentgrade() {
		return this.assignmentgrade;
	}

	public void setAssignmentgrade(BigDecimal assignmentgrade) {
		this.assignmentgrade = assignmentgrade;
	}

	public String getAssignmenttype() {
		return this.assignmenttype;
	}

	public void setAssignmenttype(String assignmenttype) {
		this.assignmenttype = assignmenttype;
	}

	public String getStudent() {
		return this.student;
	}

	public void setStudent(String student) {
		this.student = student;
	}

}