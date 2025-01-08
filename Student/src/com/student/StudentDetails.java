package com.student;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class StudentDetails {

	// fields
	@Id
	private int studId;
	private String studName;
	private String studClass;
	private String studDOB;
	private int studAge;

	// Arugument Constructor
	public StudentDetails(int studId, String studName, String studClass, String studDOB, int studAge) {
		super();
		this.studId = studId;
		this.studName = studName;
		this.studClass = studClass;
		this.studDOB = studDOB;
		this.studAge = studAge;
	}

	// No-Arugument Constructor
	public StudentDetails() {

	}

	// Getter and Setter

	public int getStudId() {
		return studId;
	}

	public void setStudId(int studId) {
		this.studId = studId;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public String getStudClass() {
		return studClass;
	}

	public void setStudClass(String studClass) {
		this.studClass = studClass;
	}

	public String getStudDOB() {
		return studDOB;
	}

	public void setStudDOB(String studDOB) {
		this.studDOB = studDOB;
	}

	public int getStudAge() {
		return studAge;
	}

	public void setStudAge(int studAge) {
		this.studAge = studAge;
	}

	// toString Method
	@Override
	public String toString() {
		return "Student [studId=" + studId + ", studName=" + studName + ", studClass=" + studClass + ", studDOB="
				+ studDOB + ", studAge=" + studAge + "]";
	}

}
