package com.tivamo.game;

import java.util.HashMap;

public class Level {

	public static void levels() {
		HashMap<String, HashMap<Integer, Integer>> map1 = new HashMap<String, HashMap<Integer, Integer>>();
		HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
		map2.put(5, 6);
		map1.put("easy", map2);
		System.out.println(map1.get("easy").keySet());
	}
}
