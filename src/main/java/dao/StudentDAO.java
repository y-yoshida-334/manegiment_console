package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Student;

public class StudentDAO extends DAO {

	public List<Student> search(String keyword) throws Exception {
		List<Student> list=new ArrayList<>();
		
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"select * from student as s join course as c on s.student_course = c.course_id where student_name like ?");
		st.setString(1, "%"+keyword+"%");
		ResultSet rs=st.executeQuery();
		
		while (rs.next()) {
			Student s=new Student();
			s.setStudent_id(rs.getInt("student_id"));
			s.setStudent_name(rs.getString("student_name"));
			s.setStudent_course(rs.getInt("student_course"));
			s.setCourse_id(rs.getInt("course_id"));
			s.setCourse_name(rs.getString("course_name"));
			list.add(s);
		}
		
		st.close();
		con.close();
		
		return list;
	}
	
	public List<Student> searchCourse(String keyword) throws Exception {
		List<Student> list=new ArrayList<>();
		
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"select * from course where course_id like ?");
		st.setString(1, "%"+keyword+"%");
		ResultSet rs=st.executeQuery();
		
		while (rs.next()) {
			Student s=new Student();
			s.setCourse_id(rs.getInt("course_id"));
			s.setCourse_name(rs.getString("course_name"));
			list.add(s);
		}
		
		st.close();
		con.close();
		
		return list;
	}
	
	public int insert(Student student) throws Exception {
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"insert into product(student_id, student_name, student_course) values(?,?,?)");
		st.setInt(1, student.getStudent_id());
		st.setString(2, student.getStudent_name());
		st.setInt(3, student.getStudent_course());
		int line=st.executeUpdate();
		
		st.close();
		con.close();
		return line;
	}
}
