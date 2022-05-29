package org.bwangel.chapter1.ch1_1;

public class App {
    public static void main(String[] args) {
        System.out.println("Chapter 1 Example");
    }

    public static Integer sum(Integer a, Integer b) {
        return a + b;
    }

    /**
     * 判断整数 N 是否是素数
     * @param N 整数N
     * @return 是否是素数
     */
    public static Boolean IsPrime(Integer N) {
        if (N < 2) {
            return false;
        }

        for (int i = 2; i * i <= N; i++) {
            if (N % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     *  计算数字 N 的平方根结果
     *
     *  牛顿迭代法
     */
    public static Double Sqrt(Double N) {
        Double err = 1e-15;
        Double t = N;
        while( Math.abs(t-N/t) > err * t) {
            t = (N/t + t) / 2.0;
        }

        return t;
    }
}
