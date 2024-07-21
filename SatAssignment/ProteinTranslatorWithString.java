import java.util.*;

public class ProteinTranslatorWithString {

    List<String> translate(String rnaSequence) {
        List<String> result = new ArrayList<>();

        String[] codons = {
            "AUG", "UUU", "UUC", "UUA", "UUG", "UCU", "UCC", "UCA", "UCG",
            "UAU", "UAC", "UGU", "UGC", "UGG", "UAA", "UAG", "UGA"
        };
        String[] proteins = {
            "Methionine", "Phenylalanine", "Phenylalanine", "Leucine", "Leucine",
            "Serine", "Serine", "Serine", "Serine", "Tyrosine", "Tyrosine",
            "Cysteine", "Cysteine", "Tryptophan", "STOP", "STOP", "STOP"
        };

        String protein = "";
        for (int i = 0; i < rnaSequence.length() - 2; i += 3) {
            String codon = rnaSequence.substring(i, i + 3);
            protein = translateCodon(codon, codons, proteins);

            if (protein == null) {
                throw new IllegalArgumentException("Invalid codon: " + codon);
            }

            if ("STOP".equals(protein)) {
                break;
            }

            result.add(protein);
        }

        if (rnaSequence.length() % 3 != 0 && !"STOP".equals(protein)) {
            throw new IllegalArgumentException("Invalid codon at the end of the sequence");
        }

        return result;
    }

    private String translateCodon(String codon, String[] codons, String[] proteins) {
        for (int i = 0; i < codons.length; i++) {
            if (codons[i].equals(codon)) {
                return proteins[i];
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter RNA sequence:");
        String rnaSequence = scanner.nextLine();

        ProteinTranslator translator = new ProteinTranslator();
        try {
            List<String> proteins = translator.translate(rnaSequence);
            System.out.println("Proteins: " + proteins);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

    }
}
