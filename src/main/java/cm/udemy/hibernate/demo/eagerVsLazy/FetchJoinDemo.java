package cm.udemy.hibernate.demo.eagerVsLazy;

import cm.udemy.hibernate.entity.instructor.Course;
import cm.udemy.hibernate.entity.instructor.Instructor;
import cm.udemy.hibernate.entity.instructor.InstructorDetail;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchJoinDemo {
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

            // ooption 2 : query with HQL



            // get the instr from db
            String theId = "1";

            Query<Instructor> query = session.createQuery("select i from Instructor i " +
                            "JOIN FETCH i.courses " +
                            " where i.id = :theInstructor",
                    Instructor.class);
            query.setParameter("theInstructor", theId);

            Instructor instructor = query.getSingleResult();

            System.out.println("love2code -> Instructor: " + instructor);

            // commit transaction
            session.getTransaction().commit();

            session.close();

            System.out.println("love2code -> Courses: " + instructor.getCourses());

            System.out.println("Done !!!");


        } finally {
            sessionFactory.close();
        }

    }
}
