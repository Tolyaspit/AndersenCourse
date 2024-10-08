package dao;

import jakarta.transaction.Transactional;
import model.NewTicket;
import model.NewUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NewUserDAOImpl implements NewUserDAO {
    private SessionFactory sessionFactory;

    @Value("${app.update.enabled:true}")
    private boolean isUpdateEnabled;

    @Autowired
    public NewUserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void saveUser(NewUser user) {
        if (user.getStatus() == null) {
            user.setStatus(NewUser.UserStatus.PENDING);
        }
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @Transactional
    public NewUser getUserById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(NewUser.class, id);
        }
    }

    @Override
    @Transactional
    public List<NewUser> getAllUsers() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM model.model.NewUser", NewUser.class).list();
        }
    }

    @Override
    @Transactional
    public void updateUser(NewUser user) {
        if (user.getStatus() == null) {
            user.setStatus(NewUser.UserStatus.PENDING);
        }
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        NewUser user = sessionFactory.getCurrentSession().get(NewUser.class, id);
        if (user != null) {
            sessionFactory.getCurrentSession().delete(user);
        }
    }

    @Override
    @Transactional
    public void updateUserAndCreateTicket(int userId, NewTicket ticket) {
        if (!isUpdateEnabled) {
            throw new RuntimeException("Update feature is disabled in the application.");
        }

        try (Session session = sessionFactory.openSession()) {
            NewUser user = session.get(NewUser.class, userId);
            if (user != null) {
                user.setStatus(NewUser.UserStatus.ACTIVATED);
                session.update(user);
                session.save(ticket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
