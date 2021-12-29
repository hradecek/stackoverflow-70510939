package com.hradecek.stackoverflow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DataFrame {

	private final Map<Object, List<Object>> frameInfo = new HashMap<>();

	public Map<Object, List<Object>> query(String keySelector, Predicate<Object> valuePredicate) {
		final List<Object> row = frameInfo.get(keySelector);
		final List<Integer> indices = getColumnIndex(row, valuePredicate);

		return getColumnMap(indices);
	}

	private List<Integer> getColumnIndex(List<Object> row, Predicate<Object> valuePredicate) {
		return IntStream.range(0, row.size()).filter(columnIndex -> valuePredicate.test(row.get(columnIndex))).boxed().collect(Collectors.toList());
	}

	private Map<Object, List<Object>> getColumnMap(List<Integer> columnIndices) {
		final Map<Object, List<Object>> result = new HashMap<>();
		for (Map.Entry<Object, List<Object>> entry : frameInfo.entrySet()) {
			for (int columnIndex : columnIndices) {
				result.putIfAbsent(entry.getKey(), new ArrayList<>());
				result.get(entry.getKey()).add(entry.getValue().get(columnIndex));
			}
		}
		return result;
	}

	public void addData(String key, Object value) {
		frameInfo.putIfAbsent(key, new ArrayList<>());
		frameInfo.get(key).add(value);
	}

	public void setData(String key, List<Object> values) {
		frameInfo.put(key, values);
	}
}
