package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class CreateTaskDTo {
/**
	 * @param title
	 * @param description
	 * @param deadline
	 */
	public CreateTaskDTo(String title, String description, String deadline) {
		super();
		this.title = title;
		this.description = description;
		this.deadline = deadline;
	}
String title;
String description;
String deadline;
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getDeadline() {
	return deadline;
}
public void setDeadline(String deadline) {
	this.deadline = deadline;
}
}
