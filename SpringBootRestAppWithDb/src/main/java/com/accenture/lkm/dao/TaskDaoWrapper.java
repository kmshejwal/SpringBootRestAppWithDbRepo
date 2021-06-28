package com.accenture.lkm.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accenture.lkm.dto.TaskBean;
import com.accenture.lkm.entity.TaskEntity;

@Repository
public class TaskDaoWrapper {

	@Autowired
	private TaskDao dao;

	public List<TaskBean> getAllTasks() {
		List<TaskBean> list = new ArrayList<TaskBean>();

		Iterable<TaskEntity> listEn = dao.findAll();
		listEn.forEach(x -> {
			TaskBean task = new TaskBean();
			BeanUtils.copyProperties(x, task);
			list.add(task);
		});
		return list;
	}

	public TaskBean getTask(Integer id) {
		TaskEntity x = dao.findById(id).get();
		TaskBean task = null;
		if (x != null) {
			task = new TaskBean();
			BeanUtils.copyProperties(x, task);
		}
		return task;
	}

	public TaskBean addTask(TaskBean task) {
		TaskEntity taskEntityBean = new TaskEntity();
		BeanUtils.copyProperties(task, taskEntityBean);
		TaskEntity en = dao.save(taskEntityBean);
		TaskBean task2 = new TaskBean();

		BeanUtils.copyProperties(en, task2);
		return task2;
	}

	public TaskBean updateTask(TaskBean task) {
		TaskEntity taskEntityBean = new TaskEntity();
		BeanUtils.copyProperties(task, taskEntityBean);
		TaskEntity en = dao.save(taskEntityBean);

		TaskBean task2 = new TaskBean();

		BeanUtils.copyProperties(en, task2);
		return task2;
	}

	public TaskBean deleteTask(int id) {
		TaskEntity x = dao.findById(id).get();
		TaskBean task = null;
		if (x != null) {
			dao.deleteById(id);
			task = new TaskBean();
			BeanUtils.copyProperties(x, task);
		}
		return task;
	}

}
