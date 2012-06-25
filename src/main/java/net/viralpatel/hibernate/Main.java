package net.viralpatel.hibernate;

import fr.prunetwork.place.pojo.Author;
import fr.prunetwork.place.pojo.Comment;
import fr.prunetwork.place.pojo.Place;
import fr.prunetwork.place.pojo.PlaceCategory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;


public class Main {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        Author jp = new Author("Jean-Pierre");
        session.save(jp);

        PlaceCategory cinema = new PlaceCategory("Cinema");
        session.save(cinema);

        Comment comment1 = new Comment("Il est super");
        session.saveOrUpdate(comment1);

        Comment comment2 = new Comment("Il est super");
        session.saveOrUpdate(comment2);

        Comment comment3 = new Comment("Il est super bien");
        session.saveOrUpdate(comment3);

        Place place = new Place("Pathé Plan de Campagne", jp, cinema);
        session.saveOrUpdate(place);

        place.addComment(comment1);
        place.addComment(comment2);
        place.addComment(comment3);
        session.saveOrUpdate(place);


        session.getTransaction().commit();

        session.close();


//        // Write
//        System.out.println("******* WRITE *******");
//        Employee empl = new Employee("Jack", "Bauer", new Date(System.currentTimeMillis()), "911");
//        empl = save(empl);
//        empl = read(empl.getId());
//        System.out.printf("%d %s %s \n", empl.getId(), empl.getFirstname(), empl.getLastname());
//
//        // Read
//        System.out.println("******* READ *******");
//        List employees = list();
//        System.out.println("Total Employees: " + employees.size());
//
//        // Update
//        System.out.println("******* UPDATE *******");
//        Employee empl2 = read(1l); // read employee with id 1
//        System.out.println("Name Before Update:" + empl2.getFirstname());
//        empl2.setFirstname("James");
//        update(empl2);    // save the updated employee details
//
//        empl2 = read(1l); // read again employee with id 1
//        System.out.println("Name Aftere Update:" + empl2.getFirstname());
//
//        // Read
//        System.out.println("******* READ *******");
//        List employees2 = list();
//        System.out.println("Total Employees: " + employees2.size());
//
//
//        // Delete
//        System.out.println("******* DELETE *******");
//        delete(empl);
//        Employee empl3 = read(empl.getId());
//        System.out.println("Object:" + empl3);
    }


    private static List list() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        List employees = session.createQuery("from Employee").list();
        session.close();
        return employees;
    }

    private static Employee read(Long id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        Employee employee = (Employee) session.get(Employee.class, id);
        session.close();
        return employee;
    }

    private static Employee save(Employee employee) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        Long id = (Long) session.save(employee);
        //employee.setId(id);

        session.getTransaction().commit();

        session.close();

        return employee;
    }

    private static Employee update(Employee employee) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        session.merge(employee);

        session.getTransaction().commit();

        session.close();
        return employee;

    }

    private static void delete(Employee employee) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        session.delete(employee);

        session.getTransaction().commit();

        session.close();
    }

}
