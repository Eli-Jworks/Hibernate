import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {
    public static void insertEmployee(Session session, Transaction transaction) {
        FullName fullName = new FullName("Ron",null, "Zach");
        Employee employee = new Employee(fullName, "Software Developer", 21);

        session.save(employee);
        transaction.commit();
    }

    public static void fetchData(Session session) {
        Query query = session.createQuery("from Employee");
        List<Employee> employees = query.list();
        for (Employee employee: employees)
            System.out.println(employee);
    }

    public static void insertStudentLaptop(Session session, Transaction transaction) {
        Student student = new Student("Eli Kakiashvili", 100);
        Student student1 = new Student("Liel Biniasshvili", 200);

        Laptop dell = new Laptop("Dell", student);
        Laptop mac = new Laptop("Mac", student);
        Laptop hp = new Laptop("HP", student1);

        student.getLaptop().add(dell);
        student.getLaptop().add(mac);
        student1.getLaptop().add(hp);

        session.save(student);
        session.save(student1);
        session.save(dell);
        session.save(mac);
        session.save(hp);

        transaction.commit();
    }

    public static void fetchStudent(Session session) {
        Query query = session.createQuery("from Student");
        List<Student> students = query.list();
        for (Student student: students)
            System.out.println(student);
    }

    public static void hqlExcercise(Session session, Transaction transaction) {

        Random random = new Random();
        for (int i=1;i<50;i++) {
            StudentHQL student = new StudentHQL("Student "+i, random.nextInt(100));
            session.save(student);
        }
        transaction.commit();
    }

    public static void fetchStudentsHQL(Session session) {
        Query query = session.createQuery("from StudentHQL where marks > 80 and marks < 90"); // entity name, not table.
                                                                                                // use attributes like marks, rollno,
        List<StudentHQL> students = query.list();
        for (StudentHQL studentHQL: students) {
            System.out.println(studentHQL);
        }

        Query query1 = session.createQuery("from StudentHQL where rollnr = 46");
        StudentHQL studentHQL = (StudentHQL) query1.uniqueResult(); // unique returns an Object --> cast to StudentHQL
        System.out.println(studentHQL);

        Query query2 = session.createQuery("select rollnr, marks from StudentHQL s where s.marks > 60");
        List<Object[]> objects = (List<Object[]>)query2.list(); // object array bc columns type can change, each column = index
        for (Object[] objects1 : objects)
            System.out.println(objects1[0] + " " + objects1[1]); // only 2 columns
    }

    public static void main(String[] args){
        Configuration configuration = new Configuration().configure()
//                .addAnnotatedClass(Employee.class);
//                .addAnnotatedClass(Student.class)
//                .addAnnotatedClass(Laptop.class);
                .addAnnotatedClass(StudentHQL.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

//        insertEmployee(session, transaction);
//        fetchData(session);

//        insertStudentLaptop(session, transaction);
//        fetchStudent(session);

        hqlExcercise(session, transaction);
        fetchStudentsHQL(session);
    }


}
