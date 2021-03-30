package cm.udemy.hibernate.demo;

import cm.udemy.hibernate.entity.StudentDbVersion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(StudentDbVersion.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            String studentId = "1";

            // save student
            System.out.println("updated student with id: " + studentId);

            // start  transaction
            session.beginTransaction();

            System.out.println("getting student with id: " + studentId);
            StudentDbVersion studentDbVersion = (StudentDbVersion) session.get(StudentDbVersion.class, studentId);
            System.out.println("Updating the student....");
            studentDbVersion.setLastName("newLastname");

            // commit transaction
            session.getTransaction().commit();

            // new code
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            // update email for all students
            System.out.println("updating of emails");
            session.createQuery("update StudentDbVersion set email='test@gmail.com'").executeUpdate();

            session.getTransaction().commit();

            System.out.println("Done !!!");
        } finally {
            sessionFactory.close();
        }
    }
}
