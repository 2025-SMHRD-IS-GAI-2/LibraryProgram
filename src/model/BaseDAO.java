package model;

import java.sql.*;

public abstract class BaseDAO{
    protected Connection conn;
    protected PreparedStatement psmt;
    protected ResultSet rs;

    // DB 연결
    protected void getConn() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1524:xe";
            String user = "campus_25IS_GA2_P1_2";
            String password = "smhrd2";
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 닫기
    protected void getClose() {
        try {
            if (rs != null) rs.close();
            if (psmt != null) psmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 각 DAO가 자신을 설명하도록 강제
    public abstract void printTableInfo();
}