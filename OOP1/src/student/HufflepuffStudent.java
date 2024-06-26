package student;

public class HufflepuffStudent extends HogwartsStudent {

    public HufflepuffStudent(String name, int powerOfMagic, int transgressionDistance, int hardworking, int loyal, int honest) {
        super(name, powerOfMagic, transgressionDistance);
        this.hardworking = hardworking;
        this.loyal = loyal;
        this.honest = honest;
    }

    private int hardworking;
    private int loyal;
    private int honest;

    public int getHardworking() {
        return hardworking;
    }

    public int getLoyal() {
        return loyal;
    }

    public int getHonest() {
        return honest;
    }

    @Override
    public int calculateAbilitiesSum() {
        return hardworking + loyal + honest;
    }

    @Override
    public String toString() {
        return "HufflepuffStudent{" +
                "hardworking=" + hardworking +
                ", loyal=" + loyal +
                ", honest=" + honest +
                ", name='" + name + '\'' +
                ", powerOfMagic=" + powerOfMagic +
                ", transgressionDistance=" + transgressionDistance +
                '}';
    }
}
