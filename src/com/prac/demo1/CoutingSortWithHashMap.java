package com.prac.demo1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CoutingSortWithHashMap {

	public static void main(String[] args) {
		Integer arr[] = {0, 1, 55, 2, 2, 2, 2, 1, 0, -4, -2, -6};
		HashMap<Integer, Integer> countValueWithKeyMap = new HashMap<>();
		List<Integer> negetiveList = new ArrayList<>();
		List<Integer> possitiveList = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			countValueWithKeyMap.put(i, arr[i]);
		}

		Map<Integer, Long> countvalues = countValueWithKeyMap.values().stream()
				.collect(Collectors.groupingBy(Function.identity(),
						Collectors.counting()));
		System.out.println("Values Count : " + countvalues);

		countvalues.entrySet().forEach(values -> {
			addKeysTotheList(negetiveList, possitiveList, values);
		});
		Collections.reverse(negetiveList);
		negetiveList.addAll(possitiveList);
		System.out.println(negetiveList);
	}

	/**
	 * @param negetiveList
	 * @param possitiveList
	 * @param values
	 */
	protected static void addKeysTotheList(List<Integer> negetiveList,
			List<Integer> possitiveList, Entry<Integer, Long> values) {
		Long len = values.getValue();
		for (int i = 0; i < len; i++) {
			if (values.getKey() < 0) {
				negetiveList.add(values.getKey());
			} else {
				possitiveList.add(values.getKey());
			}
		}
	}
}
