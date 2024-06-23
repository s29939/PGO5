import java.util.ArrayList;
import java.util.Date;

public class Student {

    private String name, surename, email, address, phoneNumber, status, indexNumber;
    private static int counter = 0;
    private Date dateOfBirth;
    private int dayOfBirth, monthOfBirth, yearOfBirth, semester;
    private String[] statusLevel = new String[]{"candidate", "student", "graduate"};
    private StudyProgramme studyProgramme;
    private ArrayList<Subject> subjectList = new ArrayList<>();

    public Student(String name, String surename, String email, String address, String phoneNumber, Date dateOfBirth) {
        setName(name);
        setSurename(surename);
        setEmail(email);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        setDateOfBirth(dateOfBirth);
        this.dayOfBirth = dateOfBirth.getDay();
        this.monthOfBirth = dateOfBirth.getMonth();
        this.yearOfBirth = dateOfBirth.getYear();
        setStatus(statusLevel[0]);
        setSemester(1);
        setIndexNumber(++counter);
        Students.addStudents(this);
    }

    public void showStudentFullInfo() {
        if (status.equals(statusLevel[0])) {
            System.out.println("Name: " + getName());
            System.out.println("Surename: " + getSurename());
            System.out.println("Email: " + getEmail());
            System.out.println("Address: " + getAddress());
            System.out.println("PhoneNumber: " + getPhoneNumber());
            System.out.println("Status: " + getStatus());
            System.out.println("IndexNumber: " + getIndexNumber());
            System.out.println("Date of Birth: " + getDateOfBirth());
        } else {
            System.out.println("Name: " + getName());
            System.out.println("Surename: " + getSurename());
            System.out.println("Email: " + getEmail());
            System.out.println("Address: " + getAddress());
            System.out.println("PhoneNumber: " + getPhoneNumber());
            System.out.println("Status: " + getStatus());
            System.out.println("IndexNumber: " + getIndexNumber());
            System.out.println("Date of Birth: " + getDateOfBirth());
            System.out.println("Study Programe: " + studyProgramme.getFieldOfStudy());
            System.out.println("Semester: " + getSemester());
        }
    }


    public double getSumOfITN() {
        double sum = 0;
        for (Subject sub : subjectList) {
            sum += sub.getAverageGrade();
        }
        return sum;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public ArrayList<Subject> getSubjectList() {
        return subjectList;
    }

    public void showStudentInlineInfo() {
        if (status.equals(statusLevel[0])) {
            System.out.println("Student: " + getName() + " | " + getSurename() + " | " + getEmail() + " | " + getAddress() + " | " + getPhoneNumber() + " | " + getStatus() + " | " + getIndexNumber() + " | " + getDateOfBirth());
        } else {
            System.out.println("Student: " + getName() + " | " + getSurename() + " | " + getEmail() + " | " + getAddress() + " | " + getPhoneNumber() + " | " + getStatus() + " | " + getIndexNumber() + " | " + getDateOfBirth() + " | " + studyProgramme.getFieldOfStudy());
        }
    }

    public void getListOfSubjects() {

    }

    public int getSubjectNumber(String subject) {
        if (subjectList != null) {
            for (int i = 0; i <= subjectList.size(); i++) {
                if (subjectList.get(i).getName().equals(subject)) {
                    return i;
                }
            }
            return -1;
        }
        return 0;
    }

    public String getStatus() {
        return status;
    }

    public String getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(int counter) {
        if (counter < 10) {
            this.indexNumber = "s0000" + counter;
        } else {
            if (counter < 100) {
                this.indexNumber = "s000" + counter;
            } else {
                if (counter < 1000) {
                    this.indexNumber = "s00" + counter;
                } else {
                    if (counter < 10000) {
                        this.indexNumber = "s0" + counter;
                    } else {
                        if (counter < 1000000) {
                            this.indexNumber = "s" + counter;
                        } else {
                            if (counter < 1000000000) {
                                this.indexNumber = "s" + counter;
                            }
                        }
                    }
                }
            }
        }
    }

    public void setStatus(String status) {
        if (status.equals("candidate") || status.equals("student") || status.equals("graduate")) {
            this.status = status;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurename() {
        return surename;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDateOfBirth() {
        return String.format("%d/%d/%d", dayOfBirth, monthOfBirth, yearOfBirth);
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int findSubjectNumber(String subject) {
        if (subjectList.size() == 0) {
            return -1;
        }
        for (int i = 0; i < subjectList.size(); i++) {
            if (subjectList.get(i).getName().equals(subject)) {
                return i;
            }
        }
        return -1;
    }

    public void addNewSubject(String subject) {
        subjectList.add(new Subject(subject));
        subjectList.get(subjectList.size() - 1).setSemestrSubject(this.semester);
//        System.out.println("Subject: "+subjectList.get(subjectList.size()-1).getName()+" Semestr "+subjectList.get(subjectList.size()-1).getSemestrSubject());
    }

    public void promoteToNextSemester() {
        double sumITN = 0;
        if (getStatus() == statusLevel[1]) {
            for (Subject subject : subjectList) {
                if ((subject.getAverageGrade() > Subject.getMinAverageGradeToPassExam()) && (subject.getSemestrSubject() == getSemester())) {
                    sumITN += subject.getAverageGrade();
                }
            }
            if (sumITN >= studyProgramme.getNumberOfPossibleITN()) {
                if (studyProgramme.getNumberOfSemestr() == getSemester()) {
                    setStatus("graduate");
                }
                if (studyProgramme.getNumberOfSemestr() > getSemester()) {
                    setSemester(getSemester() + 1);

                }

            }
        } else if (getStatus() != statusLevel[2]) {
//            System.out.println("Student has status: " + getStatus() + ". They can't be promoted");
        }
    }

    public void enrollStudent(StudyProgramme studyProgramme) {
        this.studyProgramme = studyProgramme;
        this.status = statusLevel[1];
    }


    public void addGrade(int grade, String subject) {
        int subjectNumber = findSubjectNumber(subject);
        if (subjectNumber == -1) {
            addNewSubject(subject);
            subjectList.get(subjectList.size() - 1).addGrade(grade);
        } else {
            subjectList.get(subjectNumber).addGrade(grade);
        }
    }
}
