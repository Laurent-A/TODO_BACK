package com.laurent.todoapp.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "TASK")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
allowGetters = true)
public class task {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TASK_ID", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "TITLE", insertable=true, updatable=true, nullable=false)
    private String title;
	
	@Column(name = "STATE", insertable=true, updatable=true, nullable=false)
    private boolean state;
	
	@Column(name = "DETAIL", insertable=true, updatable=true, nullable=true)
    private String detail;

	public task() {
		super();
	}

	public task(Long id, String title, boolean state, String detail) {
		super();
		this.id = id;
		this.title = title;
		this.state = state;
		this.detail = detail;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	

}
