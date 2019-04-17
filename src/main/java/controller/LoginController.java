package controller;

import entity.Account;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/login")
public class LoginController  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        if (email == null || password == null){
            req.setAttribute("errorLogin","Không tìm thấy thông tin tài khoản");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createSQLQuery("Select * from account where email = :emaillogin ");
        query.setParameter("emaillogin", email);

        ((NativeQuery) query).addEntity(Account.class);

        List<Account> accounts = query.list();
        System.out.println(accounts.size());
        if (accounts.size() == 0){
            req.setAttribute("errorLogin","Không tìm thấy thông tin tài khoản");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }else{
            for (Account ac: accounts
            ) {
                System.out.println(ac.getAccountid());
                System.out.println(ac.getEmail());
                System.out.println(ac.getPassword());
                if (ac.getPassword().equals(password)){
                    System.out.println(ac.getAccountid());
                    System.out.println(ac.getEmail());
                    System.out.println(ac.getPassword());
                    HttpSession httpSession = req.getSession();
                    httpSession.setAttribute("Loggedin",ac);
                    resp.sendRedirect("/index.jsp");
                }else{
                    req.setAttribute("errorLogin","Không tìm thấy thông tin tài khoản");
                    req.getRequestDispatcher("/login.jsp").forward(req,resp);
                }
            }
        }
       session.getTransaction().commit();
    }
}
