package repository;

import entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ClientRepository {
    private SessionFactory sessionFactory;

    public ClientRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Client client) {
        Session session = sessionFactory.openSession();
        session.save(client);
        session.close();
    }

    public Client findOne(int id) {
        Session session = sessionFactory.openSession();
        Client client= session.find(Client.class, id);
        session.close();
        return client;
    }
}
