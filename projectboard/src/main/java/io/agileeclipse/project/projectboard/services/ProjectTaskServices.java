package io.agileeclipse.project.projectboard.services;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.agileeclipse.project.projectboard.domain.ProjectTask;
import io.agileeclipse.project.projectboard.repository.ProjectTaskRepository;

@Service
public class ProjectTaskServices {

	@Autowired
	private ProjectTaskRepository projectTaskRepository;

	public ProjectTask saveOrUpdateProjectTask(ProjectTask projectTask) {
		if(projectTask.getStatus() == null || projectTask.getStatus().equals("")) {
			projectTask.setStatus("TO_DO");
		}

		return projectTaskRepository.save(projectTask);
	}

	public Iterable<ProjectTask> getAllProjectTaskBoard() {
		Iterable<ProjectTask> pList = projectTaskRepository.findAll();

		return pList;
	}

	public ProjectTask getById(Long id) {	
		ProjectTask prTask = findById(id);
		return prTask;
	}

	public ProjectTask remove(Long id) {
		ProjectTask prTask = findById(id);		
		projectTaskRepository.delete(prTask);
		return prTask;
	}



	private ProjectTask findById(Long id) {
		ProjectTask pTask = projectTaskRepository.findById(id).orElse(null);		

		if(null == pTask) {
			throw new RuntimeErrorException(null, "unable to find id " + id);
		}
		return pTask;
	}

}










