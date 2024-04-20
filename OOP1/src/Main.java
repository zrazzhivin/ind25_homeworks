import student.GryffindorStudent;
import student.HogwartsStudent;
import student.SlytherinStudent;

public class Main {
    public static void main(String[] args) {

        GryffindorStudent harryPotter = new GryffindorStudent(
                "Harry Potter", 90, 90, 100, 100, 100
        );
        System.out.println(harryPotter);

        GryffindorStudent hermioneJeanGranger = new GryffindorStudent(
                "Hermione Jean Granger", 100, 100, 100, 80, 70
        );

        SlytherinStudent malfoi = new SlytherinStudent(
                "Malfoi", 80, 70, 60, 70, 80, 90, 60
        );

        harryPotter.compare(hermioneJeanGranger);
        harryPotter.baseCompare(malfoi);


    }
}