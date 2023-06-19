//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            obj.printTriangle(n);
        }
    }
}
// } Driver Code Ends


class Solution {

    void printTriangle(int n) {
        // code here
        // divide the symmetry into 2 portions
        int spaces =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i;j++){
                System.out.print("*");
            }
            for(int j=0 ;j<spaces;j++){
                System.out.print(" ");
                
            }
            for(int j=0;j<n-i;j++){
                System.out.print("*");
            }
            spaces=spaces+2;
           
            System.out.println();
        }
        spaces-=2;
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print("*");
            }
            for(int j=0 ;j<spaces;j++){
                System.out.print(" ");
                
            }
            for(int j=0;j<=i;j++){
                System.out.print("*");
            }
            spaces=spaces-2;
           
            System.out.println();
        
        }
    }
}