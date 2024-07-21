import java.util.ArrayList;
import java.util.List;

public class DiamondPrinter {

    List<String> printToList(char a) {
        List<String> diamondLines = new ArrayList<>();
        int n = a - 'A' + 1;

        for (int i = 1; i <= n; i++) {
            diamondLines.add(createDiamondLine(i, n));
        }

        for (int i = n - 1; i >= 1; i--) {
            diamondLines.add(createDiamondLine(i, n));
        }

        return diamondLines;
    }

    private String createDiamondLine(int i, int n) {
        StringBuilder line = new StringBuilder();

        for (int j = 0; j < n - i; j++) {
            line.append(' ');
        }

        line.append((char) ('A' + i - 1));

        if (i > 1) {
            for (int j = 0; j < 2 * (i - 1) - 1; j++) {
                line.append(' ');
            }
            line.append((char) ('A' + i - 1));
        }

        for (int j = 0; j < n - i; j++) {
            line.append(' ');
        }

        return line.toString();
    }

    public static void main(String[] args) {
        DiamondPrinter printer = new DiamondPrinter();
        List<String> diamond = printer.printToList('C');

        for (String line : diamond) {
            System.out.println(line);
        }
    }
}
