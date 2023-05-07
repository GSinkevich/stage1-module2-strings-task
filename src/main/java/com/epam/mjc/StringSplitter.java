package com.epam.mjc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {

        String delim = delimiters.toString();
        List<String> result = new ArrayList<>();
        var c = source.split(delim);
        for (String current : c) {
            if (!current.isEmpty()){
                result.add(current);
            }
        }
        return  result;
   }
}
