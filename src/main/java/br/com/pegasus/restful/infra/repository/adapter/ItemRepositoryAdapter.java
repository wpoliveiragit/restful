package br.com.pegasus.restful.infra.repository.adapter;

import java.util.List;
import java.util.Optional;

import br.com.pegasus.restful.domain.adapter.ItemServicePersistenceAdapter;
import br.com.pegasus.restful.domain.model.ItemModel;
import br.com.pegasus.restful.infra.repository.ItemRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ItemRepositoryAdapter implements ItemServicePersistenceAdapter {

	private final ItemRepository itemRepository;

	@Override
	public List<ItemModel> findAll() {
		return itemRepository.findAll();
	}

	@Override
	public Optional<ItemModel> findById(Long id) {
		return itemRepository.findById(id);
	}

	@Override
	public Optional<ItemModel> findByName(String name) {
		return itemRepository.findByName(name);
	}

	@Override
	public ItemModel save(ItemModel item) {
		return itemRepository.save(item);
	}

	@Override
	public void delete(Long id) {
		itemRepository.deleteById(id);
	}
}
