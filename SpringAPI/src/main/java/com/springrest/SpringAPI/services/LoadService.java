package com.springrest.SpringAPI.services;

import java.util.*;

import org.springframework.stereotype.Service;

import com.springrest.SpringAPI.entities.Load;

public interface LoadService {
	
	public List<Load> getLoad();
	/*
	 * These methods will call the functions that are present in the child class
	 *i.e., the class that implements this interface and override its methods
	 *This is called Run Time Polymorphism
	 */

	public Optional<Load> getLoad(long id);
	
	public Load addLoad(Load loadObject);
	
	public Load updateLoad(Load loadObject);
	
	public void deleteLoad(long id);
	
}
