/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aplicacaoweblabiii.web.controller;

import com.mycompany.aplicacaoweblabiii.db.controller.FormaPgtJpaController;
import com.mycompany.aplicacaoweblabiii.db.controller.PlanoJpaController;
import com.mycompany.aplicacaoweblabiii.model.FormaPgt;
import com.mycompany.aplicacaoweblabiii.model.Plano;
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
public class ServletPagamento extends HttpServlet {

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
            out.println("<title>Servlet ServletPagamento</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletPagamento at " + request.getContextPath() + "</h1>");
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
        FormaPgtJpaController fpjc = new FormaPgtJpaController(emf);
        
        if (!id.trim().equals("null")) {
            FormaPgt pagamento = new FormaPgt(Integer.parseInt(id));
            pagamento.setIdFormaPgt(Integer.parseInt(id));
            pagamento.setDescricao(nome);
            try {
                fpjc.edit(pagamento);
                response.sendRedirect("PagamentoUD.jsp");
            } catch (Exception ex) {
                response.sendRedirect("erro.jsp");
            }
        } else {
            try {
                FormaPgt pagamento = new FormaPgt();
                pagamento.setDescricao(nome);
                fpjc.create(pagamento);
                erro = false;
            } catch (Exception e) {
                response.sendRedirect("erro.jsp");
                erro = true;
            }
            if (erro == false) {
                request.getSession().setAttribute("nome", nome);
                response.sendRedirect("PagamentoUD.jsp");
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
