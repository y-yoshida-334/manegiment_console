package insert;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import bean.Student;
import dao.StudentDAO;

@WebServlet(urlPatterns = {"/function/insert/execute"})
public class Execute extends HttpServlet {

    // doPostメソッド：フォームから送信されたデータを処理
    public void doPost(
        HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {
        
        // エラーハンドリング
        try {
            // フォームから送信されたパラメータを取得
            int student_id = Integer.parseInt(request.getParameter("student_id"));
            String student_name = request.getParameter("student_name");
            int student_course = Integer.parseInt(request.getParameter("student_course"));

            // Studentオブジェクトの作成とデータ設定
            Student s = new Student();
            s.setStudent_id(student_id);
            s.setStudent_name(student_name);
            s.setStudent_course(student_course);

            // DAOを利用してデータベースに学生情報を追加
            StudentDAO dao = new StudentDAO();
            int line = dao.insert(s);
            
            // 挿入成功の場合、成功画面に遷移
            if (line > 0) {
                request.getRequestDispatcher("/insert/success.jsp").forward(request, response);
            }
        } catch (Exception e) {
            // 例外が発生した場合、失敗画面に遷移
            request.getRequestDispatcher("/insert/failure.jsp").forward(request, response);
        }
    }
}
