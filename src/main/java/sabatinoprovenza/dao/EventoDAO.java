package sabatinoprovenza.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import sabatinoprovenza.entities.Evento;

public class EventoDAO {
    private final EntityManager entityManager;

    public EventoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Evento nuvoEvento) {
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        entityManager.persist(nuvoEvento);

        transaction.commit();

        System.out.println("Il nuvo evento " + nuvoEvento.getTitolo() + " è stato salvato correttamente!");
    }
}
