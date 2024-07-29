import java.util.Scanner;

public class SpiralMatrix {
    public static int[][] generateSpiralMatrix(int N) {
        int[][] matrix = new int[N][N];
        int num = 1;  
        int top = 0, bottom = N - 1, left = 0, right = N - 1;

        while (num <= N * N) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;
            
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = num++;
            }
            bottom--;
            
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = num++;
            }
            left++;
        }
        
        return matrix;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the size N of the NxN matrix: ");
        int N = scanner.nextInt();
        
        int[][] spiralMatrix = generateSpiralMatrix(N);
        
        System.out.println("Spiral Matrix:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(spiralMatrix[i][j] + "\t");
            }
            System.out.println();
        }
        
    }
}
