package cm.udemy.hibernate.demo.oneToOne;

import cm.udemy.hibernate.entity.instructor.Instructor;
import cm.udemy.hibernate.entity.instructor.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneDemoDelete {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            // start  transaction
            session.beginTransaction();

            // get instr
            String id = "1";
            Instructor instructor = (Instructor) session.get(Instructor.class, id);

            System.out.println("instructor: " + instructor);

            // delete
            if (instructor != null) {
                System.out.println("Deleting....");
                session.delete(instructor);
                System.out.println("Successful!!!");
            } else {
                System.out.println("Deleting error! Object does not exist");
            }


            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done !!!");

        } finally {
            sessionFactory.close();
        }

    }
}
