package dao;

import model.NewTicket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class NewTicketDAOImpl implements NewTicketDAO {
    private SessionFactory sessionFactory;

    public NewTicketDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void saveTicket(NewTicket ticket) {
        sessionFactory.getCurrentSession().save(ticket);
    }

    @Override
    @Transactional
    public NewTicket getTicketById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(NewTicket.class, id);
        }
    }

    @Override
    @Transactional
    public List<NewTicket> getAllTickets() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM model.NewTicket", NewTicket.class).list();
        }
    }

    @Override
    @Transactional
    public void updateTicket(NewTicket ticket) {
        sessionFactory.getCurrentSession().update(ticket);
    }

    @Override
    @Transactional
    public void deleteTicket(int id) {
        NewTicket ticket = sessionFactory.getCurrentSession().get(NewTicket.class, id);
        if (ticket != null) {
            sessionFactory.getCurrentSession().delete(ticket);
        }
    }
}
