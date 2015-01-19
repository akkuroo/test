package net.kkuru.demo;

public class User {
	private int idx;
	private String name;
	
	public User() {
	}
	
	public User(int idx, String name){
		this.idx = idx;
		this.name = name;
	}
	
	public int getIdx() {
		return idx;
	}
	public String getName() {
		return name;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public void setName(String name) {
		this.name = name;
	}
}
