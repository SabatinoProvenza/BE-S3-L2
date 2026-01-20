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
        Evento evento2 = new Evento("matrimonio", LocalDate.now().plusMonths(5), "matrimonio al castello delle cerimonie", TipoEvento.PRIVATO, 60);

        // METODO SAVE
        //eventoDAO.save(evento2);


        // METODO GETBYID
//        try {
//            Evento eventoStampato = eventoDAO.getById(3);
//            System.out.println(eventoStampato);
//        } catch (NotFoundException e) {
//            System.out.println(e.getMessage());
//        }

        // METODO DELETE
//        try {
//            eventoDAO.delete(3);
//        } catch (NotFoundException e) {
//            System.out.println(e.getMessage());
//        }

    }
}
