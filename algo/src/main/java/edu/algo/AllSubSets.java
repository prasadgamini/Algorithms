package edu.algo;

public class AllSubSets {

    public void printAllSubSets(int[] data) {
        Integer[] subset = new Integer[data.length];
        helper(data, subset, 0);
    }

    public void helper(int[] data, Integer[] subset, int i) {
        if (i == data.length) {
            print(subset);
        } else {
            subset[i] = null;
            helper(data, subset, i + 1);
            subset[i] = data[i];
            helper(data, subset, i + 1);
        }
    }

    private void print(Integer[] subset) {
        for (int i = 0; i < subset.length; i++) {
            if (subset[i] != null) {
                System.out.print(subset[i] + ",");
            }
        }
        System.out.println("");
    }

    public static void main(String args[]) {
        AllSubSets allSubSets = new AllSubSets();
        allSubSets.printAllSubSets(new int[] {10, 20, 30});
    }

}