package com.accenture.lkm.service;

import java.util.List;

import com.accenture.lkm.dto.TaskBean;

public interface TaskService {

	TaskBean addTask(TaskBean task);

	TaskBean getTask(int taskId);
	
	TaskBean deleteTask(int taskId);

	List<TaskBean> getAllTasks();

}