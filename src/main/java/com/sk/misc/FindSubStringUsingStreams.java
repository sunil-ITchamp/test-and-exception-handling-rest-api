package com.sk.misc;

import java.util.stream.IntStream;

public class FindSubStringUsingStreams {
    public static void main(String[] args) {
        //String mainString = "Hello World";
        //String subString = "World";
        //IntStream.range(0, mainString.length() - subString.length() + 1).forEach(i-> System.out.println(i));

        String mainString="I love java";
        String subString="java";
        //IntStream.range(0, mainString.length() - subString.length() + 1).forEach(i-> System.out.println(i));
        int index = findIndexUsingStreams(mainString, subString);
        System.out.println("Index of substring: " + index);
    }

    public static int findIndexUsingStreams(String mainString, String subString) {
        return IntStream.range(0, mainString.length() - subString.length() + 1)
                .filter(i ->
                {System.out.println(" Index = " + i + " And Substring taken from mainString = " + mainString.substring(i, i + subString.length()));
                    //System.out.println(mainString.substring(i, i + subString.length()));
                   return mainString.substring(i, i + subString.length()).equals(subString);
                })
                .findFirst()
                .orElse(-1);
    }
}

