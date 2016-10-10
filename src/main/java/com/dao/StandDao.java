package com.dao;

import java.util.List;

import com.entity.Stand;

public interface StandDao {

	public void add(Stand stand);
	
	public Stand get(long id);
	
	public List<Stand> getAllByEmployee(long id);
	
	public void update(Stand stand);
	
	public void delete(Stand stand);
	
	public List<Stand> getAll();
	
	public Stand getByNumber(String number);
}
