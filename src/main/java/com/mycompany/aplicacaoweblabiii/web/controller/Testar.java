/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aplicacaoweblabiii.web.controller;

import com.mycompany.aplicacaoweblabiii.db.controller.AssinaturaJpaController;
import com.mycompany.aplicacaoweblabiii.db.controller.CategoryJpaController;
import com.mycompany.aplicacaoweblabiii.db.controller.FormaPgtJpaController;
import com.mycompany.aplicacaoweblabiii.db.controller.PlanoJpaController;
import com.mycompany.aplicacaoweblabiii.db.controller.PostJpaController;
import com.mycompany.aplicacaoweblabiii.db.controller.RoleJpaController;
import com.mycompany.aplicacaoweblabiii.db.controller.TagsJpaController;
import com.mycompany.aplicacaoweblabiii.db.controller.UserJpaController;
import com.mycompany.aplicacaoweblabiii.model.Assinatura;
import com.mycompany.aplicacaoweblabiii.model.Category;
import com.mycompany.aplicacaoweblabiii.model.FormaPgt;
import com.mycompany.aplicacaoweblabiii.model.Plano;
import com.mycompany.aplicacaoweblabiii.model.Post;
import com.mycompany.aplicacaoweblabiii.model.Role;
import com.mycompany.aplicacaoweblabiii.model.Tags;
import com.mycompany.aplicacaoweblabiii.model.User;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Administrador
 */
public class Testar {

    public static void main(String[] args) throws Exception {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_AplicacaoWebLabIII_war_1.0-SNAPSHOTPU");
            RoleJpaController rjc = new RoleJpaController(emf);
            Role role = new Role(12);
            role.setIdRole(12);
            role.setDescription("Escritora");
            rjc.edit(role);
        } catch (Exception ex) {
            Logger.getLogger(ServletRoles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
