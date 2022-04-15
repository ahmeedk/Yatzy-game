package com.ahmedk;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Yatzy {

    public static int chance(int d1, int d2, int d3, int d4, int d5) {
        return d1 + d2 + d3 + d4 + d5;
    }

    public static int yatzy(int d1, int d2, int d3, int d4, int d5) {
        List<Integer> dices = Stream.of(d1, d2, d3, d4, d5).filter(d -> d != d1).collect(Collectors.toList());

        if (dices.size() == 0) {
            return 50;
        }

        return 0;
    }

    public static int ones(int d1, int d2, int d3, int d4, int d5) {
        return sumOfTarget(d1, d2, d3, d4, d5, 1);
    }

    public static int twos(int d1, int d2, int d3, int d4, int d5) {
        return sumOfTarget(d1, d2, d3, d4, d5, 2);
    }

    public static int threes(int d1, int d2, int d3, int d4, int d5) {
        return sumOfTarget(d1, d2, d3, d4, d5, 3);
    }

    public static int fours(int d1, int d2, int d3, int d4, int d5) {
        return sumOfTarget(d1, d2, d3, d4, d5, 4);
    }

    public static int fives(int d1, int d2, int d3, int d4, int d5) {
        return sumOfTarget(d1, d2, d3, d4, d5, 5);
    }

    public static int sixes(int d1, int d2, int d3, int d4, int d5) {
        return sumOfTarget(d1, d2, d3, d4, d5, 6);
    }

    public static int sumOfTarget(int d1, int d2, int d3, int d4, int d5, int target) {
        return Stream.of(d1, d2, d3, d4, d5).filter(i -> i == target).mapToInt(i -> i).sum();
    }

    public static int score_pair(int d1, int d2, int d3, int d4, int d5) {

        List<Integer> list = Stream.of(d1, d2, d3, d4, d5).sorted().collect(Collectors.toList());

        for (int i = list.size() - 1; i > 0; i--) {
            if (Objects.equals(list.get(i), list.get(i - 1)))
                return list.get(i) * 2;
        }

        return 0;
    }

    public static int two_pair(int d1, int d2, int d3, int d4, int d5) {

        Map<Integer, Long> dicesOccurences = Stream.of(d1, d2, d3, d4, d5).collect(Collectors.groupingBy(p -> p, Collectors.counting()));

        Map<Integer, Long> twoPairMap = dicesOccurences.entrySet().stream().filter(aLong -> aLong.getValue() >= 2).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        if(twoPairMap.size()==2){
            return 2 * twoPairMap.keySet().stream().mapToInt(Integer::intValue).sum();
        }

        return 0;
    }

    public static int three_of_a_kind(int d1, int d2, int d3, int d4, int d5) {
        return number_of_a_kind(d1, d2, d3, d4, d5, 3);
    }

    public static int four_of_a_kind(int d1, int d2, int d3, int d4, int d5) {
        return number_of_a_kind(d1, d2, d3, d4, d5, 4);
    }

    public static int number_of_a_kind(int d1, int d2, int d3, int d4, int d5, int n) {
        Map<Integer, Long> dicesOccurences = Stream.of(d1, d2, d3, d4, d5).collect(Collectors.groupingBy(p -> p, Collectors.counting()));

        for (Map.Entry<Integer, Long> entry : dicesOccurences.entrySet()) {
            if (entry.getValue() >= n) {
                return n * entry.getKey();
            }
        }

        return 0;
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5) {

        List<Integer> dices = Stream.of(d1, d2, d3, d4, d5).collect(Collectors.toList());
        List<Integer> smallStraightList = Stream.of(1, 2, 3, 4, 5).filter(e -> !dices.contains(e)).collect(Collectors.toList());

        if (smallStraightList.size() == 0) {
            return 15;
        }
        return 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5) {

        List<Integer> dices = Stream.of(d1, d2, d3, d4, d5).collect(Collectors.toList());
        List<Integer> largeStraightList = Stream.of(2, 3, 4, 5, 6).filter(e -> !dices.contains(e)).collect(Collectors.toList());

        if (largeStraightList.size() == 0) {
            return 20;
        }
        return 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5) {

        Map<Integer, Long> dicesOccurences = Stream.of(d1, d2, d3, d4, d5).collect(Collectors.groupingBy(p -> p, Collectors.counting()));

        if (dicesOccurences.size() != 2) {
            return 0;
        }

        int sum = 0;
        for (Map.Entry<Integer, Long> entry : dicesOccurences.entrySet()) {
            sum = sum + entry.getKey()*Math.toIntExact(entry.getValue());
        }

        return sum;
    }

}
