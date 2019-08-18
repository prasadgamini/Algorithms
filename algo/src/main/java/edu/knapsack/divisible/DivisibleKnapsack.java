package edu.knapsack.divisible;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This problem allows to include fractions of items
 * <p>
 * https://www.youtube.com/watch?v=oTTzNMHM05I
 */
public class DivisibleKnapsack {

    /**
     * Given a list of items with a profit and weight, and these items are divisible, eg: vegetables
     * Knapsack capacity is 'm' Returns list of fractions of items to be included
     * such that total weight is <= m & profit is maximum
     *
     * @param items List of items with weight and profit, remember these are divisible
     * @param m
     * @return List of portions of the item can be included
     */
    public void getOptimizedKnapscakX(List<Item> items, double m) {
        Collections.sort(items, Collections.reverseOrder());

        double includedWeight = 0.0;

        for (Item item : items) {
            if(includedWeight + item.getWeight() <= m) {
                item.setX(1.0);
                includedWeight += item.getWeight();
            } else {
                double remainingWeight = m-includedWeight;
                double fractionToTake = remainingWeight/item.getWeight();
                item.setX(fractionToTake);
                includedWeight += (fractionToTake * item.getWeight());
//                break;
            }
        }
    }

    public static void main(String[] args) {
        Item item1 = new Item("Mangoes", 10,2);
        Item item2 = new Item("Oranges", 5,3);
        Item item3 = new Item("Peaches", 15,5);
        Item item4 = new Item("Apples", 7,7);
        Item item5 = new Item("Cherries", 6,1);
        Item item6 = new Item("Bananas", 18,4);
        Item item7 = new Item("Pears", 3,1);

        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);
        items.add(item7);

        DivisibleKnapsack algo =  new DivisibleKnapsack();
        algo.getOptimizedKnapscakX(items, 15);

        double totalProfit = 0.0;
        double totalWeight = 0.0;
        for(Item item: items) {
            totalProfit += item.getX() * item.getProfit();
            totalWeight += item.getX() * item.getWeight();
        }

        System.out.println("Total weight in Knapsack :: " + totalWeight);
        System.out.println("Total Profit with Knapsack :: " + totalProfit);

        items.forEach(System.out::println);
    }
}
