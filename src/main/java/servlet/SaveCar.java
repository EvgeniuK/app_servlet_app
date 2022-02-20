package servlet;

import Config.HibernateConfiguration;
import entities.Brand;
import entities.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/SaveCar")
public class SaveCar extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String number = req.getParameter("239-3");
        SessionFactory sessionFactory = HibernateConfiguration.sessionFactory;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Car car1 = new Car(323_2, Brand.HONDA, 2010, true);
        Car car2 = new Car(458_1, Brand.AUDI, 2020, false);
        Car car3 = new Car(222_3, Brand.VOLVO, 2022, true);
        Car car4 = new Car(222_3, Brand.LADA, 2018, true);

        session.save(car1);
        session.save(car2);
        session.save(car3);
        session.save(car4);
        transaction.commit();
        session.close();
    }
}
