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
import java.sql.DatabaseMetaData;
import java.sql.Date;

@WebServlet(urlPatterns = "/userinformation")
public class UserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String username = req.getParameter("username");
        String fullname = req.getParameter("fullname");
        String address = req.getParameter("address");
        String dob = req.getParameter("dob");
        String phone = req.getParameter("phone");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session =  sessionFactory.openSession();
        session.beginTransaction();
        Account account = new Account();
        Userinformation user = new Userinformation();

        account.setEmail(email);
        account.setPassword(password);

        user.setUsername(username);
        user.setFullname(fullname);
        user.setAddress(address);
        user.setDob(Date.valueOf(dob));
        user.setPhone(phone);
        user.setAccount(account);

        session.save(account);
        session.save(user);


        session.getTransaction().commit();

        resp.getWriter().println("Ok");
    }
}
