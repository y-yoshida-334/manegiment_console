package update;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import bean.Student;
import dao.StudentDAO;

@WebServlet(urlPatterns = {"/function/update/execute"})
public class Execute extends HttpServlet {

	public void doPost(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException{
		//PrintWriter out=response.getWriter();
				try {
					int student_id=Integer.parseInt(request.getParameter("student_id"));
					String student_name=request.getParameter("student_name");
					int student_course=Integer.parseInt(request.getParameter("student_course"));
					
					Student s=new Student();
					s.setStudent_id(student_id);
					s.setStudent_name(student_name);
					s.setStudent_course(student_course);
					
					StudentDAO dao=new StudentDAO();
					int line=dao.update(s);
					if(line > 0) {
						request.getRequestDispatcher("/update/success.jsp").forward(request, response);
					}
				} catch(Exception e) {
					request.getRequestDispatcher("/update/failure.jsp").forward(request, response);
					//e.printStackTrace(out);
				}
	}
}
