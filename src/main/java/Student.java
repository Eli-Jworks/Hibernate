import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Student")
@Table(name = "Students")
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private int rollnr;
    private String name;
    private int marks;
    @OneToMany(mappedBy = "student")
    private List<Laptop> laptops = new ArrayList<>();

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public Student() {

    }

    public List<Laptop> getLaptop() {
        return laptops;
    }

    public void setLaptop(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    public int getRollnr() {
        return rollnr;
    }

    public void setRollnr(int rollnr) {
        this.rollnr = rollnr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollnr=" + rollnr +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}
