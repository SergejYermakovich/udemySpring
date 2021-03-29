package cm.udemy.hibernate.demo;


import cm.udemy.hibernate.entity.StudentDbVersion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
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
            studentDbVersion.setFirstName("Lazar");
            studentDbVersion.setLastName("Nkunku2");


            // start  transaction

            session.beginTransaction();

            // save student
            System.out.println("Saving the object ... ");
            session.save(studentDbVersion);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done !!!");
        } finally {
            sessionFactory.close();
        }

    }
}
