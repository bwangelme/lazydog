package org.bwangel.chapter1.ch1_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * 运行此方法需要从文件中读取数字,所以在终端中执行以下命令来运行
 * ø> java -classpath target/classes:lib/algs4.jar org.bwangel.ch1_1.BinarySearch binary data/tinyAllowlist.txt < data/tinyText.txt
 * 50
 * 99
 * 13
 *
 * 统计程序的运行时间
 * 设 M 是 whitelist 中数字的个数，N 是 输入的数字个数
 * ø> time java -classpath target/classes:lib/algs4.jar org.bwangel.ch1_1.BinarySearch binary data/largeAllowlist.txt < data/largeText.txt > /dev/null
 * java -classpath target/classes:lib/algs4.jar org.bwangel.ch1_1.BinarySearch    8.69s user 0.33s system 111% cpu 8.055 total
 * 他的复杂度是 O(log(M) + log(M) * N)
 *
 * ø> time java -classpath target/classes:lib/algs4.jar org.bwangel.ch1_1.BinarySearch for data/largeAllowlist.txt < data/largeText.txt > /dev/null
 * 运行了10分钟结果还没有出来，他的复杂度是 O(N * M)，估计会跑很久。
 */
public class BinarySearch {
    public static int binaryRank(int key, int[] whitelist) {
        int lo = 0;
        int hi = whitelist.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key > whitelist[mid]) {
                lo = mid + 1;
            } else if (key < whitelist[mid]) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int forRank(int key, int[] whitelist) {
        for (int i = 0; i < whitelist.length; i++) {
            if (key == whitelist[i]) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String rankWay = args[0];
        In stream = new In(args[1]);
        int[] whitelist = stream.readAllInts();

        if (rankWay.equals("binary")) {
            Arrays.sort(whitelist);
        }

        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (rankWay.equals("binary")) {
                if (binaryRank(key, whitelist) < 0) {
                    StdOut.println(key);
                }
            } else if (rankWay.equals("for")) {
                if (forRank(key, whitelist) < 0) {
                    StdOut.println(key);
                }
            }

        }
    }
}
