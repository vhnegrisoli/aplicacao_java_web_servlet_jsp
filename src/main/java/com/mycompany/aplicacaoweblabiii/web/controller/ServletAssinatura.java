/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aplicacaoweblabiii.web.controller;

import com.mycompany.aplicacaoweblabiii.db.controller.AssinaturaJpaController;
import com.mycompany.aplicacaoweblabiii.db.controller.FormaPgtJpaController;
import com.mycompany.aplicacaoweblabiii.db.controller.PlanoJpaController;
import com.mycompany.aplicacaoweblabiii.db.controller.UserJpaController;
import com.mycompany.aplicacaoweblabiii.model.Assinatura;
import com.mycompany.aplicacaoweblabiii.model.FormaPgt;
import com.mycompany.aplicacaoweblabiii.model.Plano;
import com.mycompany.aplicacaoweblabiii.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.String.format;
import static java.text.MessageFormat.format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.beans.binding.Bindings.format;
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
public class ServletAssinatura extends HttpServlet {

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
            out.println("<title>Servlet ServletAssinatura</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletAssinatura at " + request.getContextPath() + "</h1>");
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
        String plano = request.getParameter("plano");
        String desconto = request.getParameter("desconto");
        String dataInicial = request.getParameter("dataInicial");
        String dataFinal = request.getParameter("dataFinal");
        String formaPagamento = request.getParameter("formaPagamento");
        String status = request.getParameter("formaPagamento");
        String usuario = request.getParameter("usuario");
        String id = request.getParameter("id");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_AplicacaoWebLabIII_war_1.0-SNAPSHOTPU");
        AssinaturaJpaController ajc = new AssinaturaJpaController(emf);

        if (!id.trim().equals("null")) {
            Assinatura assinatura = new Assinatura(Integer.parseInt(id));
            try {
                String pattern = "yyyy-MM-dd";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                Date dataI = simpleDateFormat.parse(dataInicial);
                Date dataF = simpleDateFormat.parse(dataFinal);

                assinatura.setDataFinal(dataF);
                assinatura.setDataInicial(dataI);
                assinatura.setDesconto(Integer.parseInt(desconto));
                assinatura.setStatus(status);

                User user = new User(pkUser(usuario));
                Plano plano1 = new Plano(pkPlano(plano));
                FormaPgt formaP = new FormaPgt(pkPagamento(formaPagamento));

                assinatura.setIdUser(user);
                assinatura.setIdFormaPgt(formaP);
                assinatura.setIdPlano(plano1);

                ajc.edit(assinatura);
                emf.close();
                response.sendRedirect("AssinaturaUD.jsp");
            } catch (Exception ex) {
                Logger.getLogger(ServletRoles.class.getName()).log(Level.SEVERE, null, ex);
                response.sendRedirect("erro.jsp");
            }
        } else {
            try {
                /* Criando conexão com o banco e objeto Role */
                Assinatura assinatura = new Assinatura();

                String pattern = "yyyy-MM-dd";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                Date dataI = simpleDateFormat.parse(dataInicial);
                Date dataF = simpleDateFormat.parse(dataFinal);

                assinatura.setDataFinal(dataF);
                assinatura.setDataInicial(dataI);
                assinatura.setDesconto(Integer.parseInt(desconto));
                assinatura.setStatus(status);

                User user = new User(pkUser(usuario));
                Plano plano1 = new Plano(pkPlano(plano));
                FormaPgt formaP = new FormaPgt(pkPagamento(formaPagamento));

                assinatura.setIdUser(user);
                assinatura.setIdFormaPgt(formaP);
                assinatura.setIdPlano(plano1);

                ajc.create(assinatura);
                erro = false;
            } catch (Exception e) {
                response.sendRedirect("erro.jsp");
                erro = true;
            }
            if (erro == false) {
                response.sendRedirect("AssinaturaUD.jsp");
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

    public int pkUser(String usuario) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_AplicacaoWebLabIII_war_1.0-SNAPSHOTPU");
        UserJpaController ujc = new UserJpaController(emf);
        List<User> users = ujc.findUserEntities();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(usuario)) {
                return users.get(i).getIdUser();
            }
        }
        return 0;
    }

    public int pkPagamento(String pagamento) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_AplicacaoWebLabIII_war_1.0-SNAPSHOTPU");
        FormaPgtJpaController fpjc = new FormaPgtJpaController(emf);
        List<FormaPgt> pagamentos = fpjc.findFormaPgtEntities();
        for (int i = 0; i < pagamentos.size(); i++) {
            if (pagamentos.get(i).getDescricao().equals(pagamento)) {
                return pagamentos.get(i).getIdFormaPgt();
            }
        }
        return 0;
    }

    public int pkPlano(String plano) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_AplicacaoWebLabIII_war_1.0-SNAPSHOTPU");
        PlanoJpaController pjc = new PlanoJpaController(emf);
        List<Plano> planos = pjc.findPlanoEntities();
        for (int i = 0; i < planos.size(); i++) {
            if (planos.get(i).getDescricao().equals(plano)) {
                return planos.get(i).getIdPlano();
            }
        }
        return 0;
    }
}
