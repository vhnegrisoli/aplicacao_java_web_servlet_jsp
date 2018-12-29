/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aplicacaoweblabiii.web.controller;

import com.mycompany.aplicacaoweblabiii.db.controller.CategoryJpaController;
import com.mycompany.aplicacaoweblabiii.db.controller.RoleJpaController;
import com.mycompany.aplicacaoweblabiii.model.Category;
import com.mycompany.aplicacaoweblabiii.model.Role;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author vhnegrisoli
 */
public class ServletCategoria extends HttpServlet {

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
            out.println("<title>Servlet ServletCategoria</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletCategoria at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        String nome = request.getParameter("nome");
        String id = request.getParameter("id");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_AplicacaoWebLabIII_war_1.0-SNAPSHOTPU");
        CategoryJpaController cjc = new CategoryJpaController(emf);

        if (!id.trim().equals("null")) {
            Category category = new Category(Integer.parseInt(id));
            category.setIdCategory(Integer.parseInt(id));
            category.setDescription(nome);
            try {
                cjc.edit(category);
                response.sendRedirect("CategoriaUD.jsp");
            } catch (Exception ex) {
                Logger.getLogger(ServletRoles.class.getName()).log(Level.SEVERE, null, ex);
                response.sendRedirect("erro.jsp");
            }
        } else {
            try {
                Category category = new Category();
                category.setDescription(nome);
                cjc.create(category);
                erro = false;
            } catch (Exception e) {
                response.sendRedirect("erro.jsp");
                erro = true;
            }
            if (erro == false) {
                request.getSession().setAttribute("nome", nome);
                response.sendRedirect("CategoriaUD.jsp");
            }
        }
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
