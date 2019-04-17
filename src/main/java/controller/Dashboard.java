package controller;


import entity.Feedback;
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
import java.io.IOException;


import java.util.List;

@WebServlet(urlPatterns = "/dashboard")
public class Dashboard extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = (Query) session.createSQLQuery("select  * from feedback");
        ((NativeQuery) query).addEntity(Feedback.class);
        List<Feedback> feedbacks = ((NativeQuery) query).list();
        req.setAttribute("ListFeedback", feedbacks);
        for (Feedback fe :feedbacks
                ) {
            System.out.println("Account id : " + fe.getAccountfeeadback().getAccountid());
            System.out.println(" ID Feedback : " + fe.getFeedbackid());
            System.out.println("Content : " + fe.getContent());
            System.out.println("Status" + fe.getStatus());
        }
        req.getRequestDispatcher("/daskboard.jsp").forward(req,resp);
        session.getTransaction().commit();
       // req.getRequestDispatcher("daskboard.jsp").forward(req,resp);
    }
}
