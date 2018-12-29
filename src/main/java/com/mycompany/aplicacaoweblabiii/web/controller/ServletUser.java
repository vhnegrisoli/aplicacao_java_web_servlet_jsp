/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aplicacaoweblabiii.web.controller;

import com.mycompany.aplicacaoweblabiii.db.controller.RoleJpaController;
import com.mycompany.aplicacaoweblabiii.db.controller.UserJpaController;
import com.mycompany.aplicacaoweblabiii.model.Role;
import com.mycompany.aplicacaoweblabiii.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrador
 */
public class ServletUser extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletUser</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletUser at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect("confirma.jsp");

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean erro;
        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String nomeUsuario = request.getParameter("nomeUsuario");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String funcao = request.getParameter("funcao");

        int pk = getPk(funcao);

        Role role = new Role(pk);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_AplicacaoWebLabIII_war_1.0-SNAPSHOTPU");
        UserJpaController rjc = new UserJpaController(emf);

        if (!id.trim().equals("null")) {
            User userUpdate = new User(Integer.parseInt(id));
            userUpdate.setIdUser(Integer.parseInt(id));
            userUpdate.setName(nome);
            userUpdate.setUsername(nomeUsuario);
            userUpdate.setEmail(email);
            userUpdate.setPassword(senha);
            userUpdate.setIdRole(role);
            try {
                rjc.edit(userUpdate);
                response.sendRedirect("UsersUD.jsp");
            } catch (Exception ex) {
                Logger.getLogger(ServletRoles.class.getName()).log(Level.SEVERE, null, ex);
                response.sendRedirect("erro.jsp");
            }
        } else {
            try {
                /* Criando conexão com o banco e objeto Role */
                User user = new User();
                user.setName(nome);
                user.setUsername(nomeUsuario);
                user.setEmail(email);
                user.setPassword(senha);
                user.setIdRole(role);
                rjc.create(user);
                erro = false;
            } catch (Exception e) {
                response.sendRedirect("erro.jsp");
                erro = true;
            }
            if (erro == false) {
                request.getSession().setAttribute("nome", nome);
                request.getSession().setAttribute("nomeUsuario", nomeUsuario);
                request.getSession().setAttribute("email", email);
                request.getSession().setAttribute("senha", senha);
                request.getSession().setAttribute("id_role", role.getIdRole());
                response.sendRedirect("UsersUD.jsp");
            }

        }
    }

    public int getPk(String descricao) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_AplicacaoWebLabIII_war_1.0-SNAPSHOTPU");
        RoleJpaController rjc = new RoleJpaController(emf);
        List<Role> roles = rjc.findRoleEntities();
        for (int i = 0; i < roles.size(); i++) {
            if (roles.get(i).getDescription().equals(descricao)) {
                return roles.get(i).getIdRole();
            }
        }
        return 0;
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
