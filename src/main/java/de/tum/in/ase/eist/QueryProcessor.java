package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
           return "WolframAlpha";
        } else if(query.contains("plus") ){
            String[] numbers = query.split("plus");
            numbers[0] = numbers[0].replaceAll("[^0-9]", "");
            numbers[1] = numbers[1].replaceAll("[^0-9]", "");;
            return String.valueOf(Integer.valueOf((numbers[0]) + Integer.valueOf(numbers[1])));
        } else if(query.contains("largest") ){
            String[] testArray = query.split(", ");

            int max = Integer.MIN_VALUE, maxIndex = 0;

            for (int i = 0; i < testArray.length; i++) {
                if (Integer.parseInt(testArray[i]) > max) {
                    max = Integer.parseInt(testArray[i]);
                    maxIndex = i;
                }
            }
            return String.valueOf(max);
        }
        return "largest";
    }
}
