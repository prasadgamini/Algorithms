package edu.knapsack.divisible;

import java.util.StringJoiner;

public class Item implements Comparable<Item> {
    private static int count = 0;
    private int id;
    private String name;
    private double profit;
    private double weight;
    private double profitPerUnitWeight;
    private double x; // 0 <= x <= 1;

    public Item(String name, double profit, double weight) {
        id = ++count;
        this.name = name;
        this.profit = profit;
        this.weight = weight;
        profitPerUnitWeight = profit/weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    @Override
    public int compareTo(Item otherItem) {
        return Double.compare(profitPerUnitWeight, otherItem.profitPerUnitWeight);
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", Item.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("profit=" + profit)
                .add("weight=" + weight)
                .add("profitPerUnitWeight=" + profitPerUnitWeight)
                .add("x=" + x)
                .toString();
    }
}
