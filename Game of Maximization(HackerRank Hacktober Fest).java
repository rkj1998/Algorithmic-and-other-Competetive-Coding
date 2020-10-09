/*
Check The problem on :

https://www.hackerrank.com/contests/hackerrank-hackfest-2020/challenges/stones-piles/problem


*/



import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'maximumStones' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int maximumStones(List<Integer> arr) {
        int result = 0;
        int oddsum=0;
        int evensum = 0;
        for(int i=0;i<arr.size();i+=2){
            oddsum+=arr.get(i);
            if(i+1<arr.size()){
                evensum+=arr.get(i+1);

            }
        }
        if(oddsum>evensum){
            oddsum = oddsum - (oddsum-evensum);
            result = oddsum+evensum;
        }
        else if(evensum>oddsum){
            evensum = evensum - (evensum-oddsum);
            result = oddsum +evensum;
        }
        else {
            result = oddsum+evensum;
        }
        
        
        return result;
    }


}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.maximumStones(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
