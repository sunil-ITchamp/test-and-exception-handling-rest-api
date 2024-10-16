package com.sk.misc;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExamples {

    public static void main(String[] args) {

        IntStream intStream = IntStream.of(1,2,3,4,5);
        DoubleStream doubleStream = DoubleStream.of (10.1,20.1,30.1,40.1,50.1);

        List<Integer> integerList = Arrays.asList(50,10,20,30,40);
        //1. First we have to covert this to stream
        //System.out.println( " Avg = " + integerList.stream().mapToInt(e-> e).average().getAsDouble());

        //2. Question --> are we able to AAPLY summaryStatistics to List<Integer> ???
        //System.out.println(integerList.stream().mapToInt(e-> e).summaryStatistics());

        //3. Print square and then filter
        integerList.stream().mapToInt(e-> e*e)
                            .filter(e-> e > 500)
                            .forEach(e-> System.out.println(e));

        //4. Print even and odd numbers
        Map<Boolean, List<Integer>> collect = integerList.stream().collect(Collectors.partitioningBy(e -> e % 2 == 0));
        System.out.println(" allMatch = " + integerList.stream().allMatch(e -> e % 2 == 0));
        //System.out.println(collect);

        //5. Java Streams Interview Question - 05 - Print Numbers Starts With Prefix 2 using Streams
        List<Integer> integerList5 = Arrays.asList(2,22,23,33,44,55);
//        integerList5.stream().map(e-> String.valueOf(e))
//                .filter(e-> e.startsWith("2") || e.startsWith("3"))
//                .forEach(System.out::println);

        //6. Java Streams Interview Question - 06 - Print Duplicate Numbers using Streams
        System.out.println("  +++ Java Streams Interview Question - 06 - Print Duplicate Numbers using Streams +++ ");
        List<Integer> integerList6 = Arrays.asList(11,12,33,44,55,11,12,12);
        Set<Integer> setOfUniqueIntegers = integerList6.stream().filter(e -> Collections.frequency(integerList6, e) > 1).collect(Collectors.toSet());
        System.out.println(setOfUniqueIntegers);

        Map<Integer, Long> collect1 = integerList6.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect1);
        System.out.println("Print only duplicates using Function.identity() AND Collectors.counting() ");
        //System.out.println(collect1.entrySet().stream().filter((e -> e.getValue() > 1)).collect(Collectors.toList()));
        collect1.entrySet().stream().filter((e -> e.getValue() > 1))
                .mapToInt(e-> e.getKey()).forEach(e-> System.out.println(e));


        // 10. Java Streams Interview Question - 10 - Get Second Highest/Lowest Number using Streams
        System.out.println("  +++ Question - 10 - Get Second Highest/Lowest Number using Streams +++ ");
        List<Integer> integerList10 = Arrays.asList(11,12,33,44,55,12,11);

        //pring second lowest
       integerList10.stream().sorted().distinct().skip(1).limit(1).forEach(e-> System.out.println(e));

        //pring second highest
        integerList10.stream().sorted(Collections.reverseOrder()).distinct().skip(1).limit(1).forEach(e-> System.out.println(e));

        //integerList6.stream().map(Function.identity()).collect(count)

        //sum
        //        OptionalInt reduce = intStream.reduce((left, right) -> (left + right));
        //        System.out.println( reduce.getAsInt());

        //Average - if the stream is already stream of Int
//        OptionalDouble optionalInt =  intStream.average();
//        System.out.println(optionalInt);
//
//        IntSummaryStatistics intSummaryStatistics = intStream.summaryStatistics();
//        System.out.println(intSummaryStatistics);
//
//        DoubleSummaryStatistics doubleSummaryStatistics = doubleStream.summaryStatistics();
//        System.out.println(doubleSummaryStatistics);

        String str = "hello java";
        String subString ="java";
        System.out.println(str.indexOf("java"));
        System.out.println(str.indexOf("my"));

        List<String> stringList = Arrays.asList(str.split(" "));

        stringList.stream().filter(e-> e.equals(subString)).collect(Collectors.toList()).forEach(e-> System.out.println(e));




    }
}
