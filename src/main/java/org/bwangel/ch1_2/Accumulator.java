package org.bwangel.ch1_2;

/**
 * 本程序是一个计算方差和样本标准差的工具
 * 样本标准差的计算公式是
 * <p>
 * S = sqrt( ( (i-mean(list))^2 for i in list) / N-1 )
 * mean(list) 表示样本中数据的平均值
 * N 表示样本的大小
 * sqrt 表示开平方
 */
public class Accumulator {
    private int N = 0;
    private Double mean = 0.0;
    private Double s = 0.0;

    public void AddNumber(Integer x) {
        N++;
        s = s + 1.0 * (N - 1) / N * (x - mean) * (x - mean);
        mean = mean + (x - mean) / N;
    }

    /**
     * 返回平均值
     */
    public Double Mean() {
        return mean;
    }

    /**
     * 返回方差
     */
    public Double Var() {
        return s / (N - 1);
    }

    /**
     * 返回样本标准差
     */
    public Double Stddev() {
        return Math.sqrt(s);
    }
}
