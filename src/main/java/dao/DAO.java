package dao;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * DAO（Data Access Object）クラス
 * データベース接続を提供するクラス
 */
public class DAO {

    // データソース（コネクションプール）
    private static DataSource ds;

    /**
     * データベース接続を取得するメソッド
     * 
     * @return Connection データベース接続オブジェクト
     * @throws Exception データベース接続時の例外
     */
    public Connection getConnection() throws Exception {
        // データソースが未取得の場合、JNDIを利用して取得
        if (ds == null) {
            InitialContext ic = new InitialContext();
            ds = (DataSource) ic.lookup("java:comp/env/jdbc/student");
        }
        // データソースから接続を取得
        return ds.getConnection();
    }
}
