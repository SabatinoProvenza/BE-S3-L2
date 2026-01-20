package sabatinoprovenza;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sabatinoprovenza.dao.EventoDAO;
import sabatinoprovenza.entities.Evento;
import sabatinoprovenza.entities.TipoEvento;

import java.time.LocalDate;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("BE-S3-L2pu");

    public static void main(String[] args) {

        EntityManager entityManager = emf.createEntityManager();
        EventoDAO eventoDAO = new EventoDAO(entityManager);

        Evento evento1 = new Evento("festa", LocalDate.now(), "festa a sorpresa", TipoEvento.PRIVATO, 30);
        // eventoDAO.save(evento1);
    }
}
