package de.digitalfrontiers.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LCP {

    public String lcp(List<String> list) {
        if (list == null || list.isEmpty()) return "";
        String lcp = "";
        int index = 0;

        while (true) {
            char currentChar = 0;
            for (String word : list) {
                if (index == word.length()) {
                    return lcp;
                }
                if (currentChar == 0) {
                    currentChar = word.charAt(index);
                }
                if (currentChar != word.charAt(index)) {
                    return lcp;
                }
            }
            lcp += currentChar;
            index++;
        }
    }

    public static void main(String[] args) {
        LCP lcp = new LCP();

        System.out.println(lcp.lcp(Arrays.asList("interspecies", "interstellar", "interstate")).equals("inters"));
        System.out.println(lcp.lcp(Arrays.asList("throne", "throne")).equals("throne"));
        System.out.println(lcp.lcp(Arrays.asList("throne", "dungeon")).isEmpty());
        System.out.println(lcp.lcp(Collections.singletonList("cheese")).equals("cheese"));
        System.out.println(lcp.lcp(Collections.singletonList("")).isEmpty());
        System.out.println(lcp.lcp(Collections.emptyList()).isEmpty());
        System.out.println(lcp.lcp(null).isEmpty());
        System.out.println(lcp.lcp(Arrays.asList("prefix", "suffix")).isEmpty());
        System.out.println(lcp.lcp(Arrays.asList("foo", "foobar")).equals("foo"));
    }
}
