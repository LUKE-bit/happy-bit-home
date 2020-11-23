import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> arr = new ArrayList<>();
        if(matrix==null || matrix.length==0 || matrix[0].length==0) {
            return arr;
        }
        int up = 0,down = matrix.length-1,left=0,right=matrix[0].length-1;
        while(true) {
            for(int col=left;col<=right;col++){
                arr.add(matrix[up][col]);
            }
            up++;
            if(up>down) {
                break;
            }
            for(int row = up;row<=down;row++) {
                arr.add(matrix[row][right]);
            }
            right--;
            if(left>right){     
                break;
            }
            for(int col = right;col>=left;col--) {
                arr.add(matrix[down][col]);
            }
            down--;
            if(down<up) {
                break;
            }
            for(int row = down;row>=up;row--) {
                arr.add(matrix[row][left]);
            }
            left++;
            if(left>right){    
                break;
            }
        }
        return arr;
    }
}
