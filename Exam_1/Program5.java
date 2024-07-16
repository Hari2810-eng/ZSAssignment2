import java.util.Scanner;

public class Program5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] mat = new int[rows][cols];

        int count = 1;
        int line, startEleI, startEleJ;

        for (line = 1; line <= rows + cols - 1; line++) {
            if (line % 2 == 1) {
                if (line <= cols) {
                    startEleI = 0;
                    startEleJ = line - 1;
                } else {
                    startEleI = line - cols;
                    startEleJ = cols - 1;
                }

                while (startEleI < rows && startEleJ >= 0) {
                    mat[startEleI][startEleJ] = count++;
                    startEleI++;
                    startEleJ--;
                }
            } else {
                if (line <= rows) {
                    startEleI = line - 1;
                    startEleJ = 0;
                } else {
                    startEleI = rows - 1;
                    startEleJ = line - rows;
                }

                while (startEleI >= 0 && startEleJ < cols) {
                    mat[startEleI][startEleJ] = count++;
                    startEleI--;
                    startEleJ++;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = cols - 1; j >= 0; j--) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
