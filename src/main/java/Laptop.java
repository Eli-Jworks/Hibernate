import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Laptops")
public class Laptop {
    @Id
    @SequenceGenerator(
            name = "laptop_sequence",
            sequenceName = "laptop_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "laptop_sequence"
    )
    private int lid;
    private String lname;
    @ManyToOne
    private Student student;

    public Laptop(String lname, Student student) {
        this.lname = lname;
        this.student = student;
    }

    public Laptop() {

    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lname='" + lname + '\'' +
                '}';
    }
}
