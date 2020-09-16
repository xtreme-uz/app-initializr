package uz.xtreme.defaultstarter.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import uz.xtreme.defaultstarter.model.DataResponse;
import uz.xtreme.defaultstarter.service.AbstractService;

public abstract class AbstractController<T, S extends AbstractService<T>> {
	
	protected final S service;

	public AbstractController(S service) {
		super();
		this.service = service;
	}
	
	protected ResponseEntity<DataResponse> wrapResponse(String key, Object response) {
		Map<String, Object> data = new HashMap<>();
		data.put(key, response);
		return ResponseEntity.ok(new DataResponse(data));
	}

}
