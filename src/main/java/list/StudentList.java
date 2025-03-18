package list;

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
 * StudentList サーブレット
 * 学生リストを取得し、リクエスト属性に設定してJSPに転送する
 */
@WebServlet(urlPatterns = { "/function/list" })
public class StudentList extends HttpServlet {

    /**
     * GETリクエストを処理するメソッド
     * 学生リストを取得し、リクエストに設定してJSPへフォワードする
     * 
     * @param request  クライアントからのリクエスト情報
     * @param response クライアントへのレスポンス情報
     * @throws ServletException サーブレット処理中の例外
     * @throws IOException      入出力例外
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // レスポンスの出力ストリームを取得
        PrintWriter out = response.getWriter();

        try {
            // StudentDAOのインスタンスを生成
            StudentDAO dao = new StudentDAO();

            // 学生情報を取得（空文字を渡して全件検索）
            List<Student> list = dao.search("");

            // 取得したリストをリクエスト属性に設定
            request.setAttribute("list", list);

            // JSPページへフォワード
            request.getRequestDispatcher("/list.jsp").forward(request, response);
            
        } catch (Exception e) {
            // エラー発生時にスタックトレースを出力
            e.printStackTrace(out);
        }
    }
}
