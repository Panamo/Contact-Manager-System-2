package home.parham.cms.dao;

import home.parham.cms.controllers.ContactList;
import home.parham.cms.domain.Contact;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateContactDao implements ContactDao {

	private SessionFactory factory;

	@SuppressWarnings("deprecation")
	public HibernateContactDao() {
		Configuration configuration = new Configuration();
		factory = configuration.configure().buildSessionFactory();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ContactList read(String path) throws IOException, DaoException {
		Session session = factory.openSession();
		Query query = session.createQuery("from contacts");
		ContactList contacts = new ContactList();
		try {
			List<?> list = query.list();
			contacts.clear();
			contacts.addAll((List<? extends Contact>) list);
		} catch (HibernateException exception) {
			throw new DaoException(exception);
		}
		session.close();
		return contacts;
	}

	@Override
	public void write(ContactList contacts, String path)
			throws FileNotFoundException, DaoException {
		Session session = factory.openSession();
		for (Contact contact : contacts) {
			try {
				session.getTransaction().begin();
				session.persist(contact);
				session.getTransaction().commit();
			} catch (HibernateException exception) {
				session.getTransaction().rollback();
				throw new DaoException(exception);
			}
			session.close();
		}
	}

}
