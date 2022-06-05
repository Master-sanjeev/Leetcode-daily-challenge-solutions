import java.util.*;
public class Main{
    public static void main(String[] args) {
        Solution s = new Solution();
        
        int n = Integer.valueOf(args[0]);


        System.out.println(s.totalNQueens(n));
    }
}
