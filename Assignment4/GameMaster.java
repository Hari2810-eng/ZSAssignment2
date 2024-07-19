class Character {
    private String characterClass;
    private int level;
    private int hitPoints;

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public int getLevel() {
        return level;
    }

    public int getHitPoints() {
        return hitPoints;
    }
}

class Destination {
    private String name;
    private int inhabitants;

    public void setName(String name) {
        this.name = name;
    }

    public void setInhabitants(int inhabitants) {
        this.inhabitants = inhabitants;
    }

    public String getName() {
        return name;
    }

    public int getInhabitants() {
        return inhabitants;
    }
}

enum TravelMethod {
    WALKING,
    HORSEBACK
}

public class GameMaster {

    public String describe(Character character) {
        String characterClass = character.getCharacterClass();
        int level = character.getLevel();
        int hitPoints = character.getHitPoints();
        return String.format("You're a level %d %s with %d hit points.", level, characterClass, hitPoints);
    }

    public String describe(Destination destination) {
        String name = destination.getName();
        int inhabitants = destination.getInhabitants();
        return String.format("You've arrived at %s, which has %d inhabitants.", name, inhabitants);
    }

    public String describe(TravelMethod travelMethod) {
        switch (travelMethod) {
            case WALKING:
                return "You're traveling to your destination by walking.";
            case HORSEBACK:
                return "You're traveling to your destination on horseback.";
            default:
                throw new IllegalArgumentException("Unknown travel method");
        }
    }

    public String describe(Character character, Destination destination, TravelMethod travelMethod) {
        String characterDescription = describe(character);
        String travelDescription = describe(travelMethod);
        String destinationDescription = describe(destination);
        return String.format("%s %s %s", characterDescription, travelDescription, destinationDescription);
    }

    public String describe(Character character, Destination destination) {
        return describe(character, destination, TravelMethod.WALKING);
    }

    public static void main(String[] args) {
        Character character = new Character();
        character.setCharacterClass("Wizard");
        character.setLevel(4);
        character.setHitPoints(28);

        Destination destination = new Destination();
        destination.setName("Muros");
        destination.setInhabitants(732);

        GameMaster gameMaster = new GameMaster();

        System.out.println(gameMaster.describe(character)); 
        System.out.println(gameMaster.describe(destination));
        System.out.println(gameMaster.describe(TravelMethod.HORSEBACK));
        System.out.println(gameMaster.describe(character, destination, TravelMethod.HORSEBACK));
        System.out.println(gameMaster.describe(character, destination)); 
    }
}
