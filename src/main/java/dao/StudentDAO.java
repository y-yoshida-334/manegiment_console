package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Student;

/**
 * StudentDAO クラス
 * 学生情報のデータベース操作を行う
 */
public class StudentDAO extends DAO {

    /**
     * 学生名で検索するメソッド
     * 
     * @param keyword 検索キーワード（部分一致）
     * @return List<Student> 検索結果の学生リスト
     * @throws Exception データベース処理時の例外
     */
    public List<Student> search(String keyword) throws Exception {
        List<Student> list = new ArrayList<>();

        // データベース接続を取得
        Connection con = getConnection();

        // 学生名で検索するSQLクエリ
        PreparedStatement st = con.prepareStatement(
                "SELECT * FROM student AS s JOIN course AS c ON s.student_course = c.course_id WHERE student_id LIKE ?");
        st.setString(1, "%" + keyword + "%");

        ResultSet rs = st.executeQuery();

        // 結果セットをリストに追加
        while (rs.next()) {
            Student s = new Student();
            s.setStudent_id(rs.getInt("student_id"));
            s.setStudent_name(rs.getString("student_name"));
            s.setStudent_course(rs.getInt("student_course"));
            s.setCourse_id(rs.getInt("course_id"));
            s.setCourse_name(rs.getString("course_name"));
            list.add(s);
        }

        // リソースを解放
        st.close();
        con.close();

        return list;
    }

    /**
     * コースIDで検索するメソッド
     * 
     * @param keyword 検索キーワード（部分一致）
     * @return List<Student> 検索結果の学生リスト
     * @throws Exception データベース処理時の例外
     */
    public List<Student> searchCourse(String keyword) throws Exception {
        List<Student> list = new ArrayList<>();

        Connection con = getConnection();

        // コースIDで検索するSQLクエリ
        PreparedStatement st = con.prepareStatement(
                "SELECT * FROM course WHERE course_id LIKE ?");
        st.setString(1, "%" + keyword + "%");

        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            Student s = new Student();
            s.setCourse_id(rs.getInt("course_id"));
            s.setCourse_name(rs.getString("course_name"));
            list.add(s);
        }

        st.close();
        con.close();

        return list;
    }

    /**
     * 学生情報を追加するメソッド
     * 
     * @param student 追加する学生オブジェクト
     * @return int 追加された行数
     * @throws Exception データベース処理時の例外
     */
    public int insert(Student student) throws Exception {
        Connection con = getConnection();

        // 学生情報を挿入するSQLクエリ
        PreparedStatement st = con.prepareStatement(
                "INSERT INTO student(student_id, student_name, student_course) VALUES(?, ?, ?)");
        st.setInt(1, student.getStudent_id());
        st.setString(2, student.getStudent_name());
        st.setInt(3, student.getStudent_course());

        int line = st.executeUpdate();

        st.close();
        con.close();
        return line;
    }

    /**
     * 学生情報を更新するメソッド
     * 
     * @param student 更新する学生オブジェクト
     * @return int 更新された行数
     * @throws Exception データベース処理時の例外
     */
    public int update(Student student) throws Exception {
        Connection con = getConnection();

        // 学生情報を更新するSQLクエリ
        PreparedStatement st = con.prepareStatement(
                "UPDATE student SET student_name = ?, student_course = ? WHERE student_id = ?");
        st.setInt(3, student.getStudent_id());
        st.setString(1, student.getStudent_name());
        st.setInt(2, student.getStudent_course());

        int line = st.executeUpdate();

        st.close();
        con.close();
        return line;
    }

    /**
     * 学生情報を削除するメソッド
     * 
     * @param student 削除する学生オブジェクト
     * @return int 削除された行数
     * @throws Exception データベース処理時の例外
     */
    public int delete(Student student) throws Exception {
        Connection con = getConnection();

        // 学生情報を削除するSQLクエリ
        PreparedStatement st = con.prepareStatement(
                "DELETE FROM student WHERE student_id = ?");
        st.setInt(1, student.getStudent_id());

        int line = st.executeUpdate();

        st.close();
        con.close();
        return line;
    }
}
