package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import entity.Person;

public class PersonDao {
	private SessionFactory factory;

	public PersonDao() {
		factory = MySessionFactory.getInstance().getFactory();
	}

	public void savePerson(Person p) {

		Session session = factory.openSession();
		Transaction tr = session.getTransaction();

		try {
			tr.begin();
			session.saveOrUpdate(p);
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public Person getPersonByID(int id) {

		Session session = factory.openSession();
		Transaction tr = session.getTransaction();
		Person p = session.get(Person.class, id);
		try {
			tr.begin();

			tr.commit();
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return p;

	}

	public List<Person> getAllPerson() {

		Session session = factory.openSession();
		Transaction tr = session.getTransaction();
		List<Person> list = null;
		try {
			tr.begin();
			NativeQuery<Person> query = session.createNativeQuery("select * from person", Person.class);
			list = query.getResultList();
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	
	public void deletePerson(int id) {
		Session session = factory.openSession();
		Transaction tr = session.getTransaction();

		try {
			tr.begin();
			Person p = getPersonByID(id);
		
			session.delete(p);

			tr.commit();
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
