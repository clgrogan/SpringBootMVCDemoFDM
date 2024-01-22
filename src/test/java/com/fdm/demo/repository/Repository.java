package com.fdm.demo.repository;

import java.util.List;
import java.util.Optional;

public interface Repository <T, ID>{
	T save(T t); // represents update and create
	Optional<T> findById(ID id);
	List<T> findAll();
	boolean existsById(ID id);
	void deleteById(ID id);
	
}
