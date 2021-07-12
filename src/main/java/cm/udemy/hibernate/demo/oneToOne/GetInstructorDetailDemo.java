package cm.udemy.hibernate.demo.oneToOne;

import cm.udemy.hibernate.entity.instructor.Instructor;
import cm.udemy.hibernate.entity.instructor.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDemo {
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
            String id = "678902";
            InstructorDetail instructorDetail = (InstructorDetail) session.get(InstructorDetail.class, id);

            System.out.println("InstructorDetail: " + instructorDetail);

            System.out.println("Instructor: " + instructorDetail.getInstructor());


            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done !!!");

        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
            sessionFactory.close();
        }

    }
}
