package com.student.entity;

public class UniqueCourses {
	
	private String course;
	private long numberOfStudents;
	private long totalFees;
	
	public UniqueCourses() {
		
	}
	public UniqueCourses(String course, long numberOfStudents, long totalFees) {
		super();
		this.course = course;
		this.numberOfStudents = numberOfStudents;
		this.totalFees = totalFees;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public long getNumberOfStudents() {
		return numberOfStudents;
	}
	public void setNumberOfStudents(long numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}
	public void setTotalFees(long totalFees) {
		this.totalFees = totalFees;
	}
	public long getTotalFees() {
		return totalFees;
	}
}
