package br.com.pegasus.restful.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pegasus.restful.app.DTO.ItemCreateDTO;
import br.com.pegasus.restful.app.DTO.ItemUpdateDTO;
import br.com.pegasus.restful.domain.port.ItemServicePort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/item")
public class ItemController {

	private final ItemServicePort itemService;

	@GetMapping
	public ResponseEntity<List<Map<String, Object>>> findAll() {
		List<Map<String, Object>> result = itemService.findAll();
		return result.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(result);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Map<String, Object>> findById(@PathVariable Long id) {
		return ResponseEntity.ok(itemService.findById(id));
	}

	@PostMapping
	public ResponseEntity<Map<String, Object>> create(@Valid @RequestBody ItemCreateDTO body) {
		return new ResponseEntity<>(itemService.create(body), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		itemService.deletar(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Map<String, Object>> update(@PathVariable Long id, @Valid @RequestBody ItemUpdateDTO body) {
		return ResponseEntity.ok(itemService.update(id, body));
	}
}
