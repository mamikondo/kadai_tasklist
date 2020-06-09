package controllers;

import java.io.IOException;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Tasklist;
import utils.DButil;

/**
 * Servlet implementation class CreateServlet
 */
@WebServlet(name = "create", urlPatterns = { "/create" })
public class CreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = (String)request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())){
            EntityManager em = DButil.createEntityManager();

            Tasklist t = new Tasklist();

            String tasktitle =request.getParameter("tasktitle");
            t.setTasktitle(tasktitle);

            String taskcontent =request.getParameter("taskcontent");
            t.setTaskcontent(taskcontent);

            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            t.setTaskcreated_at(currentTime);
            t.setTaskupdated_at(currentTime);

            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
            em.close();

            response.sendRedirect(request.getContextPath() + "/index");
        }
    }

}
