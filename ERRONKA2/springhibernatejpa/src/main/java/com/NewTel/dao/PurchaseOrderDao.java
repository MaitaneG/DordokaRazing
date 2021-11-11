package com.NewTel.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import eus.uni.dam.PurchaseOrder;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class PurchaseOrderDao {

    @PersistenceContext
    private EntityManager entityManager;


    /**
     * Datubasean objetua sortzeko metodoa
     * @param purchaseOrder
     */
    public void create(PurchaseOrder purchaseOrder) {
        entityManager.persist(purchaseOrder);

    }


    /**
     * Datubaseko objetu bat ezabatzeko
     * @param purchaseOrder
     */
    public void delete(PurchaseOrder purchaseOrder) {
        if(entityManager.contains(purchaseOrder)) entityManager.remove(purchaseOrder);
        else entityManager.remove(entityManager.merge(purchaseOrder));
        return;
    }


    /**
     * produktu guztiak itzultzen ditu lista batean
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<PurchaseOrder> getAll(){
        return entityManager.createQuery("from PurchaseOrder").getResultList();
    }


    /**
     * Produktua itzultzen du bere id-a sartuta
     * @param id
     * @return
     */
    public PurchaseOrder getById(long id) {
        return entityManager.find(PurchaseOrder.class, id);
    }



    /**
     * Produktua datubasean aktualizatzeko metodoa
     * @param purchaseOrder
     */
    public void update(PurchaseOrder purchaseOrder) {
        entityManager.merge(purchaseOrder);

    }
}
