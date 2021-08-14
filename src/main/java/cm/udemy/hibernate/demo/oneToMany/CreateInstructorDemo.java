package cm.udemy.hibernate.demo.oneToMany;


import cm.udemy.hibernate.entity.instructor.Course;
import cm.udemy.hibernate.entity.instructor.Instructor;
import cm.udemy.hibernate.entity.instructor.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            // start  transaction


            System.out.println("creating the object ... ");
            Instructor instructor =
                    new Instructor("Susan", "Ermakovich", "susan@mail.ru");
            InstructorDetail instructorDetail =
                    new InstructorDetail("howToCook", "video");

            // associate objects
            instructor.setInstructorDetail(instructorDetail);

            // start  transaction
            session.beginTransaction();

            //

            // save instructor
            System.out.println("Saving the object ... " + instructor);
            session.save(instructor);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done !!!");


        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
