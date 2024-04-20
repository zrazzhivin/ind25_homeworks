package student;

public abstract class HogwartsStudent {

    protected String name;

    protected int powerOfMagic;
    protected int transgressionDistance;

    public HogwartsStudent(String name, int powerOfMagic, int transgressionDistance) {
        this.name = name;
        this.powerOfMagic = powerOfMagic;
        this.transgressionDistance = transgressionDistance;
    }

    public int getPowerOfMagic() {
        return powerOfMagic;
    }

    public int getTransgressionDistance() {
        return transgressionDistance;
    }

    public int calculateBaseAbilitiesSum() {
        return powerOfMagic + transgressionDistance;
    }

    public void baseCompare(HogwartsStudent hogwartsStudent) {
        int sum1 = calculateBaseAbilitiesSum();
        int sum2 = hogwartsStudent.calculateBaseAbilitiesSum();

        if (sum1 > sum2) {
            System.out.println(name + " > " + hogwartsStudent.name);
        } else if (sum1 < sum2) {
            System.out.println(name + " < " + hogwartsStudent.name);
        } else {
            System.out.println(name + " == " + hogwartsStudent.name);
        }
    }
}
