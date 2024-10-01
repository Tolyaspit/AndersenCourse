import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class NewTicketDAOImpl implements NewTicketDAO {
    private SessionFactory sessionFactory;

    public NewTicketDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveTicket(NewTicket ticket) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(ticket);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public NewTicket getTicketById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(NewTicket.class, id);
        }
    }

    @Override
    public List<NewTicket> getAllTickets() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM NewTicket", NewTicket.class).list();
        }
    }

    @Override
    public void updateTicket(NewTicket ticket) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(ticket);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTicket(int id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            NewTicket ticket = session.get(NewTicket.class, id);
            if (ticket != null) {
                session.delete(ticket);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
