import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("PGO - excersis 5 - S29829 Jacek K");

        Student s = new Student("John", "Doe", "doe@wp.pl", "Warsaw, Zlota 12", "333-322-222", new Date(1980, 1, 1));
        Student s1 = new Student("John", "Doe", "doe@wp.pl", "Warsaw, Zlota 12", "333-322-222", new Date(1980, 1, 1));
        Student s2 = new Student("John", "Doe", "doe@wp.pl", "Warsaw, Zlota 12", "333-322-222", new Date(1980, 1, 1));
        //student get the indexNumber automatically assigned
        StudyProgramme it = new StudyProgramme("IT", "AAA", 1, 5);
        //7 is the number of semesters, 5 - number of possible ITN's before being allowed to be promoted to next semester

        s.enrollStudent(it);
        s1.enrollStudent(it);
        //we assign the student to the first semester by default
        s.addGrade(5, "PGO");
        s.addGrade(2, "APBD");


        //...
        //We try to promote students - this method should go through all our students and run the promoteToNextSemester() method on  each student.
        //Remember to check whether a student is not already on the last semester - then we can set student's status = "Graduate".
        //Remember to check whether the student didn't exceed the number of ITN's allowed on specific studies.
        Students.promoteAllStudents();
        //We check the current semester for each student
        Students.displayInfoAboutAllStudents();

    }
}