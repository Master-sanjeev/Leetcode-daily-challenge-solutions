import java.util.*;

class Solution {
    
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j]  = '.';
            }
        }
        
        return dfs(0, board);
        
    }
    
    public int dfs(int row, char[][] board){
        
        if(row == board.length){
            return 1;
        }
        
        int count = 0;
        for(int j=0; j<board.length; j++){
            if(checkCol(j, board) && mainDiagCheck(row, j, board) && auxDiagCheck(row, j, board)){
                board[row][j] = 'Q';
                count += dfs(row+1, board);
                board[row][j] = '.';
            }
        }
        
        return count;
        
    }
    
    public boolean checkCol(int c, char[][] board){
        for(int r=0; r<board.length; r++){
            if(board[r][c] == 'Q') return false;
        }
        
        return true;
    }
    
    public boolean mainDiagCheck(int r, int c, char[][] board){
        int i=r, j=c;
        
        while(i>=0 && j>=0){
            if(board[i][j] == 'Q') return false;
            
            i--;
            j--;
        }
        
        i=r;
        j=c;
        
        while(i<board.length && j<board.length){
            if(board[i][j] == 'Q') return false;
            i++;
            j++;
        }
        
        return true;
    }
    
    public boolean auxDiagCheck(int r, int c, char[][] board){
        int i=r, j=c;
        
        while(i>=0 && j<board.length){
            if(board[i][j] == 'Q') return false;
            
            i--;
            j++;
        }
        
        i=r;
        j=c;
        
        while(i<board.length && j>=0){
            if(board[i][j] == 'Q') return false;
            i++;
            j--;
        }
        
        return true;
    }
}