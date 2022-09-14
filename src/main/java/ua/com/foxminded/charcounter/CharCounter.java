package ua.com.foxminded.charcounter;

import java.util.*;

public class CharCounter {
    
    protected static final Map<String, Map<Character, Integer>> cashedCharSequences = new HashMap<>();

    public Map<Character, Integer> calculateCharsAmount(String charSequence) {
        cashedCharSequences.computeIfAbsent(charSequence,k -> getCharsAmount(k));
        return cashedCharSequences.get(charSequence); 
    }
    
    protected Map<Character, Integer> getCharsAmount(String word) {
        return word.chars()
                    .mapToObj(c -> Character.valueOf((char)Character.toLowerCase(c)))
                    .collect(LinkedHashMap::new,
                            (map, item) -> {map.computeIfPresent(item, (k, v) -> v + 1);
                                            map.putIfAbsent(item, 1);}, 
                            Map::putAll);
    }
}
