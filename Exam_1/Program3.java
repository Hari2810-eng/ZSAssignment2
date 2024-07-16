import java.util.*;

public class Program3 {

    static int findGrandchildren(String[][] childFather, String grandpa) {
        int count=0;
        Map<String, Set<String>> map = new HashMap<>();
        for(int i=0; i<childFather.length; i++){
            if(!map.containsKey(childFather[i][1])){
                map.put(childFather[i][1], new HashSet<>());
                
            }
            map.get(childFather[i][1]).add(childFather[i][0]);
        }
        Set<String> fathers = map.get(grandpa);
        if(fathers == null){
            return count;
        }
        for(String father:fathers){
            if(map.get(father)!=null){
                count+=map.get(father).size();
            }
        }
        return count;
    }

    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        String[][] input = new String[][]{{"Paari", "Karikalan"},
                                        {"Udhiran", "Sendhan"},
                                        {"Muthalvar", "Paari"},
                                        {"Sendhan", "Arulmozhi"},
                                        {"Karikalan", "Sendhan"},
                                        {"Stalin", "Paari"},
                                        {"Kalangarai", "Paari"}
                                        };
    
        String grandpa = "Karikalan";
        System.out.println(findGrandchildren(input, grandpa));
                
        
    }
}
