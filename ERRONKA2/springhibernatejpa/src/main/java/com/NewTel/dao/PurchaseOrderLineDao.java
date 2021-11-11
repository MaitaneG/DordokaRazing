package com.NewTel.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import eus.uni.dam.PurchaseOrderLine;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class PurchaseOrderLineDao {

    @PersistenceContext
    private EntityManager entityManager;


    /**
     * Datubasean objetua sortzeko metodoa
     * @param purchase
     */
    public void create(PurchaseOrderLine purchase) {
        entityManager.persist(purchase);

    }


    /**
     * Datubaseko objetu bat ezabatzeko
     * @param purchase
     */
    public void delete(PurchaseOrderLine purchase) {
        if(entityManager.contains(purchase)) entityManager.remove(purchase);
        else entityManager.remove(entityManager.merge(purchase));
        return;
    }


    /**
     * produktu guztiak itzultzen ditu lista batean
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<PurchaseOrderLine> getAll(){
        return entityManager.createQuery("from PurchaseOrderLine").getResultList();
    }


    /**
     * Produktua itzultzen du bere id-a sartuta
     * @param id
     * @return
     */
    public PurchaseOrderLine getById(long id) {
        return entityManager.find(PurchaseOrderLine.class, id);
    }



    /**
     * Produktua datubasean aktualizatzeko metodoa
     * @param purchase
     */
    public void update(PurchaseOrderLine purchase) {
        entityManager.merge(purchase);

    }
}
