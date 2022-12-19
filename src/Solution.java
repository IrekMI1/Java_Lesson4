import java.util.ArrayDeque;

class Solution {
    public String simplifyPath(String path) {
        String[] pathArr = path.split("/");
        ArrayDeque<String> deque = new ArrayDeque<>();
        for (String s : pathArr) {
            if (s.equals("..") && !deque.isEmpty()) {
                deque.removeLast();
            } else if (!s.equals("") && !s.equals("..") && !s.equals(".")) {
                deque.add(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        while (!deque.isEmpty()) {
            sb.append(deque.poll());
            if (!deque.isEmpty()) {
                sb.append("/");
            }
        }
        return sb.toString();
    }

    public int maxAreaOfIsland(int[][] grid) {
        int size;
        int maxSize = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    size = getIslandArea(i, j, grid);
                    if (size > maxSize) {
                        maxSize = size;
                    }
                }
            }
        }
        return maxSize;
    }

    private int getIslandArea(int row, int col, int[][] grid) {
        int area = 0;
        int[][] offsets = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[] curPoint;
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{row, col});
        grid[row][col] = 0;
        while (!stack.isEmpty()) {
            curPoint = stack.pop();
            area++;
            for (int[] offset : offsets) {
                int newRow = curPoint[0] + offset[0];
                int newCol = curPoint[1] + offset[1];
                if ((0 <= newRow && newRow < grid.length) &&
                        (0 <= newCol && newCol < grid[0].length) &&
                        (grid[newRow][newCol] != 0)) {
                    stack.push(new int[]{newRow, newCol});
                    grid[newRow][newCol] = 0;
                }
            }
        }
        return area;
    }
}