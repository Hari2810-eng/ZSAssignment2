
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DungeonGame {
	private int[][] grid;
	private int m;
	private int n;
  private static final int[][] DIRECTIONS = {{-1,0}, {0,1}, {1,0}, {0,-1} };

	DungeonGame(int m, int n){
		grid = new int[m][n];
		this.m = m;
		 this.n = n;
	}
	

    public int findMinSteps(int adventureX, int adventureY, int goldX, int goldY) {
        if (adventureX == goldX && adventureY == goldY) {
            return 0;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{goldX, goldY});
        dp[goldX][goldY] = 0;
        while (!queue.isEmpty()) {
            int[] current= queue.poll();
            int currentX= current[0];
            int currentY= current[1];
            int currentSteps= dp[currentX][currentY];

            for (int[] direction : DIRECTIONS) {
                int newX= currentX+direction[0];
                int newY= currentY+direction[1];
                if (newX>= 0 && newY >= 0 && newX < m && newY < n && dp[newX][newY] == Integer.MAX_VALUE) {
                    dp[newX][newY] =currentSteps + 1; 
                    queue.add(new int[]{newX, newY});  
                }
            }
        }
        return dp[adventureX][adventureY] == Integer.MAX_VALUE ? -1 : dp[adventureX][adventureY];
    }
	public static void game(int adventureX, int adventureY, int goldX, int goldY, int m, int n){
        DungeonGame dungeon = new DungeonGame(m, n);

       
        adventureX -= 1;
        adventureY -= 1;
        goldX -= 1;
        goldY -= 1;

        int result = dungeon.findMinSteps(adventureX, adventureY, goldX, goldY);
        if (result == -1) {
            System.out.println("No possible solution");
        } else {
            System.out.println("Minimum number of steps: " + result);
        
        }
    }
	public static void main(String[] args) {
		System.out.print("Dimensions of Dungeon (mx n) : ");
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		System.out.println("\nPosition of adventurer: ");
		int adventureX = sc.nextInt();
		int adventureY = sc.nextInt();

        System.out.println("\nPosition of gold: ");
		int goldX = sc.nextInt();
		int goldY = sc.nextInt();
        
        System.out.println("Position of monster: ");
        int monsterX = sc.nextInt();
        int monsterY = sc.nextInt();

		game(adventureX, adventureY, goldX, goldY, m, n);
	}
}

