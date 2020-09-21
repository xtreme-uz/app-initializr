package uz.xtreme.defaultstarter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import uz.xtreme.defaultstarter.exception.ObjectNotFoundException;

public abstract class GenericAbstractService<T, R extends JpaRepository<T, Long>> implements AbstractService<T> {

	protected final R repository;

	public GenericAbstractService(R repository) {
		super();
		this.repository = repository;
	}

	@Override
	public T getById(long id) {
		Optional<T> entity = repository.findById(id);
		if (entity.isPresent())
			return entity.get();
		else
			throw new ObjectNotFoundException("PERMISSION_NOT_FOUND");
	}

	@Override
	public List<T> getAll() {
		return repository.findAll();
	}

	@Override
	public T save(T entity) {
		return repository.save(entity);
	}

	@Override
	public void deleteById(long id) {
		repository.deleteById(id);
	}

}
