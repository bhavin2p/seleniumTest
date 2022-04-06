package javaCollections;

import java.util.HashMap;
import java.util.HashSet;

public class HashMapCompare {

	public static void main(String[] args) {
		
		HashMap<Integer, String> map1 = new HashMap<>();
		
		map1.put(1, "A");
		map1.put(2, "B");
		map1.put(3, "C");
		
		HashMap<Integer, String> map2 = new HashMap<>();
		
		map2.put(3, "C");
		map2.put(1, "A");
		map2.put(2, "B");
		
		HashMap<Integer, String> map3 = new HashMap<>();
		
		map3.put(3, "C");
		map3.put(1, "A");
		map3.put(2, "B");
		map3.put(3, "D");
		
		System.out.println(map1.equals(map2));
		
		System.out.println(map1.equals(map3));
		
		
		System.out.println(map1.keySet().equals(map3.keySet()));
		
		HashMap<Integer, String> map4 = new HashMap<>();
		
		map4.put(3, "C");
		map4.put(1, "A");
		map4.put(2, "B");
		map4.put(4, "D");
		
		HashSet<Integer> combineKeys = new HashSet<>(map1.keySet());
		combineKeys.addAll(map4.keySet());
		
		combineKeys.removeAll(map1.keySet());
		System.out.println(combineKeys);
		
		
		
		
	}

}
