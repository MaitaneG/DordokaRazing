package eus.uni.dam;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class SaleOrderDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	/**
	 * Datubasean objetua sortzeko metodoa
	 * @param saleo
	 */
	public void create(SaleOrder saleo) {
		entityManager.persist(saleo);
		return;
	}
	
	
	/**
	 * Datubaseko objetu bat ezabatzeko
	 * @param saleo
	 */
	public void delete(SaleOrder saleo) {
		if(entityManager.contains(saleo)) entityManager.remove(saleo);
		else entityManager.remove(entityManager.merge(saleo));
		return;
	}
	
	
	/**
	 * produktu guztiak itzultzen ditu lista batean
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<SaleOrder> getAll(){
		return entityManager.createQuery("from SaleOrder").getResultList();
	}
	
	
	/**
	 * Produktua itzultzen du bere id-a sartuta
	 * @param id
	 * @return
	 */
	public SaleOrder getById(long id) {
		return entityManager.find(SaleOrder.class, id);
	}
	
	
	
	/**
	 * Produktua datubasean aktualizatzeko metodoa
	 * @param saleo
	 */
	public void update(SaleOrder saleo) {
		entityManager.merge(saleo);
		return;
	}
}
