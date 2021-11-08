package com.NewTel.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import eus.uni.dam.SaleOrderLine;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class SaleOrderLineDao {

    @PersistenceContext
    private EntityManager entityManager;


    /**
     * Datubasean objetua sortzeko metodoa
     * @param saleo
     */
    public void create(SaleOrderLine saleo) {
        String sqlQuery="CREATE TABLE";
        entityManager.createQuery(sqlQuery);
        entityManager.persist(saleo);
        return;
    }


    /**
     * Datubaseko objetu bat ezabatzeko
     * @param saleo
     */
    public void delete(SaleOrderLine saleo) {
        if(entityManager.contains(saleo)) entityManager.remove(saleo);
        else entityManager.remove(entityManager.merge(saleo));
        return;
    }


    /**
     * produktu guztiak itzultzen ditu lista batean
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<SaleOrderLine> getAll(){
        return entityManager.createQuery("from SaleOrderLine").getResultList();
    }


    /**
     * Produktua itzultzen du bere id-a sartuta
     * @param id
     * @return
     */
    public SaleOrderLine getById(long id) {
        return entityManager.find(SaleOrderLine.class, id);
    }



    /**
     * Produktua datubasean aktualizatzeko metodoa
     * @param saleo
     */
    public void update(SaleOrderLine saleo) {
        entityManager.merge(saleo);
        return;
    }
}
