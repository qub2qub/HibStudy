/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.den.jh.associations;

import by.den.jh.associations.many2many.Course;
import by.den.jh.associations.many2many.Student;

import java.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author mkonda
 */
public class ManyToManyTest {

    private SessionFactory factory = null;

    private void init() {
        Configuration config = new Configuration().configure("associations/many2many/hibernate.cfg.xml");
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        factory = config.buildSessionFactory(registry);
    }

    private void persist() {
        Session session = factory.getCurrentSession();
        
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
//            List<Course> course = createCoursesAndStudents();
//            for (Course course1 : course) {
//                session.save(course1);
//            }

            Student studentA = new Student("Ivan");
            Student studentB = new Student("Maria");
            Set<Student> students = new HashSet<Student>();
            students.add(studentA);
            students.add(studentB);

            Student sa = new Student("Mike Meyer");
            Student sb = new Student("M Kay");
            Set<Student> ss = new HashSet<Student>();
            ss.add(sa);
            ss.add(sb);

//            session.save(sa);
//            session.save(sb);
//            session.save(studentA);
//            session.save(studentB);

            Course c1 = new Course("Fairy tale");
            c1.setStudents(students);
            Course c2 = new Course("Russian Names");
            c2.setStudents(students);
            Course c3 = new Course("Art of Living");
            c3.setStudents(ss);

            session.save(c1);
            session.save(c2);
            session.save(c3);

            tx.commit();
        } catch (HibernateException he) {
            if(tx!=null)
                tx.rollback();
            throw he;
        } finally{
            if (session.isOpen()) {
                session.close();
            }
        }
        System.out.println("Done");
    }

    private List<Course> createCoursesAndStudents() {
        Student studentA = new Student("Ivan");
        Student studentB = new Student("Maria");
        Set<Student> students = new HashSet<Student>();
        students.add(studentA);
        students.add(studentB);

        Student sa = new Student("Mike Meyer");
        Student sb = new Student("M Kay");
        Set<Student> ss = new HashSet<Student>();
        ss.add(studentA);
        ss.add(studentB);


        Course c1 = new Course("Fairy tale");
        c1.setStudents(students);
        Course c2 = new Course("Russian Names");
        c2.setStudents(students);
        Course c3 = new Course("Art of Living");
        c3.setStudents(ss);
        List<Course> list = new ArrayList<>(3);
        list.add(c1);
        list.add(c2);
        list.add(c3);
        return list;
    }

    public static void main(String[] args) {
        ManyToManyTest p = new ManyToManyTest();
        p.init();
        p.persist();
    }
}
