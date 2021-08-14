package cm.udemy.hibernate.demo.oneToMany;

import cm.udemy.hibernate.entity.instructor.Course;
import cm.udemy.hibernate.entity.instructor.Instructor;
import cm.udemy.hibernate.entity.instructor.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {
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

            // create courses
            Course course1 = new Course("Air Guitar");
            Course course2 = new Course("The pinball");

            // add courses to instructor
            instructor.add(course1);
            instructor.add(course2);

            //save the courses
            session.save(course1);
            session.save(course2);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done !!!");


        } finally {
            sessionFactory.close();
        }

    }
}
