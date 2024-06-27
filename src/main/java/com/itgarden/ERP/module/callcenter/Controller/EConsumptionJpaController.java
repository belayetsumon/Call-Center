/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itgarden.ERP.module.callcenter.Controller;

import com.itgarden.ERP.exceptions.NonexistentEntityException;
import com.itgarden.ERP.exceptions.PreexistingEntityException;
import com.itgarden.ERP.module.callcenter.Model.EConsumption;
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
public class EConsumptionJpaController implements Serializable {

    public EConsumptionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EConsumption EConsumption) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(EConsumption);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEConsumption(EConsumption.getId()) != null) {
                throw new PreexistingEntityException("EConsumption " + EConsumption + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EConsumption EConsumption) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EConsumption = em.merge(EConsumption);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = EConsumption.getId();
                if (findEConsumption(id) == null) {
                    throw new NonexistentEntityException("The eConsumption with id " + id + " no longer exists.");
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
            EConsumption EConsumption;
            try {
                EConsumption = em.getReference(EConsumption.class, id);
                EConsumption.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The EConsumption with id " + id + " no longer exists.", enfe);
            }
            em.remove(EConsumption);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EConsumption> findEConsumptionEntities() {
        return findEConsumptionEntities(true, -1, -1);
    }

    public List<EConsumption> findEConsumptionEntities(int maxResults, int firstResult) {
        return findEConsumptionEntities(false, maxResults, firstResult);
    }

    private List<EConsumption> findEConsumptionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EConsumption.class));
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

    public EConsumption findEConsumption(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EConsumption.class, id);
        } finally {
            em.close();
        }
    }

    public int getEConsumptionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EConsumption> rt = cq.from(EConsumption.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
