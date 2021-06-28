package com.accenture.lkm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.lkm.entity.TaskEntity;

public interface TaskDao  extends JpaRepository<TaskEntity, Integer>{

}
