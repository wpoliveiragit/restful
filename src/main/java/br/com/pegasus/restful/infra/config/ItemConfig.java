package br.com.pegasus.restful.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.pegasus.restful.domain.core.ItemServiceCore;
import br.com.pegasus.restful.domain.port.ItemServicePort;
import br.com.pegasus.restful.infra.repository.ItemRepository;
import br.com.pegasus.restful.infra.repository.adapter.ItemRepositoryAdapter;

@Configuration
public class ItemConfig {

	@Bean
	public ItemServicePort itemServicePort(ItemRepository itemRepository) {
		return new ItemServiceCore(new ItemRepositoryAdapter(itemRepository));
	}
}
