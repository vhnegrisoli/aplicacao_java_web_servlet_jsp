/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aplicacaoweblabiii.db.controller;

import com.mycompany.aplicacaoweblabiii.db.controller.exceptions.NonexistentEntityException;
import com.mycompany.aplicacaoweblabiii.db.controller.exceptions.PreexistingEntityException;
import com.mycompany.aplicacaoweblabiii.model.Assinatura;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.aplicacaoweblabiii.model.FormaPgt;
import com.mycompany.aplicacaoweblabiii.model.Plano;
import com.mycompany.aplicacaoweblabiii.model.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Administrador
 */
public class AssinaturaJpaController implements Serializable {

    public AssinaturaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Assinatura assinatura) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            FormaPgt idFormaPgt = assinatura.getIdFormaPgt();
            if (idFormaPgt != null) {
                idFormaPgt = em.getReference(idFormaPgt.getClass(), idFormaPgt.getIdFormaPgt());
                assinatura.setIdFormaPgt(idFormaPgt);
            }
            Plano idPlano = assinatura.getIdPlano();
            if (idPlano != null) {
                idPlano = em.getReference(idPlano.getClass(), idPlano.getIdPlano());
                assinatura.setIdPlano(idPlano);
            }
            User idUser = assinatura.getIdUser();
            if (idUser != null) {
                idUser = em.getReference(idUser.getClass(), idUser.getIdUser());
                assinatura.setIdUser(idUser);
            }
            em.persist(assinatura);
            if (idFormaPgt != null) {
                idFormaPgt.getAssinaturaCollection().add(assinatura);
                idFormaPgt = em.merge(idFormaPgt);
            }
            if (idPlano != null) {
                idPlano.getAssinaturaCollection().add(assinatura);
                idPlano = em.merge(idPlano);
            }
            if (idUser != null) {
                idUser.getAssinaturaCollection().add(assinatura);
                idUser = em.merge(idUser);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAssinatura(assinatura.getIdAssinatura()) != null) {
                throw new PreexistingEntityException("Assinatura " + assinatura + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Assinatura assinatura) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            assinatura = em.merge(assinatura);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = assinatura.getIdAssinatura();
                if (findAssinatura(id) == null) {
                    throw new NonexistentEntityException("The assinatura with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Assinatura assinatura;
            try {
                assinatura = em.getReference(Assinatura.class, id);
                assinatura.getIdAssinatura();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The assinatura with id " + id + " no longer exists.", enfe);
            }
            FormaPgt idFormaPgt = assinatura.getIdFormaPgt();
            if (idFormaPgt != null) {
                idFormaPgt.getAssinaturaCollection().remove(assinatura);
                idFormaPgt = em.merge(idFormaPgt);
            }
            Plano idPlano = assinatura.getIdPlano();
            if (idPlano != null) {
                idPlano.getAssinaturaCollection().remove(assinatura);
                idPlano = em.merge(idPlano);
            }
            User idUser = assinatura.getIdUser();
            if (idUser != null) {
                idUser.getAssinaturaCollection().remove(assinatura);
                idUser = em.merge(idUser);
            }
            em.remove(assinatura);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Assinatura> findAssinaturaEntities() {
        return findAssinaturaEntities(true, -1, -1);
    }

    public List<Assinatura> findAssinaturaEntities(int maxResults, int firstResult) {
        return findAssinaturaEntities(false, maxResults, firstResult);
    }

    private List<Assinatura> findAssinaturaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Assinatura.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Assinatura findAssinatura(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Assinatura.class, id);
        } finally {
            em.close();
        }
    }

    public int getAssinaturaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Assinatura> rt = cq.from(Assinatura.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
