package org.example.streams;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindEvenNumberStream {
    public List<Integer> findStartsWith1Number(List<Integer> list){

        return list.stream()
                .filter(n -> n.toString().startsWith("1"))
                .collect(Collectors.toList());

    }

    public List<Integer> findEvenNumber(List<Integer> list){

        return list.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

    }



    // find duplicate elements in a given integers list in java using Stream functions
    public List<Integer> findDupsNumber(List<Integer> list) {
        Set<Integer> set = new HashSet<>();

        return list.stream()
                .filter(l -> !set.add(l))
                .collect(Collectors.toList());
    }

    public static boolean findMorethan3Number(List<Integer> list) {
        Set<Integer> set = new HashSet<>();
        return list.stream()
                .filter(l -> !set.add(l))
                .collect(Collectors.toList()).size() >= 2;
    }

    public List<Integer> findElementInList(List<Integer> list) {
        //return list.stream()
                //.findFirst().stream().toList();
        return null;
    }

    public Long findCountInList(List<Integer> list) {
        return list.stream()
                .count();
    }

    public Integer findMaxInList(List<Integer> list) {
        return list.stream()
                .max(Integer::compare).get();
    }

    public char firstNonRepeated(String str) {

        return str.chars()
                .mapToObj(s -> Character.toLowerCase(Character.valueOf((char)(s))))
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1L)
                .map(entry -> entry.getKey())
                .findFirst()
                .get();

    }

    public char firstRepeatedChar(String str){

        return str.chars()
                .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s)))
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1L)
                .map(e -> e.getKey())
                .findFirst()
                .get();

    }

    public List<Integer> getSortElementInList(List<Integer> list) {
        return list.stream()
                .sorted().collect(Collectors.toList());

    }

    public List<Integer> getSortInReverseOrderInList(List<Integer> list) {
        return list.stream()
                .sorted(Collections.reverseOrder()).collect(Collectors.toList());

    }




    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10,20,12,24,15,17,18,19,20,20,20,12,12);//10,20,12,20,
        FindEvenNumberStream numberStream = new FindEvenNumberStream();

        List<Integer> evennos=numberStream.findEvenNumber(list);
        System.out.println(evennos);

        List<Integer> startswith1nos=numberStream.findStartsWith1Number(list);
        System.out.println(startswith1nos);

        List<Integer> dupelement = numberStream.findDupsNumber(list);
        System.out.println(dupelement);

        List<Integer> firstElement = numberStream.findElementInList(list);
        System.out.println(firstElement);

        Long countInList = numberStream.findCountInList(list);
        System.out.println(countInList);

        Integer maxInList = numberStream.findMaxInList(list);
        System.out.println(maxInList);

        List<Integer> sortElement = numberStream.getSortElementInList(list);
        System.out.println(sortElement);

        List<Integer> reverseOrderSort = numberStream.getSortInReverseOrderInList(list);
        System.out.println(reverseOrderSort);

        String str = "Java articles are AweSome";
        char findFirst = numberStream.firstNonRepeated(str);
        System.out.println(findFirst);

        char findFirstRepeated = numberStream.firstRepeatedChar(str);
        System.out.println(findFirstRepeated);

        boolean checkDupFlag = numberStream.checkAtLeastTwiceNum(list);
        System.out.println("check at least twice num "+checkDupFlag);

        System.out.println(currentDatetime());

        concateStream();

        System.out.println(performCubeAndFilter(list));

        sortElementAndStream(list);

        System.out.println("findMorethan3Number = " + findMorethan3Number(list));
    }

    private static void sortElementAndStream(List<Integer> list) {

        List<Integer> s = list.stream()
                .sorted()
                .toList();

    }

    private static List<Double> performCubeAndFilter(List<Integer> list) {

        return list.stream()
                .map(n -> Math.pow(n,3))
                .filter(n -> n > 50)
                .collect(Collectors.toList());

    }

    private static void concateStream() {
        String[] a = new String[]{"a", "b", "c"};
        String[] b = new String[]{"d", "e", "f"};

        Stream<String> conStream = Stream.concat(Stream.of(a),Stream.of(b));
        conStream.forEach(System.out::println);
    }

    private static LocalDateTime currentDatetime() {
        return LocalDateTime.now();
    }

    private boolean checkAtLeastTwiceNum(List<Integer> list) {
        //Set<Integer> set = new HashSet<>(list);
        //return set.size() != list.size();

        Set<Integer> set = list.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .filter(k -> k.getValue() == 1L)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        return set.size() != list.size();
    }
    
}