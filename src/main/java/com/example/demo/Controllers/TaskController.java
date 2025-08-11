package com.example.demo.Controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.TaskEntity;
import com.example.demo.Services.TaskServices;
import com.example.demo.dto.CreateTaskDTo;
import com.example.demo.dto.ErrorResponseDto;
import com.example.demo.dto.UpdateTaskDTO;

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
	public ResponseEntity<TaskEntity>addTask(@RequestBody CreateTaskDTo body) throws ParseException{
		var task= taskservices.addTask(body.getTitle(), body.getDescription(), body.getDeadline());
		 return  ResponseEntity.ok(task);
	 }
	 
	 @PatchMapping("/{id}")
	 public ResponseEntity<TaskEntity>updateTask(@PathVariable("id")Integer id,@RequestBody UpdateTaskDTO body)throws ParseException{
		var task=taskservices.updateTask(id,body.getDescrption(),body.getDeadline(),body.getCompleted() );
		if(task== null) {
			return ResponseEntity.notFound().build();
		}
		
		 return ResponseEntity.ok(task);
	 }
      @ExceptionHandler(Exception.class)
      public ResponseEntity<ErrorResponseDto>handleErrors(Exception e){
    	  if(e instanceof ParseException) {
    		  return ResponseEntity.badRequest().body(new ErrorResponseDto("Invalid Date Format"));    	  
    	  
      }
      e.printStackTrace();
      return ResponseEntity.internalServerError().body(new ErrorResponseDto("Internal Server Error"));
}
      
}
      
