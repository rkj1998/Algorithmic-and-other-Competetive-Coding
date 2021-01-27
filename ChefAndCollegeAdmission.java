/*
Chef recently got the result of the entrance test for his bachelor’s degree and is confused which college he will get.

Now, Chef wants an help to know the college which he may get on the basis of previous closing rank of college.

You are given a list of closing ranks (inclusive) of each college for last year. Your task is to predict the college number which Chef may get on the basis of his present rank.

Input:
First line contains an integer T, denoting the number of test cases.
First line of each test case contains R, the rank which the Chef got.
Second line of each test case contains N, the number of colleges he is looking for.
Third line contains N space separated integers, denoting the closing rank of each college in ascending order.
Output:
Output a single Integer for each test case , denoting the number of college Chef will get (treat indexing starting from 1).
Constraints
1 <= T <= 100
1 <= R <= max(A[1], A[2]… A[N])
1 <= N <= 1000
1 <= A[i] <= 100000
Sample Input:
1
86
6
20 40 60 80 100 120

Sample Output:
5
EXPLANATION:
Since, the closing rank of college 4 is 80 and closing rank of college 5 is 100, therefore Chef may get college 5.

*/



import java.util.*;

class ChefAndCollegeAdmission {

   static int collegeSelected(int collegeList[] , int rank ) {
       int selectedCollege = 0;
       if(collegeList[0]>=rank){
           selectedCollege = 1;
       }
       else {
           for(int i = 1;i<collegeList.length;i++){
            if(collegeList[i]>=rank){
                selectedCollege = i+1;
                break;
            }
           }
       }
       return selectedCollege;
    }

    public static void main(String[] args) {

        try {
            Scanner read = new Scanner(System.in);
            int t = read.nextInt();
            
            for (int i = 0 ; i < t ; i++){
                int rank = read.nextInt();
                int n = read.nextInt();
                int collegeList[] = new int[n];
                for (int j =0;j<n;j++){
                    collegeList[j] = read.nextInt();
                }
                System.out.println(collegeSelected(collegeList,rank));
                
            }
            read.close();
        }
        catch (Exception e) {}
    }
}