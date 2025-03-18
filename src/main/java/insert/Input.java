package insert;

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

/**
 * 学生の入力画面を表示するサーブレット
 */
@WebServlet(urlPatterns = {"/function/insert/input"})
public class Input extends HttpServlet {

    /**
     * GETリクエストを処理し、入力画面を表示する
     */
    public void doGet(
        HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            // 学生データアクセスオブジェクトを作成
            StudentDAO dao = new StudentDAO();

            // コース情報を取得
            List<Student> list = dao.searchCourse("");

            // 取得したコース情報をリクエスト属性に設定
            request.setAttribute("list", list);

            // insert/input.jsp にフォワード
            request.getRequestDispatcher("/insert/input.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
}
