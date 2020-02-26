package io.agileeclipse.project.projectboard.web;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.agileeclipse.project.projectboard.domain.ProjectTask;
import io.agileeclipse.project.projectboard.services.ProjectTaskServices;

@RestController
@RequestMapping("/api/board")
@CrossOrigin
public class PorjectTaskController {

	@Autowired
	ProjectTaskServices projectTaskServices;
	
	
	@PostMapping("")
	public ResponseEntity<?> addProjectTaskBoard(@Valid @RequestBody ProjectTask projectTask, BindingResult bResult) {
		
		if(bResult.hasErrors()) {
			Map<String, String> errormap = new HashMap<String, String>();
			for(FieldError error : bResult.getFieldErrors()) {
				errormap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>> (errormap, HttpStatus.BAD_REQUEST);
		}
		
		ProjectTask newP = projectTaskServices.saveOrUpdateProjectTask(projectTask);
		
		return new ResponseEntity<ProjectTask>(newP, HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<Iterable<ProjectTask>> getAllProjectTask() {
		Iterable<ProjectTask> list = projectTaskServices.getAllProjectTaskBoard();
		return new ResponseEntity<Iterable<ProjectTask>>(list, new HttpHeaders(), HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getProjectTaskById(@PathVariable  Long id) {
		ProjectTask ptask = projectTaskServices.getById(id);		
		return new ResponseEntity<ProjectTask>(ptask, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProject(@PathVariable Long id) {
		projectTaskServices.remove(id); 
		return new ResponseEntity<String>("projecttask deleted", HttpStatus.OK);
	}
}

















