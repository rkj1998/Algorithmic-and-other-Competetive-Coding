
import java.util.*;
public class App {
  
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int n = read.nextInt();
        int m = read.nextInt();
        int k = read.nextInt();
        int bill=0;
        char bills[][] = new char[n][m];
        for (int i = 0;i<n+1;i++){
            String reader = read.nextLine();
            for(int j=0;j<reader.length();j++){
                bills[i-1][j]=reader.charAt(j);
            }
        }
        if(k == 0){
            for(int i = 0 ;i<n;i++){
                for(int j = 0;j<m;j++){
                    if(bills[i][j]=='B'){
                        
                        for(int p = i;p<=i;p++){
                            for(int q =0;q<m;q++){
                                if(bills[p][q]!='B'){
                                    bills[p][q]='*';
                                }
                            }
                        }

                        for(int p=j;p<=j;p++){
                            for(int q = 0;q<n;q++){
                                if(bills[q][p]!='B'){
                                    bills[q][p]='*';
                                }
                            }
                        }
                    }
                }
            }

            for(int i =0;i<n;i++){
                for(int j =0;j<m;j++){
                    if(bills[i][j]!='*'&& bills[i][j]!='B'){
                        bill+=Character.getNumericValue(bills[i][j]);
                    }
                }
            }
        }

        else{
           char ReferenceArray[][]=new char[n][m];
           for(int i = 0;i<n;i++){
               for(int j=0;j<m;j++){
                   ReferenceArray[i][j]=bills[i][j];
               }
           }
           for(int i = 0 ;i<n;i++){
            for(int j = 0;j<m;j++){
                if(bills[i][j]=='B'){
                    
                    for(int p = i;p<=i;p++){
                        for(int q =0;q<m;q++){
                            if(bills[p][q]!='B'){
                                bills[p][q]='*';
                            }
                        }
                    }

                    for(int p=j;p<=j;p++){
                        for(int q = 0;q<n;q++){
                            if(bills[q][p]!='B'){
                                bills[q][p]='*';
                            }
                        }
                    }
                }

                }
            }
            ArrayList<Integer> dbills = new ArrayList<Integer>();
            ArrayList<Integer> undbill = new ArrayList<Integer>();

                for(int i =0;i<n;i++){
                    for(int j=0;j<m;j++){
                        if(bills[i][j]=='*'){
                            dbills.add(Character.getNumericValue(ReferenceArray[i][j]));
                        }
                        else if(bills[i][j]!='B'){
                            undbill.add(Character.getNumericValue(bills[i][j]));
                        }
                    }
                }

                Collections.sort(dbills, Collections.reverseOrder());
                Collections.sort(undbill);

                for(int swap=0;swap<k;swap++){
                    int temp = dbills.get(swap);
                    if(temp>undbill.get(swap)){
                        temp = undbill.get(swap);
                        undbill.set(swap, dbills.get(swap));
                        dbills.set(swap, temp);
                    }
                    
                }

                for(int i = 0 ;i<undbill.size();i++){
                    bill+=undbill.get(i);
                }


            }
        


        System.out.println(bill);
        read.close();
    }
}
