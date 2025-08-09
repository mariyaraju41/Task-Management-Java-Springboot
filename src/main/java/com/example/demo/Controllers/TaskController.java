package com.example.demo.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.TaskEntity;
import com.example.demo.Services.TaskServices;
import com.example.demo.dto.CreateTaskDTo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/tasks")
public class TaskController {
	private final TaskServices taskservices;
	 public TaskController(TaskServices taskServices) {
		 this.taskservices=taskServices;
	 }
	
	 @GetMapping("")
	 public ResponseEntity<List<TaskEntity>>getTasks(){
		 var tasks=taskservices.getTasks();
		 return ResponseEntity.ok(tasks);
	 }
	 @GetMapping("/{id}")
	 public ResponseEntity<TaskEntity>getTaskById(@PathVariable("id")Integer id){
		 var task=taskservices.getTaskById(id);
		 if(task == null) {
			 return  ResponseEntity.notFound().build();
		 }
		 return ResponseEntity.ok(task);
	 }
	 @PostMapping("")
	public ResponseEntity<TaskEntity>addTask(@RequestBody CreateTaskDTo body){
		var task= taskservices.addTask(body.getTitle(), body.getDescription(), body.getDeadline());
		 return  ResponseEntity.ok(task);
	 }

}
