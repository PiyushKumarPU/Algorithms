package com.learning.leet.code;

import java.util.HashMap;
import java.util.Map;

public class TrieBucket {
    public Map<Character, TrieBucket> cache;

    public TrieBucket() {
        cache = new HashMap<>();
    }
}
