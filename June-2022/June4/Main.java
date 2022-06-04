import java.util.*;
public class Main{
    public static void main(String[] args) {
        Solution s = new Solution();
        
        int n = Integer.valueOf(args[0]);
        List<List<String>> ans = s.solveNQueens(n);

        for(List<String> board : ans){
            for(String row : board){
                System.out.println(row);
            }

            System.out.println("\n\n");
        }
    }
}