import java.util.ArrayDeque;

class UpdateMatrix {
    public int[][] updateMatrix(int[][] mat) {
        int empty = Integer.MAX_VALUE;
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    deque.add(new int[]{i, j});
                } else {
                    mat[i][j] = empty;
                }
            }
        }

        while (!deque.isEmpty()) {
            int[] curPoint = deque.poll();
            for (int[] direction : directions) {
                int newRow = curPoint[0] + direction[0];
                int newCol = curPoint[1] + direction[1];
                if ((0 <= newRow && newRow < mat.length) &&
                        (0 <= newCol && newCol < mat[0].length) &&
                        mat[newRow][newCol] == empty) {
                    mat[newRow][newCol] = mat[curPoint[0]][curPoint[1]] + 1;
                    deque.add(new int[]{newRow,newCol});
                }
            }
        }

        return mat;
    }
}