package br.com.pegasus.restful.app.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemUpdateDTO {

	@NotBlank(message = "O nome esta em branco!")
	private String name;
}
