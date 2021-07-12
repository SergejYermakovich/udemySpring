package cm.udemy.hibernate.demo.oneToOne;

import cm.udemy.hibernate.entity.instructor.Instructor;
import cm.udemy.hibernate.entity.instructor.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            // create obj
            System.out.println("creating the object ... ");
            Instructor instructor =
                    new Instructor("Serg", "Ermakovich", "serg23@mail.ru");

            InstructorDetail instructorDetail =
                    new InstructorDetail("love2code", "football");

            // associate objects
            instructor.setInstructorDetail(instructorDetail);

            // start  transaction
            session.beginTransaction();

            // save instructor
            System.out.println("Saving the object ... " + instructor);
            session.save(instructor);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done !!!");

        } finally {
            sessionFactory.close();
        }

    }
}
