package delete;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import java.util.List;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import bean.Student;
import dao.StudentDAO;

@WebServlet(urlPatterns = {"/function/delete/select"})
public class Select extends HttpServlet {

	public void doGet(
		HttpServletRequest request, HttpServletResponse response
	) throws ServerException, IOException{
		PrintWriter out=response.getWriter();
		try {
			StudentDAO dao=new StudentDAO();
			List<Student> list=dao.search("");
			
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("/delete/select.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace(out);
		}
	}
}
