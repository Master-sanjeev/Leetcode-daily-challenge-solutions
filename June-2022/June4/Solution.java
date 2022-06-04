import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> boards = new ArrayList();
        
        char[][] board = new char[n][n];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        
        dfs(0, n, boards, board);
        
        return boards;
    }
    
    public void dfs(int i, int n, List<List<String>> boards, char[][] board){
        if(i == n){
            List<String> curr_board = new ArrayList();
            for(int row=0; row<n; row++){
                curr_board.add(new String(board[row]));
            }
            boards.add(curr_board);
            return;
        }
        
        for(int j=0; j<n; j++){
            if(colCheck(i, j, board) && diagCheck1(i, j, board) && diagCheck2(i, j, board)){
                board[i][j] = 'Q';
                dfs(i+1, n, boards, board);
                board[i][j] = '.';
            }    
        }
        
        
    }
    
    public boolean colCheck(int row, int col, char[][] board){
        for(int i=0; i<board.length; i++){
            if(i == row) continue;
            
            if(board[i][col] == 'Q') return false;
        }
        
        return true;
    }
    
    public boolean diagCheck1(int i, int j, char[][] board){
        int row = i-1, col=j-1;
        while(row>=0 && col>=0){
            if(board[row][col] == 'Q') return false;
            row--;
            col--;
        }
        
        row = i+1;
        col = j+1;
        
        while(row<board.length && col<board.length){
            if(board[row][col] == 'Q') return false;
            row++;
            col++;
        }
        
        return true;
    }
    
    public boolean diagCheck2(int i, int j, char[][] board){
        int row = i-1, col = j+1;
        while(row>=0 && col<board.length){
            if(board[row][col] == 'Q') return false;
            row--;
            col++;
        }
        
        row = i+1;
        col = j-1;
        
        while(row<board.length && col>=0){
            if(board[row][col] == 'Q') return false;
            row++;
            col--;
        }
        
        return true;
    }
}