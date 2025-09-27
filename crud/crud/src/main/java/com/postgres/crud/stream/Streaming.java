package com.postgres.crud.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import java.lang.*;

public class Streaming {

    public static void main(String[] args) {

        List<String> list = List.of("swapnil", "durga", "Sony");

        String s = list.stream().min(Comparator.comparing(x -> x.length())).get();
        //System.out.println(s);

        List<String> list1 = list.stream().filter(x -> x.charAt(0) == 's').toList();
        //System.out.println(list1);

        //pendulum

        int num = 12345;

        IntSummaryStatistics collect = Arrays.stream(String.valueOf(num).split("")).map(x -> Integer.valueOf(x)).collect(Collectors.summarizingInt(x -> x));
        //System.out.println(collect.getSum());

        List<Integer> collect1 = IntStream.rangeClosed(1, 10).map(x -> x * x).boxed().collect(Collectors.toList());
        //System.out.println(collect1);

        List<Integer> lista = List.of(20,0,1,7, 10, 2,3,4,5,6, 7);
        Integer key = lista.stream().collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
        //System.out.println(key);

        int retries = 6;
        while (retries-- > 0) {
            try {
                System.out.println(retries);
                if(retries == 2)
                {
                    throw new Exception("dfr");
                }
                //break;
            } catch (Exception ex) {
                if (retries == 0) try {
                    throw ex;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                try {
                    Thread.sleep(1000); // wait before retry
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }



    }
}
