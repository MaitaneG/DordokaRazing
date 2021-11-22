package com.NewTel.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional  //Método bakoitza hasi aurretik transakzio bat hasiko da, metodoa bukatutakoan, transakzioa bukatu 
public class ProduktuaDao {

    // A través de la anotación @PersistenceContext, se inyectará automáticamente
    // un EntityManager producido desde el entityManagerFactory definido en la clase
    // DatabaseConfig.
    @PersistenceContext
    private EntityManager entityManager;


    /**
     * Almacena la peli en la base de datos
     */
    public void create(Pelicula peli) {
        entityManager.persist(peli);

    }

    /**
     * Elimina el usuario de la base de datos.
     */
    public void delete(Pelicula peli) {
        if (entityManager.contains(peli))
            entityManager.remove(peli);
        else
            entityManager.remove(entityManager.merge(peli));

    }

    /**
     * Devuelve todos los usuarios de la base de datos.
     */
    @SuppressWarnings("unchecked")
    public List<Pelicula> getAll() {
        return entityManager.createQuery("from Pelicula").getResultList();
    }

    /**
     * Devuelve un usuario en base a su Id
     */
    public Pelicula getById(long id) {
        return entityManager.find(Pelicula.class, id);
    }

    /**
     * Actualiza el usuario proporcionado
     */
    public void update(Pelicula peli) {
        entityManager.merge(peli);

    }

}