package model;

public class LibraryVO {
	private int booknum;
	private String bookname;
	private String writer;
	private int bcount;
	
	
	public LibraryVO() {
		
	}
	
	
	public LibraryVO(int booknum, String bookname, String writer, int bcount) {
		
		this.booknum = booknum;
		this.bookname = bookname;
		this.writer = writer;
		this.bcount = bcount;
	}
	
	
	public int getBooknum() {
		return booknum;
	}
	public void setBooknum(int booknum) {
		this.booknum = booknum;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getBcount() {
		return bcount;
	}
	public void setBcount(int bcount) {
		this.bcount = bcount;
	}
	
	
	
	
	
}
