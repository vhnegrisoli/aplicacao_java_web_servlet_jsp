/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aplicacaoweblabiii.web.controller;

import com.mycompany.aplicacaoweblabiii.db.controller.CategoryJpaController;
import com.mycompany.aplicacaoweblabiii.db.controller.PostJpaController;
import com.mycompany.aplicacaoweblabiii.db.controller.TagsJpaController;
import com.mycompany.aplicacaoweblabiii.db.controller.UserJpaController;
import com.mycompany.aplicacaoweblabiii.model.Category;
import com.mycompany.aplicacaoweblabiii.model.Post;
import com.mycompany.aplicacaoweblabiii.model.Tags;
import com.mycompany.aplicacaoweblabiii.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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
 * @author Lord Negrisoli
 */
public class ServletPost extends HttpServlet {

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
            out.println("<title>Servlet ServletPost</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletPost at " + request.getContextPath() + "</h1>");
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
        String autor = request.getParameter("autor");
        String categoria = request.getParameter("categoria");
        String criado = request.getParameter("criado");
        String publicado = request.getParameter("publicado");
        String postagem = request.getParameter("postagem");
        String tags = request.getParameter("tag");
        String id = request.getParameter("id");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_AplicacaoWebLabIII_war_1.0-SNAPSHOTPU");
        PostJpaController pjc = new PostJpaController(emf);

        if (!id.trim().equals("null")) {
            Post post = new Post(Integer.parseInt(id));
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            User user = new User(pkUser(autor));
            Category category = new Category(pkCategory(categoria));
            Tags tag = new Tags(pkTag(tags));
            List<Tags> tagsC = new ArrayList();
            tagsC.add(tag);
            
            try {
                Date dataC = simpleDateFormat.parse(criado);
                Date dataP = simpleDateFormat.parse(publicado);

                post.setCreatedAt(dataC);
                post.setPublishedAt(dataP);

                post.setIdAuthor(user);
                post.setIdCategory(category);
                post.setContent(postagem);
                post.setTagsCollection(tagsC);
                
                pjc.edit(post);
                response.sendRedirect("PostsUD.jsp");
            } catch (Exception ex) {
                Logger.getLogger(ServletRoles.class.getName()).log(Level.SEVERE, null, ex);
                response.sendRedirect("erro.jsp");
            }
        } else {

            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            User user = new User(pkUser(autor));
            Category category = new Category(pkCategory(categoria));
            Tags tag = new Tags(pkTag(tags));
            List<Tags> tagsC = new ArrayList();
            tagsC.add(tag);
            try {
                Post post = new Post();

                Date dataC = simpleDateFormat.parse(criado);
                Date dataP = simpleDateFormat.parse(publicado);

                post.setCreatedAt(dataC);
                post.setPublishedAt(dataP);

                post.setIdAuthor(user);
                post.setIdCategory(category);
                post.setContent(postagem);
                post.setTagsCollection(tagsC);
                pjc.create(post);
                erro = false;
            } catch (Exception e) {

                response.sendRedirect("erro.jsp");
                erro = true;
            }
            if (erro == false) {
                response.sendRedirect("PostsUD.jsp");
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

    public int pkCategory(String category) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_AplicacaoWebLabIII_war_1.0-SNAPSHOTPU");
        CategoryJpaController cjc = new CategoryJpaController(emf);
        List<Category> cats = cjc.findCategoryEntities();
        for (int i = 0; i < cats.size(); i++) {
            if (cats.get(i).getDescription().equals(category)) {
                return cats.get(i).getIdCategory();
            }
        }
        return 0;
    }

    public int pkTag(String tag) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_AplicacaoWebLabIII_war_1.0-SNAPSHOTPU");
        TagsJpaController tjc = new TagsJpaController(emf);
        List<Tags> tags = tjc.findTagsEntities();
        for (int i = 0; i < tags.size(); i++) {
            if (tags.get(i).getDescription().equals(tag)) {
                return tags.get(i).getIdTags();
            }
        }
        return 0;
    }

}
