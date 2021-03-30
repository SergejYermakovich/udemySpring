package cm.udemy.hibernate.demo;

import cm.udemy.hibernate.entity.StudentDbVersion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(StudentDbVersion.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            // start  transaction
            session.beginTransaction();

            //query all the students
            List<StudentDbVersion> students =  session.createQuery("from StudentDbVersion").list();
            // display the students
            displayTheStudents(students);

            //query the students with name Lazar
            List<StudentDbVersion> studentsWithNameLazar = session.createQuery("from StudentDbVersion s where s.firstName ='Lazar'").list();
            // display the students with name Lazar
            System.out.println("display the students with name Lazar: ");
            displayTheStudents(studentsWithNameLazar);

            //query the students with name Lazar
            List<StudentDbVersion> studentsWithEmail = session.createQuery("from StudentDbVersion s where s.email LIKE '%gmail.com'").list();
            // display the students with name Lazar
            System.out.println("display the students with email like: ");
            displayTheStudents(studentsWithEmail);


            // commit transaction
            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }

    private static void displayTheStudents(List<StudentDbVersion> students) {
        for (StudentDbVersion student : students) {
            System.out.println(student);
        }
    }

}
