public class AdventureGameCharacter {
    static class GameCharacter {
        String characterName;

        public GameCharacter(String characterName) {
            this.characterName = characterName;
        }

        public void performAttack() {
            System.out.println(characterName + " attacks normally.");
        }
    }

    static class Warrior extends GameCharacter {
        public Warrior(String name) { super(name); }

        @Override
        public void performAttack() {
            System.out.println(characterName + " swings a mighty sword!");
        }
    }

    static class Mage extends GameCharacter {
        public Mage(String name) { super(name); }

        @Override
        public void performAttack() {
            System.out.println(characterName + " casts a fireball!");
        }
    }

    static class Archer extends GameCharacter {
        public Archer(String name) { super(name); }

        @Override
        public void performAttack() {
            System.out.println(characterName + " shoots an arrow!");
        }
    }

    public static void startBattle(GameCharacter[] characters) {
        int warriors = 0, mages = 0, archers = 0;
        
        System.out.println("--- Battle Starts ---");
        for (GameCharacter c : characters) {
            c.performAttack();
            if (c instanceof Warrior) warriors++;
            else if (c instanceof Mage) mages++;
            else if (c instanceof Archer) archers++;
        }
        
        System.out.println("--- Participants ---");
        System.out.println("Warriors: " + warriors + ", Mages: " + mages + ", Archers: " + archers);
    }

    public static void main(String[] args) {
        GameCharacter[] party = {
            new Warrior("Aragorn"),
            new Mage("Gandalf"),
            new Archer("Legolas"),
            new Warrior("Boromir")
        };
        startBattle(party);
    }
}
