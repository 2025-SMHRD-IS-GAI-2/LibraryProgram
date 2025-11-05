package model;

import java.sql.SQLException;

public class UserDAO extends BaseDAO {

    @Override
    public void printTableInfo() {
        System.out.println("📘 [BOOKUSER 테이블 관리 DAO]");
    }

    // 회원가입
    public int join(UserVO uvo) {
        int row = 0;
        try {
            getConn();
            String sql = "INSERT INTO BOOKUSER (id, pw, name, phonenum) VALUES (?,?,?,?)";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, uvo.getId());
            psmt.setString(2, uvo.getPw());
            psmt.setString(3, uvo.getName());
            psmt.setString(4, uvo.getPhonenum());
            row = psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getClose();
        }
        return row;
    }

    // 로그인
    public String login(UserVO uvo) {
        String result_name = null;
        try {
            getConn();
            String sql = "SELECT * FROM BOOKUSER WHERE id = ? and pw = ?";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, uvo.getId());
            psmt.setString(2, uvo.getPw());
            rs = psmt.executeQuery();
            if (rs.next()) result_name = rs.getString("name");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getClose();
        }
        return result_name;
    }

    // 회원의 대출 횟수 +1
    public int borrowCount(UserVO uvo) {
        int row = 0;
        try {
            getConn();
            String sql = "UPDATE BOOKUSER SET BORCOUNT = BORCOUNT + 1 WHERE ID = ?";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, uvo.getId());
            row = psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getClose();
        }
        return row;
    }

    // 이벤트: 대출 횟수 확인
    public int event(UserVO uvo) {
        int result_borcount = 0;
        try {
            getConn();
            String sql = "SELECT BORCOUNT FROM BOOKUSER WHERE ID = ?";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, uvo.getId());
            rs = psmt.executeQuery();
            if (rs.next()) result_borcount = rs.getInt("BORCOUNT");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getClose();
        }
        return result_borcount;
    }
}
