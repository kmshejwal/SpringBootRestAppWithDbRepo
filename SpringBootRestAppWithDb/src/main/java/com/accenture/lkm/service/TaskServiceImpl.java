package com.accenture.lkm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.dao.TaskDao;
import com.accenture.lkm.dao.TaskDaoWrapper;
import com.accenture.lkm.dto.TaskBean;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskDaoWrapper taskDao;

	@Override
	public TaskBean addTask(TaskBean task) {
		return taskDao.addTask(task);
	}

	@Override
	public List<TaskBean> getAllTasks() {
		return taskDao.getAllTasks();
	}

	@Override
	public TaskBean getTask(int taskId) {
		// TODO Auto-generated method stub
		return taskDao.getTask(taskId);
	}

	@Override
	public TaskBean deleteTask(int taskId) {
		// TODO Auto-generated method stub
		return taskDao.deleteTask(taskId);
	}
}
