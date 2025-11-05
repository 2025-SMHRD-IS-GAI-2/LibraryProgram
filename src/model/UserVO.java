package model;

public class UserVO {
	private String id;
	private String pw;
	private String name;
	private String phonenum;
	private int count;
	

	
	public UserVO(String id, String pw, String name, String phonenum) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phonenum = phonenum;
	}
	
	
	public UserVO() {
		
	}


	public UserVO(String id, String pw, String name, String phonenum, int count) {
		
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phonenum = phonenum;
		this.count = count;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhonenum() {
		return phonenum;
	}


	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
