package br.com.pegasus.restful.domain.core;

import java.util.List;
import java.util.Map;

import br.com.pegasus.restful.app.DTO.ItemCreateDTO;
import br.com.pegasus.restful.app.DTO.ItemUpdateDTO;
import br.com.pegasus.restful.domain.adapter.ItemServicePersistenceAdapter;
import br.com.pegasus.restful.domain.model.ItemModel;
import br.com.pegasus.restful.domain.port.ItemServicePort;
import br.com.pegasus.restful.infra.constant.AppConstant;
import br.com.pegasus.restful.infra.exception.AdviceConflictException;
import br.com.pegasus.restful.infra.exception.AdviceNotFoundException;
import br.com.pegasus.restful.infra.method.AppMethod;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ItemServiceCore implements ItemServicePort {

	private final ItemServicePersistenceAdapter itemPersistence;

	@Override
	public List<Map<String, Object>> findAll() {
		List<ItemModel> modelList = itemPersistence.findAll();
		return AppMethod.toListMap(modelList);
	}

	@Override
	public Map<String, Object> findById(Long id) {
		return AppMethod.toMap(findByIdLiteral(id));
	}

	@Override
	public Map<String, Object> create(ItemCreateDTO body) {
		String name = body.getName();
		itemPersistence.findByName(name).ifPresent(model -> {
			throw new AdviceConflictException(AppConstant.MSG_CONFLICT_EXCEPTION.text);
		});
		ItemModel model = new ItemModel();
		model.setName(name);
		return AppMethod.toMap(itemPersistence.save(model));
	}

	@Override
	public void deletar(Long id) {
		findByIdLiteral(id);
		itemPersistence.delete(id);
	}

	@Override
	public Map<String, Object> update(Long id, ItemUpdateDTO body) {
		ItemModel model = findByIdLiteral(id);
		model.setName(body.getName());
		return AppMethod.toMap(itemPersistence.save(model));
	}

	private ItemModel findByIdLiteral(Long id) {
		ItemModel model = itemPersistence.findById(id)//
				.orElseThrow(() -> new AdviceNotFoundException(AppConstant.MSG_NOT_FOUND_EXCEPTION.text));
		return model;
	}
}
