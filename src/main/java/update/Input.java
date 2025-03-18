package update;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import bean.Student;
import dao.StudentDAO;

@WebServlet(urlPatterns = {"/function/update/input"})
public class Input extends HttpServlet {

	public void doPost(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException{
		PrintWriter out=response.getWriter();
		try {
			StudentDAO dao=new StudentDAO();
			List<Student> list=dao.searchCourse("");
			
			Student s=new Student();
			s.setStudent_id(Integer.parseInt(request.getParameter("student_id")));
			
			List<Student> list_s=dao.search(request.getParameter("student_id"));
			
			request.setAttribute("list", list);
			request.setAttribute("s", s);
			request.setAttribute("list_s", list_s);
			
			request.getRequestDispatcher("/update/input.jsp").forward(request, response);
		}catch(Exception e) {
			e.printStackTrace(out);
		}
	}
}
