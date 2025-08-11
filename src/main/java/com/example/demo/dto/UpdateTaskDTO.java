package com.example.demo.dto;

import lombok.Data;

public class UpdateTaskDTO {
	String descrption;
	String deadline;
	Boolean completed;
	/**
	 * @param descrption
	 * @param deadline
	 * @param completed
	 */
	public UpdateTaskDTO(String descrption, String deadline, Boolean completed) {
		super();
		this.descrption = descrption;
		this.deadline = deadline;
		this.completed = completed;
	}
	public String getDescrption() {
		return descrption;
	}
	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public Boolean getCompleted() {
		return completed;
	}
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
	

}
