/*
Print Spiral Of A given Matrix
Time Complexity: O(m*n). 
To traverse the matrix O(m*n) time is required.
Space Complexity: O(1). 
No extra space is required.
*/





import java.util.*;


class SpiralMatrix {


    static void spirallyTraverse(int mat[][],int endRow,int endCols){
        int startRow =0;
        int startCols = 0;
        int i;


        while(startRow<endRow&&startCols<endCols){
            // Printing First Row
            for(i=startCols;i<endCols;i++){
                System.out.print(mat[startRow][i]+" ");
            }
            startRow++;
            //Printing end Column
            for(i=startRow;i<endRow;i++){
                System.out.print(mat[i][endCols-1]+" ");
            }
            endRow--;

            if(startRow<endRow){
                for(i=endCols-1;i>startCols;i--){
                    System.out.print(mat[endRow][i-1]+" ");
                }
                endCols--;
            }
            if(startCols<endCols){
                for(i=endRow-1;i>=startRow;i--){
                    System.out.print(mat[i][startCols]+" ");
                }
                startCols++;
            }
        }
        

    }
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int row = read.nextInt();
        int col = read.nextInt();
        int mat[][] = new int[row][col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                mat[i][j] = read.nextInt();
            }
        }

        spirallyTraverse(mat,row,col);



        read.close();
    }
}