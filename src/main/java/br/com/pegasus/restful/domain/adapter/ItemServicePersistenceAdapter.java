package br.com.pegasus.restful.domain.adapter;

import java.util.List;
import java.util.Optional;

import br.com.pegasus.restful.domain.model.ItemModel;

public interface ItemServicePersistenceAdapter {

	List<ItemModel> findAll();

	Optional<ItemModel> findById(Long id);

	Optional<ItemModel> findByName(String name);

	ItemModel save(ItemModel item);

	void delete(Long id);

}
