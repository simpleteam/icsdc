package com.dao;

import java.util.List;

import com.entity.Stand;

public interface StandDao {

	public void add(Stand stand);
	
	public Stand get(long id);
	
	public List<Stand> getAllByEmployee(long id);
	
}
