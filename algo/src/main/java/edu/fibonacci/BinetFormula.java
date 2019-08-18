package edu.fibonacci;


public class BinetFormula {

    public int getFib(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibNumber = (Math.pow((1 + sqrt5) / 2 , n) - Math.pow((1 - sqrt5) / 2 , n))/sqrt5;
        return (int)fibNumber;
    }

    public static void main(String[] args) {
        BinetFormula formula = new BinetFormula();
        for(int i=1;i<=10;i++){
            System.out.println(formula.getFib(i));
        }
    }
}
