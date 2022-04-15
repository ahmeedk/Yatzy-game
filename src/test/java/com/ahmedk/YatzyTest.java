package com.ahmedk;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class YatzyTest {


    @Test
    public void sumOfTarget_2(){
        Assertions.assertEquals(4,Yatzy.sumOfTarget(1,2,2,4,5,2));
        Assertions.assertEquals(2,Yatzy.sumOfTarget(1,2,2,1,5,1));
    }

    @Test
    public void chance_scores_sum_of_all_dice() {
        Assertions.assertEquals(15, Yatzy.chance(2,3,4,5,1));
        Assertions.assertEquals(16, Yatzy.chance(3,3,4,5,1));
        Assertions.assertEquals(18, Yatzy.chance(5,3,4,5,1));
    }

    @Test public void yatzy_scores_50() {
        Assertions.assertEquals(50, Yatzy.yatzy(4,4,4,4,4));
        Assertions.assertEquals(50, Yatzy.yatzy(6,6,6,6,6));
        Assertions.assertEquals(0, Yatzy.yatzy(6,6,6,6,3));
        Assertions.assertEquals(0, Yatzy.yatzy(1,1,1,5,5));
    }

    @Test public void test_1s() {
        Assertions.assertEquals(1,Yatzy.ones(1,2,3,4,5));
        Assertions.assertEquals(2, Yatzy.ones(1,2,1,4,5));
        Assertions.assertEquals(0, Yatzy.ones(6,2,2,4,5));
        Assertions.assertEquals(4, Yatzy.ones(1,2,1,1,1));
    }

    @Test
    public void test_2s() {
        Assertions.assertEquals(4, Yatzy.twos(1,2,3,2,6));
        Assertions.assertEquals(10, Yatzy.twos(2,2,2,2,2));
        Assertions.assertEquals(6, Yatzy.twos(2,3,4,2,2));
        Assertions.assertEquals(0, Yatzy.twos(3,4,5,1,1));
    }

    @Test
    public void test_threes() {
        Assertions.assertEquals(6, Yatzy.threes(1,2,3,2,3));
        Assertions.assertEquals(12, Yatzy.threes(2,3,3,3,3));
        Assertions.assertEquals(3, Yatzy.threes(4,1,3,5,2));
        Assertions.assertEquals(0, Yatzy.threes(2,1,5,4,2));
    }

    @Test
    public void fours_test()
    {
        Assertions.assertEquals(12, Yatzy.fours(4,4,4,5,5));
        Assertions.assertEquals(8, Yatzy.fours(4,4,5,5,5));
        Assertions.assertEquals(4, Yatzy.fours(4,5,5,5,5));
        Assertions.assertEquals(0, Yatzy.fours(1,5,3,2,5));
    }

    @Test
    public void fives() {
        Assertions.assertEquals(10, Yatzy.fives(4,4,4,5,5));
        Assertions.assertEquals(15, Yatzy.fives(4,4,5,5,5));
        Assertions.assertEquals(20, Yatzy.fives(4,5,5,5,5));
        Assertions.assertEquals(0, Yatzy.fives(4,1,3,2,2));
    }

    @Test
    public void sixes_test() {
        Assertions.assertEquals(0, Yatzy.sixes(4,4,4,5,5));
        Assertions.assertEquals(6, Yatzy.sixes(4,4,6,5,5));
        Assertions.assertEquals(12, Yatzy.sixes(6,5,1,6,5));
        Assertions.assertEquals(18, Yatzy.sixes(6,5,6,6,5));
    }

    @Test
    public void one_pair() {
        Assertions.assertEquals(6, Yatzy.score_pair(3,4,3,5,6));
        Assertions.assertEquals(10, Yatzy.score_pair(5,3,3,3,5));
        Assertions.assertEquals(12, Yatzy.score_pair(5,3,6,6,5));
        Assertions.assertEquals(0, Yatzy.score_pair(5,3,6,2,1));
    }

    @Test
    public void two_Pair() {
        Assertions.assertEquals(16, Yatzy.two_pair(3,3,5,4,5));
        Assertions.assertEquals(18, Yatzy.two_pair(4,4,5,5,5));
        Assertions.assertEquals(6, Yatzy.two_pair(1,1,2,2,5));
        Assertions.assertEquals(12, Yatzy.two_pair(1,2,2,4,4));
        Assertions.assertEquals(14, Yatzy.two_pair(3,3,3,4,4));
        Assertions.assertEquals(0, Yatzy.two_pair(1,2,2,3,5));
    }

    @Test
    public void three_of_a_kind()
    {
        Assertions.assertEquals(9, Yatzy.three_of_a_kind(3,3,3,4,5));
        Assertions.assertEquals(15, Yatzy.three_of_a_kind(5,3,5,4,5));
        Assertions.assertEquals(12, Yatzy.three_of_a_kind(4,4,4,4,5));
        Assertions.assertEquals(0, Yatzy.three_of_a_kind(3,1,3,2,5));
    }

    @Test
    public void four_of_a_kind() {
        Assertions.assertEquals(12, Yatzy.four_of_a_kind(3,3,3,3,5));
        Assertions.assertEquals(20, Yatzy.four_of_a_kind(5,5,5,4,5));
        Assertions.assertEquals(16, Yatzy.four_of_a_kind(3,4,4,4,4));
        Assertions.assertEquals(0, Yatzy.four_of_a_kind(3,1,3,5,3));
    }

    @Test
    public void smallStraight() {
        Assertions.assertEquals(15, Yatzy.smallStraight(1,2,3,4,5));
        Assertions.assertEquals(15, Yatzy.smallStraight(2,3,4,5,1));
        Assertions.assertEquals(0, Yatzy.smallStraight(1,2,2,4,5));
        Assertions.assertEquals(0, Yatzy.smallStraight(1,2,3,3,5));
    }

    @Test
    public void largeStraight() {
        Assertions.assertEquals(20, Yatzy.largeStraight(6,2,3,4,5));
        Assertions.assertEquals(20, Yatzy.largeStraight(2,3,4,5,6));
        Assertions.assertEquals(0, Yatzy.largeStraight(1,2,2,4,5));
        Assertions.assertEquals(0, Yatzy.largeStraight(2,2,3,4,5));
    }

    @Test
    public void fullHouse() {
        Assertions.assertEquals(18, Yatzy.fullHouse(6,2,2,2,6));
        Assertions.assertEquals(8, Yatzy.fullHouse(1,1,2,2,2));
        Assertions.assertEquals(0, Yatzy.fullHouse(2,3,4,5,6));
        Assertions.assertEquals(0, Yatzy.fullHouse(4,4,4,4,4));
    }
}
