package student;

public class GryffindorStudent extends HogwartsStudent {

    public GryffindorStudent(String name, int powerOfMagic, int transgressionDistance, int nobility, int honor, int courage) {
        super(name, powerOfMagic, transgressionDistance);
        this.nobility = nobility;
        this.honor = honor;
        this.courage = courage;
    }

    private int nobility;
    private int honor;
    private int courage;

    public int getNobility() {
        return nobility;
    }

    public int getHonor() {
        return honor;
    }

    public int getCourage() {
        return courage;
    }

    @Override
    public String toString() {
        return "GryffindorStudent{" +
                "nobility=" + nobility +
                ", honor=" + honor +
                ", courage=" + courage +
                ", name='" + name + '\'' +
                ", powerOfMagic=" + powerOfMagic +
                ", transgressionDistance=" + transgressionDistance +
                '}';
    }

    @Override
    public int calculateAbilitiesSum() {
        return nobility + honor + courage;
    }
}
