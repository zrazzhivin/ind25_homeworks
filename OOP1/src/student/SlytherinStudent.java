package student;

public class SlytherinStudent extends HogwartsStudent {

    public SlytherinStudent(String name, int powerOfMagic, int transgressionDistance, int cunning, int determination, int ambition, int resourcefulness, int lustForPower) {
        super(name, powerOfMagic, transgressionDistance);
        this.cunning = cunning;
        this.determination = determination;
        this.ambition = ambition;
        this.resourcefulness = resourcefulness;
        this.lustForPower = lustForPower;
    }

    private int cunning;
    private int determination;
    private int ambition;
    private int resourcefulness;
    private int lustForPower;

    public int getCunning() {
        return cunning;
    }

    public int getDetermination() {
        return determination;
    }

    public int getAmbition() {
        return ambition;
    }

    public int getResourcefulness() {
        return resourcefulness;
    }

    public int getLustForPower() {
        return lustForPower;
    }

    @Override
    public int calculateAbilitiesSum() {
        return cunning + determination + ambition + resourcefulness + lustForPower;
    }

    @Override
    public String toString() {
        return "SlytherinStudent{" +
                "cunning=" + cunning +
                ", determination=" + determination +
                ", ambition=" + ambition +
                ", resourcefulness=" + resourcefulness +
                ", lustForPower=" + lustForPower +
                ", name='" + name + '\'' +
                ", powerOfMagic=" + powerOfMagic +
                ", transgressionDistance=" + transgressionDistance +
                '}';
    }
}
