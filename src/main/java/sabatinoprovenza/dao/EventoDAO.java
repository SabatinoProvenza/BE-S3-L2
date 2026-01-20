package sabatinoprovenza.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import sabatinoprovenza.entities.Evento;
import sabatinoprovenza.exceptions.NotFoundException;

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

        System.out.println("Il nuovo evento " + nuvoEvento.getTitolo() + " è stato salvato correttamente!");
    }

    public Evento getById(long eventoId) {
        Evento found = entityManager.find(Evento.class, eventoId);
        if (found == null) throw new NotFoundException(eventoId);
        return found;
    }

    public void delete(long eventoId) {
        Evento found = this.getById(eventoId);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();
        System.out.println("L'evento con id:" + eventoId + " è stato rimosso correttamente!");
    }
}
