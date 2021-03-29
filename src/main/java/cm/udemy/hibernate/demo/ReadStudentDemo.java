package cm.udemy.hibernate.demo;

import cm.udemy.hibernate.entity.StudentDbVersion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;

public class ReadStudentDemo {

    public static void main(String[] args) {


        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(StudentDbVersion.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            // create obj
            System.out.println("creating the object ... ");
            StudentDbVersion studentDbVersion = new StudentDbVersion();

            studentDbVersion.setEmail("sergu9848@gmail.com");
            studentDbVersion.setFirstName("segre");
            studentDbVersion.setLastName("erasakotich");

            // start  transaction

            session.beginTransaction();

            // save student
            System.out.println("Saving the objects ... ");
            session.save(studentDbVersion);

            // commit transaction
            session.getTransaction().commit();
            System.out.println("saved student. With id: " + studentDbVersion.getId());

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();


            System.out.println("Get id: " + studentDbVersion.getId());
            StudentDbVersion student = (StudentDbVersion) session.get(StudentDbVersion.class, studentDbVersion.getId());
            System.out.println("Get complete: " + student);

            session.getTransaction().commit();

            System.out.println("Done !!!");
        } finally {
            sessionFactory.close();
        }
    }
}
