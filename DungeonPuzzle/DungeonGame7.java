import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DungeonGame7 {
    private int[][] grid;
    private int m;
    private int n;
    private static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};  // Up, Right, Down, Left

    DungeonGame7(int m, int n) {
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
        queue.add(new int[]{endX, endY});
        dp[endX][endY] = 0;

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

        return dp[startX][startY] == Integer.MAX_VALUE ? -1 : dp[startX][startY];
    }

    public void printPath(int startX, int startY, int endX, int endY, int[][][] previous) {
        LinkedList<int[]> path = new LinkedList<>();
        int currentX = startX;
        int currentY = startY;

        while (currentX != endX || currentY != endY) {
            path.add(new int[]{currentX, currentY});
            int[] prev = previous[currentX][currentY];
            currentX = prev[0];
            currentY = prev[1];
        }
        path.add(new int[]{endX, endY}); 

        for (int[] p : path) {
            System.out.print("(" + (p[0] + 1) + "," + (p[1] + 1) + ") -> ");
        }
    }

    public static void game(int adventureX, int adventureY, int goldX, int goldY, int monsterX, int monsterY, int triggerX, int triggerY, int[][] pit, int m, int n) {
        DungeonGame7 dungeon = new DungeonGame7(m, n);
        adventureX -= 1;
        adventureY -= 1;
        goldX -= 1;
        goldY -= 1;
        monsterX -= 1;
        monsterY -= 1;
        triggerX -= 1;
        triggerY -= 1;

        for (int[] p : pit) {
            dungeon.grid[p[0] - 1][p[1] - 1] = Integer.MAX_VALUE;
        }

        int[][][] previous = new int[m][n][2];

        int adventureStep = dungeon.findMinSteps(adventureX, adventureY, goldX, goldY, previous);
        int monsterStep = dungeon.findMinSteps(monsterX, monsterY, goldX, goldY, new int[m][n][2]); 

        System.out.println("Adventurer steps: " + adventureStep + ", Monster steps: " + monsterStep);

        if (adventureStep == -1) {
            System.out.println("No possible solution");
        } else if (adventureStep > monsterStep) {
            int[][][] prevToTrigger = new int[m][n][2];
            int adventureTrigger = dungeon.findMinSteps(adventureX, adventureY, triggerX, triggerY, prevToTrigger);
            int monsterTrigger = dungeon.findMinSteps(monsterX, monsterY, triggerX, triggerY, new int[m][n][2]); 
            
            if(adventureTrigger == -1 || adventureTrigger > monsterTrigger){
                System.out.println("No possible solution");
            } else {          
                int[][][] prevFromTriggerToGold = new int[m][n][2];
                int triggerToGoldSteps = dungeon.findMinSteps(triggerX, triggerY, goldX, goldY, prevFromTriggerToGold);
                System.out.println("Minimum number of steps: " + (adventureTrigger + triggerToGoldSteps));
                
                dungeon.printPath(adventureX, adventureY, triggerX, triggerY, prevToTrigger);
                dungeon.printPath(triggerX, triggerY, goldX, goldY, prevFromTriggerToGold);
            }
        } else {
            System.out.println("Minimum number of steps: " + adventureStep);
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

        System.out.println("Position of monster: ");
        int monsterX = sc.nextInt();
        int monsterY = sc.nextInt();

        System.out.println("\nPosition of trigger: ");
        int triggerX = sc.nextInt();
        int triggerY = sc.nextInt();

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

        game(adventureX, adventureY, goldX, goldY, monsterX, monsterY, triggerX, triggerY, pit, m, n);
    }
}
