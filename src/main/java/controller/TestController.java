package controller;

import entity.Account;
import entity.Userinformation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(urlPatterns = "/user")
public class TestController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session =  sessionFactory.openSession();
        session.beginTransaction();
        Account account = new Account();
        account.setEmail("Tuan4@gmail.com");
        account.setPassword("123456");
        Userinformation user = new Userinformation();
        user.setUsername("Vien");
        user.setFullname("Levien");
        user.setAddress("NB");
        user.setDob(Date.valueOf("2019-02-03"));
        user.setPhone("123456789");
        user.setAccount(account);
        session.save(account);
        session.save(user);
        //user.setAccount(account);


       // session.persist(user);
        session.getTransaction().commit();
    }
}
