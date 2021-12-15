package com.laurent.todoapp.main.dto;

public class TodoDto {

	private String title;
    private boolean state;
    private String detail;
    
	public String getTitle() {
		return title;
	}
	public boolean isState() {
		return state;
	}
	public String getDetail() {
		return detail;
	}
	public TodoDto(String title, boolean state, String detail) {
		super();
		this.title = title;
		this.state = state;
		this.detail = detail;
	}
	
	

}
