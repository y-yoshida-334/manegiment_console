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

@WebServlet(urlPatterns = {"/function/update/select"})
public class Select extends HttpServlet {

	public void doGet(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException{
		PrintWriter out=response.getWriter();
		try {
			StudentDAO dao=new StudentDAO();
			List<Student> list=dao.search("");
			
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("/update/select.jsp").forward(request, response);
		}catch(Exception e) {
			e.printStackTrace(out);
		}
	}
}
