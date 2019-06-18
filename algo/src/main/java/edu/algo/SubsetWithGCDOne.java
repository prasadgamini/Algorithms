package edu.algo;

import edu.algo.math.Util;

/*
 * Given two integer arrays arr[] and cost[] where cost[i] is the cost of choosing arr[i].
 * The task is to choose a subset with at least two elements such that the GCD of all the elements from the subset is 1 and the cost of choosing those elements is as minimum as possible then print the minimum cost.
 */
public class SubsetWithGCDOne {

    public static int getMinCost(int[] arr, int[] cost) {
        int minCost = Integer.MAX_VALUE;
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int gcd = Util.computeGCD(arr[i], arr[j]);
                if(gcd==1 && cost[i] + cost[j] < minCost) {
                    minCost = cost[i] + cost[j];
                    flag = true;
                }
            }
        }
        if(flag) return minCost;
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {5,10,12,1};
        int[] cost = {2,1,2,6};
        System.out.println(getMinCost(arr, cost));
    }
}
