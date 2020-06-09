package controllers;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Tasklist;
import utils.DButil;

/**
 * Servlet implementation class DestroyServlet
 */
@WebServlet(name = "destroy", urlPatterns = { "/destroy" })
public class DestroyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DestroyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = (String)request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DButil.createEntityManager();

            Tasklist t = em.find(Tasklist.class, (Integer)(request.getSession().getAttribute("tasklist_taskid")));

            em.getTransaction().begin();
            em.remove(t);
            em.getTransaction().commit();
            em.close();

            request.getSession().removeAttribute("tasklist_taskid");

            response.sendRedirect(request.getContextPath() + "/index");
        }
    }
}