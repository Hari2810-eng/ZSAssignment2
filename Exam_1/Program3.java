public class Program3 {

    static int findGrandchildren(String[][] childFather, String grandpa) {
        int count = 0;

        String[] childrenOfGrandpa = new String[childFather.length];
        int childrenCount = 0;
        
        for (int i = 0; i < childFather.length; i++) {
            if (childFather[i][1].equals(grandpa)) {
                childrenOfGrandpa[childrenCount] = childFather[i][0];
                childrenCount++;
            }
        }
        
        for (int i = 0; i < childrenCount; i++) {
            String child = childrenOfGrandpa[i];
            
            for (int j = 0; j < childFather.length; j++) {
                if (childFather[j][1].equals(child)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // Test data
        String[][] input = new String[][]{
            {"Paari", "Karikalan"},
            {"Udhiran", "Sendhan"},
            {"Muthalvar", "Paari"},
            {"Sendhan", "Arulmozhi"},
            {"Karikalan", "Sendhan"},
            {"Stalin", "Paari"},
            {"Kalangarai", "Paari"}
        };
    
        String grandpa = "Karikalan";
        System.out.println("Number of grandchildren: " + findGrandchildren(input, grandpa));
    }
}
