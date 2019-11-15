import java.util.HashMap;
import java.util.HashSet;

// Given n and m which are the dimensions of a 
// matrix initialized by zeros and given an array
// indices where indices[i] = [ri, ci]. For each
// pair of [ri, ci] you have to increment all cells 
// in row ri and column ci by 1.

// Return the number of cells with odd values in the
// matrix after applying the increment to all indices.


// [0, 0, 0] [(0,0)  (0,1), (0,2)] => indices = [[0,1], [1,1]]
// [0, 0, 0] [(1,0)  (1,1), (1,2)]  
        
// rows: {0, 1}
// [1 1 1] => [1 1 1]
// [0 0 0]    [1 1 1]

// cols: {1}
// [1 2 1]
// [1 2 1]

//             [1 2 1]  =>  [1 3 1]
//             [0 1 0]      [1 3 1]

public class Solution {
    public static int oddCells(int n, int m, int[][] indices) {
        
        HashMap<Integer, Integer> rowIndCount = new HashMap<>();
        HashMap<Integer, Integer> colIndCount = new HashMap<>();

        // Initialize empty 2D array with 0s
        int[][] arr = new int[n][m];
        for (int[] ind: indices) {
            fillUpMap(rowIndCount, ind[0]);
            fillUpMap(colIndCount, ind[1]);
        }
        
        // Iterate through rowIndCount and update all indexes accordingly 
        for (int key: rowIndCount.keySet()) {
            for (int j = 0; j < m; j++) {
                arr[key][j] += rowIndCount.get(key);
            }
        }

        for (int key: colIndCount.keySet()) {
            for (int i = 0; i < n; i++) {
                arr[i][key] += colIndCount.get(key);
            }
        }
        int count = returnCountOfOdd(arr);
        return count;
    }

    public static void fillUpMap(HashMap<Integer, Integer> map, int key) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + 1);
        } else {
            map.put(key, 1);
        }
    }

    public static int returnCountOfOdd(int[][] arr) {
        int count = 0; 
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] % 2 != 0) {
                    count += 1;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] indices = new int[2][2];
        indices[0][0] = 0;
        indices[0][1] = 1;
        indices[1][0] = 1;
        indices[1][1] = 1;
        oddCells(2, 3, indices);
    }
}