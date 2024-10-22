
package ac.za.bases;


public class Umfundi {
    private int studentNumber;
    private String name;
    private String surname;

//    public Umfundi() {
//    }

    public Umfundi(int studentNumber, String name, String surname) {
        this.studentNumber = studentNumber;
        this.name = name;
        this.surname = surname;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Umfundi{" + "studentNumber=" + studentNumber + ", name=" + name + ", surname=" + surname + '}';
    }
    
    
}
