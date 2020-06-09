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
 * Servlet implementation class UpdateServlet
 */
@WebServlet(name = "update", urlPatterns = { "/update" })
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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

            Tasklist t = em.find(Tasklist.class,(Integer)(request.getSession().getAttribute("tasklist_taskid")));

            String tasktitle =request.getParameter("tasktitle");
            t.setTasktitle(tasktitle);

            String taskcontent =request.getParameter("taskcontent");
            t.setTaskcontent(taskcontent);

            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            t.setTaskupdated_at(currentTime);

            em.getTransaction().begin();
            em.getTransaction().commit();
            em.close();

            request.getSession().removeAttribute("tasklist_taskid");

            response.sendRedirect(request.getContextPath() + "/index");
        }
    }

}
