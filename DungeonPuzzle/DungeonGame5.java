import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DungeonGame5 {
    private int[][] grid;
    private int m;
    private int n;
    private static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};  // Up, Right, Down, Left

    DungeonGame5(int m, int n) {
        grid = new int[m][n];
        this.m = m;
        this.n = n;
    }

    public int findMinSteps(int startX, int startY, int endX, int endY, int[][][] previous) {
        if (startX == endX && startY == endY) {
            return 0;
        }
        
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        dp[startX][startY] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            int currentSteps = dp[currentX][currentY];

            for (int[] direction : DIRECTIONS) {
                int newX = currentX + direction[0];
                int newY = currentY + direction[1];

                if (newX >= 0 && newY >= 0 && newX < m && newY < n && dp[newX][newY] == Integer.MAX_VALUE && grid[newX][newY] != Integer.MAX_VALUE) {
                    dp[newX][newY] = currentSteps + 1;
                    queue.add(new int[]{newX, newY});
                    previous[newX][newY] = new int[]{currentX, currentY}; 
                }
            }
        }

        return dp[endX][endY] == Integer.MAX_VALUE ? -1 : dp[endX][endY];
    }

    public void printPath(int startX, int startY, int endX, int endY, int[][][] previous) {
        LinkedList<int[]> path = new LinkedList<>();
        int currentX = endX;
        int currentY = endY;

        while (currentX != startX || currentY != startY) {
            path.addFirst(new int[]{currentX, currentY});
            int[] prev = previous[currentX][currentY];
            currentX = prev[0];
            currentY = prev[1];
        }
        path.addFirst(new int[]{startX, startY}); 

        for (int[] p : path) {
            System.out.print("(" + (p[0] + 1) + "," + (p[1] + 1) + ") -> ");
        }
        System.out.println("End");
    }

    public static void game(int adventureX, int adventureY, int goldX, int goldY, int[][] pit, int m, int n) {
        DungeonGame5 dungeon = new DungeonGame5(m, n);

        adventureX -= 1;
        adventureY -= 1;
        goldX -= 1;
        goldY -= 1;
        
        for (int[] p : pit) {
            dungeon.grid[p[0] - 1][p[1] - 1] = Integer.MAX_VALUE;
        }
        
        int[][][] previous = new int[m][n][2];

        int adventureStep = dungeon.findMinSteps(adventureX, adventureY, goldX, goldY, previous);

        if (adventureStep == -1) {
            System.out.println("No possible solution to reach the gold.");
        } else {
            System.out.println("Minimum number of steps to reach the gold: " + adventureStep);
            dungeon.printPath(adventureX, adventureY, goldX, goldY, previous);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Dimensions of Dungeon (mx n): ");
        int m = sc.nextInt();
        int n = sc.nextInt();

        System.out.println("\nPosition of adventurer: ");
        int adventureX = sc.nextInt();
        int adventureY = sc.nextInt();

        System.out.println("\nPosition of gold: ");
        int goldX = sc.nextInt();
        int goldY = sc.nextInt();

        System.out.println("\nEnter number of pits: ");
        int pitNo = sc.nextInt();
        int[][] pit = new int[pitNo][2];
        for (int i = 0; i < pitNo; i++) {
            System.out.println("\nPosition of pit " + (i + 1) + ": ");
            pit[i][0] = sc.nextInt();
            pit[i][1] = sc.nextInt();
        }
        game(adventureX, adventureY, goldX, goldY, pit, m, n);
    }
}
 
