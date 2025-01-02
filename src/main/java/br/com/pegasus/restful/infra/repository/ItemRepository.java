package br.com.pegasus.restful.infra.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pegasus.restful.domain.model.ItemModel;

@Repository
public interface ItemRepository extends JpaRepository<ItemModel, Long> {

	Optional<ItemModel> findByName(String name);
}
