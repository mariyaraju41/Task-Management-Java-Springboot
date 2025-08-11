package com.example.demo.Services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.TaskEntity;

@Service
public class TaskServices {
    private ArrayList<TaskEntity> tasks = new ArrayList<>();
    private int taskId = 1;
    private final SimpleDateFormat deadlineFormatter=new SimpleDateFormat("YYYY-MM-DD");

    public TaskEntity addTask(String title, String description, String deadline) throws ParseException {
        TaskEntity task = new TaskEntity();
        task.setId(taskId);
        task.setTitle(title);
        task.setDescription(description);
       task.setDeadline(deadlineFormatter.parse(deadline)); // This still works but is deprecated
        task.setCompleted(false);

        tasks.add(task); // ✅ Fixed from task.add(task)
        taskId++;
        return task;
    }

    public ArrayList<TaskEntity> getTasks() {
        return tasks;
    }

    public TaskEntity getTaskById(int id) {
        for (TaskEntity task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }
    public TaskEntity updateTask(int id,String descrption,String deadline,Boolean completed)throws ParseException{
    	TaskEntity task=getTaskById(id);
    	if(task==null) {
    		return null;
    		
    	}
    	if(descrption!=null) {
    	  task.setDescription(descrption);
    	}
    	if(deadline!=null) {
    	task .setDeadline(deadlineFormatter.parse(deadline));
    	}
    	if(completed!=null) {
    	task.setCompleted(completed);
    	}
    	return task;
    	
    	
    }
}
