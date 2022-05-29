package org.bwangel.chapter1.ch1_1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Rectangle {
    public static void main(String[] args) {
//        Rectangle.DrawRandomRectangle();
        Rectangle.DrawSortedRectangle();
    }

    public static void DrawRectangle(double nums[], int N) {
        for (int i = 0; i < N; i++) {
            // x,y 表示矩形的中心点
            // rw 是宽度的一半
            // rh 是高度的一半
            double rw = 0.5/N;
            double x = 1.0 * i / N + rw;
            double y = nums[i] / 2.0;
            double rh = nums[i] / 2.0;
            System.out.printf("%s %s %s %s\n", i, y, rw, rh);
            StdDraw.filledRectangle(x, y, rw, rh);
        }
    }

    public static void DrawSortedRectangle() {
        int N = 50;
        double[] nums = new double[N];

        for (int i = 0; i < N; i++) {
            // num belongs to [0,1)
            nums[i] = StdRandom.uniform();
        }

        Arrays.sort(nums);
        DrawRectangle(nums, N);
    }

    public static void DrawRandomRectangle() {
        int N = 50;
        double[] nums = new double[N];

        for (int i = 0; i < N; i++) {
            // num belongs to [0,1)
            nums[i] = StdRandom.uniform();
        }

        DrawRectangle(nums, N);
    }
}
