package cm.udemy.hibernate.demo;

import cm.udemy.hibernate.entity.StudentDbVersion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteStudentDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(StudentDbVersion.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            // start  transaction
            session.beginTransaction();

            String studentId = "11";
            StudentDbVersion student = (StudentDbVersion) session.get(StudentDbVersion.class, studentId);
            System.out.println("Deleting the student: " + student);
            // delete the student
            session.delete(student);

            // commit transaction
            session.getTransaction().commit();


            System.out.println("Done !!!");
        } finally {
            sessionFactory.close();
        }
    }
}
