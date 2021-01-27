/*
Chef is on his invigilation duty and now it's the time to collect the answer sheets of N students.

All the N students are sitting in a single row but instead of sitting in order of their roll numbers they sat randomly. Now, Chef has to collect the answer sheets roll number wise. Chef's initial position is at the Desk1.

Find the minimum number of moves to collect all the N answer sheets in the order of their increasing roll numbers.

Input:
The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
The first line of each test case contains a single integer N.
The second line of each test case contains N space-separated distinct integers A[1],A[2],A[3].....A[N] describing A[i] roll number student is sitting on ith Desk.
Output:
For each testcase, output in a single line answer the minimum number of moves required.

Constraints
1<=T<=10
1<=N<=105
1<=A[i]<=N
Sample Input:
2
5
4 3 2 5 1
4
1 2 3 4

Sample Output:
11
3

EXPLANATION:
In 4 3 2 5 1, initial position is at desk1(4) where roll number is 4

desk1(4) -> desk2(3) -> desk3(2) -> desk4(5) -> desk5(1)

Answer Sheet of Roll number 1 collected, 4 moves

desk5(1) -> desk4(5) -> desk3(2)

Answer Sheet of Roll number 2 collected, 2 moves

desk3(2) -> desk2(3)

Answer Sheet of Roll number 3 collected, 1 move

desk2(3) -> desk1(4)

Answer Sheet of Roll number 4 collected, 1 move

desk1(4) -> desk2(3) -> desk3(2) -> desk4(5)

Answer Sheet of Roll number 5 collected, 3 moves

Total moves = 4+2+1+1+3 = 11 moves
*/


import java.util.*;


class ChefAndInvigilator {

    public static void main(String[] args){
        try{

            Scanner read = new Scanner(System.in);
            int t = read.nextInt();
            for(int i = 0;i<t;i++){
                int steps =0;
                HashMap <Integer, Integer> map = new HashMap<>(); 
                int n = read.nextInt();
                int currentIndex = 1;
                for(int j =1;j<=n;j++){
                    map.put(read.nextInt(),j);
                }
                for(int j = 1;j<=n;j++){
                     Integer val = map.get(j);
                     steps = steps + Math.abs(val - currentIndex);
                     currentIndex = val;
                }
                System.out.println(steps);                

            }
            read.close();

        }
        catch(Exception e){

        }

    }
}