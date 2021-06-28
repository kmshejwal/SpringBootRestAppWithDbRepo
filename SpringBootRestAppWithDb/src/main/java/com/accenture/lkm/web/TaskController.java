package com.accenture.lkm.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.lkm.dto.TaskBean;
import com.accenture.lkm.service.TaskServiceImpl;

@RestController
public class TaskController {

	@Autowired
	private TaskServiceImpl taskServiceImpl;

	@RequestMapping(value = "task/controller/getDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TaskBean>> getTaskDetails() {
		List<TaskBean> listTask = new ArrayList<TaskBean>(taskServiceImpl.getAllTasks());

		return new ResponseEntity<List<TaskBean>>(listTask, HttpStatus.OK);
	}

	// http://localhost:8080/projectName/task/controller/getDetailsById/1001
	@RequestMapping(value = "task/controller/getDetailsById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TaskBean> getTaskDetailByTaskId(@PathVariable("id") int myId) {
		TaskBean task = taskServiceImpl.getTask(myId);

		if (task != null) {
			return new ResponseEntity<TaskBean>(task, HttpStatus.OK);
		} else {
			return new ResponseEntity<TaskBean>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/task/controller/addTask", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_HTML_VALUE)
	public ResponseEntity<String> addTask(@RequestBody TaskBean task) {
		TaskBean newTask = taskServiceImpl.addTask(task);
		return new ResponseEntity<String>("Task added successfully with id:" + newTask.getId(), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/task/controller/deleteTask/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TaskBean> deleteTask(@PathVariable("id") int taskId) {
		TaskBean task2 = taskServiceImpl.getTask(taskId);
		if (task2 == null) {
			return new ResponseEntity<TaskBean>(task2, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		taskServiceImpl.deleteTask(taskId);
		return new ResponseEntity<TaskBean>(task2, HttpStatus.OK);
	}
}
