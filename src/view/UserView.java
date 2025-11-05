package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.LibraryVO;
import model.UserVO;

public class UserView {

	Scanner sc = new Scanner(System.in);

	// 1. 메뉴 출력하는 메서드
	public int showMenu() {
		System.out.println("회원만 이용이 가능합니다.");
		System.out.println("회원아이디가 없으신 분은 회원가입을 해주세요.");
		System.out.print("[1] 회원가입 [2] 로그인>> ");

		int choice = sc.nextInt();
		return choice;

	}

	// 2. 회원가입을 위한 정보입력 메서드
	public UserVO showJoin() {
		System.out.print("ID 입력: ");
		String id = sc.next();
		System.out.print("PW 입력: ");
		String pw = sc.next();
		System.out.print("이름 입력: ");
		String name = sc.next();
		System.out.print("전화번호 입력: ");
		String phonenum = sc.next();

		UserVO uvo = new UserVO(id, pw, name, phonenum);
		return uvo;
	}

	// 3. 회원가입 결과 처리하는 메소드
	public void statusJoin(int row) {
		if (row > 0) {
			System.out.println("회원 가입되었습니다.");
		} else {
			System.out.println("회원가입을 다시 진행 해주세요.");
		}
	}

	// 4. 로그인 기능
	public UserVO showLogin() {
		System.out.print("ID:");
		String input_id = sc.next();
		System.out.print("PW:");
		String input_pw = sc.next();
		UserVO uvo = new UserVO();
		uvo.setId(input_id);
		uvo.setPw(input_pw);
		return uvo;

	}

	// 6. 로그인 결과 처리하는 메서드
	public void statusLogin(String result_name) {
		if (result_name != null) {
			System.out.println("\n로그인 성공");
			System.out.println(result_name + "님 환영합니다!");

		} else {
			System.out.println("로그인에 실패했습니다. 다시 시도 해주세요.");
		}
	}
	
	// 이벤트 확인 및 도서 목록 보기 메서드
	public int showMenu2() {
	      System.out.print("[1]이벤트 확인 [2]도서 목록보기>> ");
	      int choice2 = sc.nextInt();
	      
	      return choice2;
	      
	
	}
	
	// 이벤트 안내 후 보여줄 새로운 메뉴
    public int showEventAfterMenu() {
    	System.out.print("[1]도서목록 보기 [2]프로그램 종료>> ");
    	return sc.nextInt();
    	
    }
    
    
    
	   
	
	// 책 리스트 전체 출력
	public void statusAll(ArrayList<LibraryVO>list) {
        
        if(list.size() !=0) {
           for(LibraryVO lvo : list) {
              System.out.println(lvo.getBooknum()+"번) 도서명-"+lvo.getBookname()+" / 저자: "+lvo.getWriter()+" / 보유권수: "+lvo.getBcount()+"권");
           }
        }
     
}
	
	// 대출 or 프로그램
	public int showMenu3() {
		System.out.print("[1]대출하기 [2]프로그램 종료>> ");
		int choice3 = sc.nextInt();
		
		return choice3;
		
	}
	
	
	// 대출할 책 1권 출력
	public int borrowMenu() {
		System.out.print("대출 할 도서 번호 입력: ");
		int booknum = sc.nextInt();
		return booknum;
		
	}
	
	
	

}
	
	

	

