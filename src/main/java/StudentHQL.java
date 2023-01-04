import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Students_hql")
public class StudentHQL {
    @Id
    @SequenceGenerator(
            name = "student_hql_sequence",
            sequenceName = "student_hql_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_hql_sequence"
    )
    private int rollnr;
    private String name;
    private int marks;

    public StudentHQL(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public StudentHQL() {

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
