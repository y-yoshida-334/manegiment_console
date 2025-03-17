package bean;

import java.io.Serializable;

public class Student implements Serializable {

	private int student_id;
	private String student_name;
	private int student_course;
	private int course_id;
	private String course_name;
	
	 // Getter and Setter for student_id
    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    // Getter and Setter for student_name
    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    // Getter and Setter for student_course
    public int getStudent_course() {
        return student_course;
    }

    public void setStudent_course(int student_course) {
        this.student_course = student_course;
    }

    // Getter and Setter for course_id
    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    // Getter and Setter for course_name
    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }
}
