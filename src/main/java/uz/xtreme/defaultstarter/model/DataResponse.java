package uz.xtreme.defaultstarter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataResponse {
	
	private boolean success;
	private String message;
	private Object data;
	
	public DataResponse(Object data) {
		super();
		this.success = true;
		this.message = "SUCCESS";
		this.data = data;
	}

}
