package eus.uni.dam;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ResPartnerDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	/**
	 * Datubasean objetua sortzeko metodoa
	 * @param saleo
	 */
	public void create(ResPartner respartner) {
		entityManager.persist(respartner);
		return;
	}
	
	
	/**
	 * Datubaseko objetu bat ezabatzeko
	 * @param saleo
	 */
	public void delete(ResPartner respartner) {
		if(entityManager.contains(respartner)) entityManager.remove(respartner);
		else entityManager.remove(entityManager.merge(respartner));
		return;
	}
	
	
	/**
	 * produktu guztiak itzultzen ditu lista batean
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ResPartner> getAll(){
		return entityManager.createQuery("from ResPartner").getResultList();
	}
	
	
	/**
	 * Produktua itzultzen du bere id-a sartuta
	 * @param id
	 * @return
	 */
	public ResPartner getById(long id) {
		return entityManager.find(ResPartner.class, id);
	}
	
	
	
	/**
	 * Produktua datubasean aktualizatzeko metodoa
	 * @param saleo
	 */
	public void update(ResPartner respartner) {
		entityManager.merge(respartner);
		return;
	}
}
