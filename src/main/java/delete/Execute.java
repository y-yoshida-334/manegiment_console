package delete;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import bean.Student;
import dao.StudentDAO;

@WebServlet(urlPatterns = {"/function/delete/execute"})
public class Execute extends HttpServlet {

	public void doPost(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException{
		//PrintWriter out=response.getWriter();
		try {
			int student_id=Integer.parseInt(request.getParameter("student_id"));
			
			Student s=new Student();
			s.setStudent_id(student_id);
			
			StudentDAO dao=new StudentDAO();
			int line=dao.delete(s);
			if(line > 0) {
				request.getRequestDispatcher("/delete/success.jsp").forward(request, response);
			}
		} catch(Exception e) {
			request.getRequestDispatcher("/delete/failure.jsp").forward(request, response);
			//e.printStackTrace(out);
		}
	}
}
