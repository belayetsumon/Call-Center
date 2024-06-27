/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itgarden.ERP.module.callcenter.Controller;

import com.itgarden.ERP.exceptions.NonexistentEntityException;
import com.itgarden.ERP.exceptions.PreexistingEntityException;
import com.itgarden.ERP.module.callcenter.Model.ECdr;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author libertyerp_local
 */
public class ECdrJpaController implements Serializable {

    public ECdrJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ECdr ECdr) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
           
                    
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(ECdr);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findECdr(ECdr.getFlowno()) != null) {
                throw new PreexistingEntityException("ECdr " + ECdr + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ECdr ECdr) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ECdr = em.merge(ECdr);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = ECdr.getFlowno();
                if (findECdr(id) == null) {
                    throw new NonexistentEntityException("The eCdr with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ECdr ECdr;
            try {
                ECdr = em.getReference(ECdr.class, id);
                ECdr.getFlowno();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ECdr with id " + id + " no longer exists.", enfe);
            }
            em.remove(ECdr);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ECdr> findECdrEntities() {
        return findECdrEntities(true, -1, -1);
    }

    public List<ECdr> findECdrEntities(int maxResults, int firstResult) {
        return findECdrEntities(false, maxResults, firstResult);
    }

    private List<ECdr> findECdrEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ECdr.class));
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

    public ECdr findECdr(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ECdr.class, id);
        } finally {
            em.close();
        }
    }

    public int getECdrCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ECdr> rt = cq.from(ECdr.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
