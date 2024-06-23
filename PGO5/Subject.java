public class Subject {

    private String name, shortCode, description;
    private int maxGrade = 19;
    private int[] grade = new int[maxGrade];
    private int countGrade = 0;
    private int semestrSubject;

    public static double getMinAverageGradeToPassExam() {
        return minAverageGradeToPassExam;
    }

    public static void setMinAverageGradeToPassExam(double minAverageGradeToPassExam) {
        Subject.minAverageGradeToPassExam = minAverageGradeToPassExam;
    }

    private static double minAverageGradeToPassExam = 1;

    public Subject(String name, String shortCode, String description) {
        setName(name);
        setShortCode(shortCode);
        setDescription(description);
    }

    public Subject(String name, String shortCode) {
        setName(name);
        setShortCode(shortCode);
    }

    public Subject(String name) {
        setName(name);
    }

    public int getSemestrSubject() {
        return semestrSubject;
    }

    public void setSemestrSubject(int semestrSubject) {
        this.semestrSubject = semestrSubject;
    }

    public void addGrade(int grade) {
        if (countGrade <= maxGrade) {
            this.grade[countGrade++] = grade;
        }
    }

    public double getAverageGrade() {
        double sum = 0;
        for (int i = 0; i < countGrade; i++) {
            sum += grade[i];
        }
        return sum / countGrade;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
