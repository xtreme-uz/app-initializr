package uz.xtreme.defaultstarter.service;

import java.util.List;

public interface AbstractService<T> {
	
	T getById(long id);

	List<T> getAll();
	
	T save(T entity);
	
	void deleteById(long id);
	
}
