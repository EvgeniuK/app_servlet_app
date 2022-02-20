package servlet;

import entities.Car;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


import static Config.HibernateConfiguration.sessionFactory;

@WebServlet("/getCarId")
public class getCarId extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Car car = session.createQuery("from Car where id = :id", Car.class).setParameter("id", id).getSingleResult();

        transaction.commit();
        session.close();
    }
}
