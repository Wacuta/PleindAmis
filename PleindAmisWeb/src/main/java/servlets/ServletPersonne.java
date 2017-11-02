package servlets;

import ejbs.Facade;
import entities.Personne;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("ServletPersonne")
public class ServletPersonne extends HttpServlet {
    @EJB
    Facade facade;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if(action == null || action.equals("")){
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
        } else {
            if(action.equals("connexion")) {
                String login = request.getParameter("login");
                String pass = request.getParameter("pass");
                Personne user = facade.connectPersonne(login, pass);

                if(user != null){
                    request.getSession().setAttribute("user", user);
                    request.getSession().setAttribute("listUser", facade.getNonAmis(user.getLoginPers()));
                    request.getRequestDispatcher("/WEB-INF/amis.jsp").forward(request,response);
                } else {
                    request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
                }


            }
            if(action.equals("inscription")){
                String login = request.getParameter("login");
                String nom = request.getParameter("nom");
                String pass = request.getParameter("pass");
                Personne user = facade.createPersonne(login, pass, nom);

                request.getSession().setAttribute("user", user);
                request.getSession().setAttribute("listUser", facade.getNonAmis(user.getLoginPers()));
                request.getRequestDispatcher("/WEB-INF/amis.jsp").forward(request,response);
            }
            /**
             if(action.equals("addAmi")){
             String loginAmi = request.getParameter("loginAmi");
             facade.addAmi(user.getLoginPers(), loginAmi);

             request.getRequestDispatcher("/WEB-INF/amis.jsp").forward(request,response);
             }
             *//
             if(action.equals("mmAmi")){
                 String loginAmi = request.getParameter("loginAmi");
                 String message = request.getParameter("message");

                 facade.ecrireMessageMur(user.getLoginPers(), loginAmi, message);
                 request.getRequestDispatcher("/WEB-INF/amis.jsp").forward(request,response);
             }

        }

    }
}
