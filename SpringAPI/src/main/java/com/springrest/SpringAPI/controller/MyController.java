package com.springrest.SpringAPI.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.SpringAPI.entities.Load;
import com.springrest.SpringAPI.services.LoadService;


//Telling spring boot that we have made a controller
//Creating REST API : Representational State Transfer Application Programming Interface
@RestController
public class MyController {

	/*
	 * Creating a LoadService interface type object which will call it's child class
	 * LoadServiceImplementation
	 * @AutoWired will create the object of "interface" type and it will inject that
	 * in loadServiceObject which is defined here
	 * This happens according to Dependency injection rule in Spring
	 */
	@Autowired
	private LoadService loadServiceObject;
	
	@GetMapping("/home")
	public String home()
	{
		return "Welcome to Travel Services !";
	}
	
	/*
	 * Get the list of load
	 */
	@GetMapping("/load")
	public List<Load> getLoad()
	{
		return this.loadServiceObject.getLoad();
	}
	/*
	 * Get a single load
	 */
	
	@GetMapping("/load/{shipperId}")
	public Optional<Load> getLoad(@PathVariable String shipperId)
	{
		//Long is sent not long
		return this.loadServiceObject.getLoad(Long.parseLong(shipperId));
	}
	
	/*
	 * Posting load as json object : POST Request Mapping
	 */
	@PostMapping("/load")
	public Load addLoad(@RequestBody Load loadObject)
	{
		return this.loadServiceObject.addLoad(loadObject);
	}
	
	/*
	 * Updating a load : PUT Request Mapping
	 */
	@PutMapping("/load/{shipperId}")
	public Load updateLoad(@RequestBody Load loadObject)
	{
		return this.loadServiceObject.updateLoad(loadObject);
	}
	
	/*
	 * Delete the load
	 */
	@DeleteMapping("/load/{shipperId}")
	public ResponseEntity<HttpStatus> deleteLoad(@PathVariable String shipperId)
	{
		try {
			this.loadServiceObject.deleteLoad(Long.parseLong(shipperId));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
