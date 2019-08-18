package edu.fibonacci;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.TemporalUnit;
import java.util.HashMap;
import java.util.Map;

public class FibonacciSequence {

    private Map<Integer, Long> memonizationMap;

    public FibonacciSequence() {
        this.memonizationMap = new HashMap<>();
        this.memonizationMap.put(0, 0l);
        this.memonizationMap.put(1, 1l);
    }

    public long getFibDP(int n) {
        if (memonizationMap.containsKey(n)) {
            return memonizationMap.get(n);
        }
        long val = getFibDP(n - 1) + getFibDP(n - 2);
        memonizationMap.put(n, val);
        return val;
    }

    public long getFibRecursive(int n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return getFibRecursive(n - 1) + getFibRecursive(n - 2);
    }

    public static void main(String[] args) {
        FibonacciSequence fibonacciSequence = new FibonacciSequence();
//        for (int i = 0; i <= 10; i++) {
//            System.out.println(fibonacciSequence.getFibRecursive(i));
//        }
//        System.out.println("=====================================");
//        for (int i = 0; i <= 10; i++) {
//            System.out.println(fibonacciSequence.getFibDP(i));
//        }

        LocalDateTime startTime =LocalDateTime.now();

        System.out.println(fibonacciSequence.getFibDP(50));
        Duration duration = Duration.between(startTime, LocalDateTime.now());
        System.out.println("DP Time in Seconds --> " + duration);


        LocalDateTime startTime2 =LocalDateTime.now();

        System.out.println(fibonacciSequence.getFibRecursive(50));
        Duration duration2 = Duration.between(startTime2, LocalDateTime.now());
        System.out.println("Recursive Time in Seconds --> " + duration2);
    }
}
