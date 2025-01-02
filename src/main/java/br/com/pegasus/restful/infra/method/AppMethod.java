package br.com.pegasus.restful.infra.method;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.pegasus.restful.infra.constant.AppConstant;

public final class AppMethod {

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	public static final ResponseEntity<Map<String, Object>> createExceptionResponse(//
			String detail, HttpStatus httpStatus) {
		Map<String, Object> responseBody = Map.of( //
				AppConstant.MAP_KEY_CODE.text, httpStatus.value(), //
				AppConstant.MAP_KEY_MESSAGE.text, httpStatus.getReasonPhrase(), //
				AppConstant.MAP_KEY_DETAIL.text, detail//
		);
		return new ResponseEntity<>(responseBody, httpStatus);
	}

	public static final <K, V> Map<K, V> toMap(Object value) {
		return OBJECT_MAPPER.convertValue(value, new TypeReference<Map<K, V>>() {
		});
	}

	public static final <K, V> List<Map<K, V>> toListMap(List<?> list) {
		return list.stream() //
				.map(item -> AppMethod.<K, V>toMap(item)) //
				.collect(Collectors.toList());
	}
}
