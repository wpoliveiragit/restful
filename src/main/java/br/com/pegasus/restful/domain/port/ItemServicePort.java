package br.com.pegasus.restful.domain.port;

import java.util.List;
import java.util.Map;

import br.com.pegasus.restful.app.DTO.ItemCreateDTO;
import br.com.pegasus.restful.app.DTO.ItemUpdateDTO;

public interface ItemServicePort {

	List<Map<String, Object>> findAll();

	Map<String, Object> findById(Long id);

	Map<String, Object> create(ItemCreateDTO dto);

	void deletar(Long id);

	Map<String, Object> update(Long id, ItemUpdateDTO item);

}
