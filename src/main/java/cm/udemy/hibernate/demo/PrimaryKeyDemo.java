package cm.udemy.hibernate.demo;

import cm.udemy.hibernate.entity.StudentDbVersion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;

public class PrimaryKeyDemo {

    public static void main(String[] args) {
        EasyRandomParameters parameters = new EasyRandomParameters();

        parameters.stringLengthRange(7, 7);
        parameters.collectionSizeRange(5, 5);

        EasyRandom generator = new EasyRandom(parameters);

        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(StudentDbVersion.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            // create obj
            System.out.println("creating the object ... ");
            StudentDbVersion studentDbVersion1 = generator.nextObject(StudentDbVersion.class);
            StudentDbVersion studentDbVersion2 = generator.nextObject(StudentDbVersion.class);
            StudentDbVersion studentDbVersion3 = generator.nextObject(StudentDbVersion.class);

            // start  transaction

            session.beginTransaction();

            // save student
            System.out.println("Saving the objects ... ");
            session.save(studentDbVersion1);
            session.save(studentDbVersion2);
            session.save(studentDbVersion3);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done !!!");
        } finally {
            sessionFactory.close();
        }
    }
}
