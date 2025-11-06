package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class LibraryDAO extends BaseDAO {

    @Override
    public void printTableInfo() {
        System.out.println("📗 [LIBRARY 테이블 관리 DAO]");
    }

    // 전체 도서 목록 조회
    public ArrayList<LibraryVO> selectAll() {
        ArrayList<LibraryVO> lvoList = new ArrayList<>();
        try {
            getConn();
            String sql = "SELECT * FROM LIBRARY";
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();

            while (rs.next()) {
                int booknum = rs.getInt("booknum");
                String bookname = rs.getString("bookname");
                String writer = rs.getString("writer");
                int bcount = rs.getInt("bcount");
                LibraryVO lvo = new LibraryVO(booknum, bookname, writer, bcount);
                lvoList.add(lvo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getClose();
        }
        return lvoList;
    }

    // 랜덤 책 추천
    public ArrayList<LibraryVO> getRandomBooks(int Count){
    	
    	ArrayList<LibraryVO> bookList = selectAll();//DB에서 전체 책 가져오기
    	ArrayList<LibraryVO> randomBooks = new ArrayList<>();
    	Random rd = new Random();
    	
    	boolean[]used = new boolean[bookList.size()];//중복 체크용
    	
    	while(randomBooks.size()<Count && randomBooks.size()<bookList.size()) {
    		int index = rd.nextInt(bookList.size());//랜덤 인덱스
    		if(!used[index]) {//아직 뽑지 않은 책이면
    			randomBooks.add(bookList.get(index));//책 추가
    			used[index]=true; // 뽑았다고 표시
    		}
    	}
    	return randomBooks;//랜덤 3권
    	
    }
    
    
    
    
    // 도서 1권 조회
    public LibraryVO selectOne(int booknumber) {
        LibraryVO result = null;
        try {
            getConn();
            String sql = "SELECT * FROM LIBRARY WHERE BOOKNUM = ?";
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, booknumber);
            rs = psmt.executeQuery();

            if (rs.next()) {
                String bookname = rs.getString("bookname");
                String writer = rs.getString("writer");
                int bcount = rs.getInt("bcount");
                result = new LibraryVO(booknumber, bookname, writer, bcount);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getClose();
        }
        return result;
    }

    // 도서 권수 -1 (대출)
    public int borrowBook(LibraryVO lvo) {
        int row = 0;
        try {
            getConn();
            String sql = "UPDATE LIBRARY SET BCOUNT = BCOUNT - 1 WHERE BOOKNUM = ? AND BCOUNT > 0";
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, lvo.getBooknum());
            row = psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getClose();
        }
        return row;
    }
    
    
    
    
    
    
    
    
}