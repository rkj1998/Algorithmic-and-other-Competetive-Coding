/* 
Google Kickstart problem (Countdown):-  https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ff43/00000000003380d2

Problem
Avery has an array of N positive integers. The i-th integer of the array is Ai.

A contiguous subarray is an m-countdown if it is of length m and contains the integers m, m-1, m-2, ..., 2, 1 in that order. For example, [3, 2, 1] is a 3-countdown.

Can you help Avery count the number of K-countdowns in her array?

Input
The first line of the input gives the number of test cases, T. T test cases follow. Each test case begins with a line containing the integers N and K. The second line contains N integers. The i-th integer is Ai.

Output
For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the number of K-countdowns in her array.

Limits
Time limit: 20 seconds.
Memory limit: 1 GB.
1 ≤ T ≤ 100.
2 ≤ K ≤ N.
1 ≤ Ai ≤ 2 × 105, for all i.
Test Set 1
2 ≤ N ≤ 1000.
Test Set 2
2 ≤ N ≤ 2 × 105 for at most 10 test cases.
For the remaining cases, 2 ≤ N ≤ 1000.
Sample
Sample Input
save_alt
content_copy
3
12 3
1 2 3 7 9 3 2 1 8 3 2 1
4 2
101 100 99 98
9 6
100 7 6 5 4 3 2 1 100
Sample Output
save_alt
content_copy
Case #1: 2
Case #2: 0
Case #3: 1
In sample case #1, there are two 3-countdowns as highlighted below.

1 2 3 7 9 3 2 1 8 3 2 1
1 2 3 7 9 3 2 1 8 3 2 1
In sample case #2, there are no 2-countdowns.

In sample case #3, there is one 6-countdown as highlighted below.

100 7 6 5 4 3 2 1 100
*/

import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        try {
            int test = read.nextInt();
            for(int t=1;t<=test;t++){
                int n = read.nextInt();
                int count = 0;
                int cdowns = read.nextInt();
                int array[] = new int[n];
                for(int i = 0;i<n;i++){
                    array[i] = read.nextInt();
                }
                int decreasing_count = 0;
                for(int i=1;i<n;i++){
                    if(array[i] == array[i-1]-1){
                        decreasing_count+=1;
                    }
                    else{
                        decreasing_count=0;
                    }
                    if(array[i]==1&&decreasing_count>=cdowns-1){
                        count++;
                    }
                }
                System.out.println("Case #"+t+": "+count);
                
            }
        } catch (Exception e) {
            //TODO: handle exception
        }

        read.close();
    }
}