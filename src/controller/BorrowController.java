package controller;

import java.util.ArrayList;
import model.*;
import view.UserView;

public class BorrowController {
	public void run() {
		UserView view = new UserView();
		UserDAO udao = new UserDAO();
		LibraryDAO ldao = new LibraryDAO();

		while (true) {
			int choice = view.showMenu(); // 1번 메뉴, [1]회원가입 or [2]로그인

			if (choice == 1) {
				// 회원가입
				UserVO user = view.showJoin();
				int row = udao.join(user);
				view.statusJoin(row);

			} else if (choice == 2) {
				// 로그인
				UserVO user = view.showLogin();
				String result = udao.login(user);
				view.statusLogin(result);

				if (result != null) {
					//  로그인 성공 시 루프 관리용 변수 추가

					while (true) {
						int choice2 = view.showMenu2(); // 2번 메뉴, [1] 이벤트 확인 [2] 도서 목록보기 [3] 랜덤 책 추천
						if (choice2 == 1) {// 이벤트 확인
							System.out.println("충돌시켜버리기!!!");
							view.EventMenu();
							int count = udao.event(user);
							view.showEventResult(count);

							int nextChoice = view.showEventAfterMenu(); // 새로 추가한 이벤트 안내 후, 메뉴 메서드
							if (nextChoice == 1) { // 이벤트 선택 이후, [1] 도서목록 보기 선택
								ArrayList<LibraryVO> list = ldao.selectAll();
								view.statusAll(list);

								int choice3 = view.showMenu3(); // 메뉴 3번, 대출하기 or 프로그램 종료
								if (choice3 == 1) { // 대출하기
									int booknum = view.borrowMenu();
									LibraryVO book = ldao.selectOne(booknum);

									if (book != null && book.getBcount() > 0) {
										ldao.borrowBook(book);
										udao.borrowCount(user);
										view.borrowSuccess(book);
									} else {
										view.borrowFail();
									}
								} else if (choice3 == 2) { // 프로그램 종료 선택
									view.programExit();
									System.exit(0);
								}
							} else if (nextChoice == 2) { // 이벤트 선택 이후 [2]종료 선택
								view.programExit();
								System.exit(0);
							}
						}

						else if (choice2 == 2) { // 2 도서 목록 보기
							ArrayList<LibraryVO> list = ldao.selectAll();
							view.statusAll(list);

							int choice3 = view.showMenu3(); // [1]대출 [2]프로그램 종료 메뉴
							if (choice3 == 1) {// 대출 성공
								int booknum = view.borrowMenu();
								LibraryVO book = ldao.selectOne(booknum);

								if (book != null && book.getBcount() > 0) {
									ldao.borrowBook(book);
									udao.borrowCount(user);
									view.borrowSuccess(book);
								} else {// 대출 실패
									view.borrowFail();
								}
							} else if (choice3 == 2) {// 프로그램 종료
								view.programExit();
								System.exit(0);
							}
						}
						else if(choice2==3) {// 랜덤 책 추천
							ArrayList<LibraryVO> list2 = ldao.getRandomBooks(3);
							view.statusRandom(list2);
							int choice3 = view.showMenu3(); // [1]대출 [2]프로그램 종료 메뉴
							if (choice3 == 1) {// 대출 성공
								int booknum = view.borrowMenu();
								LibraryVO book = ldao.selectOne(booknum);

								if (book != null && book.getBcount() > 0) {
									ldao.borrowBook(book);
									udao.borrowCount(user);
									view.borrowSuccess(book);
								} else {// 대출 실패
									view.borrowFail();
								}
							} else if (choice3 == 2) {// 프로그램 종료
								view.programExit();
								System.exit(0);
							}
						}else if(choice2==4) {
							view.programExit();
							System.exit(0);
						}
						
						

					} 
				} else {// 로그인 실패시 
					view.loginFail();;
				}
			 // else if(choice==2)
		} // while(true)
	} // run()
}
	

}