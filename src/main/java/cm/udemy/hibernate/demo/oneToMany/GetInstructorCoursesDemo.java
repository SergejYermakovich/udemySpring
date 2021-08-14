package cm.udemy.hibernate.demo.oneToMany;

import cm.udemy.hibernate.entity.instructor.Course;
import cm.udemy.hibernate.entity.instructor.Instructor;
import cm.udemy.hibernate.entity.instructor.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorCoursesDemo {
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
            session.beginTransaction();

            // get the instr from db
            String theId = "1";
            Instructor instructor = (Instructor) session.get(Instructor.class, theId);

            System.out.println("Instructor: " + instructor);
            System.out.println("Courses: " + instructor.getCourses());

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done !!!");


        } finally {
            sessionFactory.close();
        }

    }
}
