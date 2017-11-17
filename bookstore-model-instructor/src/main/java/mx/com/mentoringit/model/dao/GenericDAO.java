package mx.com.mentoringit.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mx.com.mentoringit.model.interfaces.IGenericDAO;

@SuppressWarnings("unchecked")
@Repository("genericDAO")
public class GenericDAO<T> implements IGenericDAO<T> {

	// le indica a SPRING que debe inyectar aqui un objeto de tipo
	// SessionFactory
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public T saveOrUpdate(T type) throws Exception {

		Session sesion = sessionFactory.getCurrentSession();
		try {
			sesion.saveOrUpdate(type);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return type;
	}

	public void delete(T type) throws Exception {
		sessionFactory.getCurrentSession().delete(type);
	}

	public T find(Class<T> clazz, Criterion criteria) throws Exception {
		Session sesion = sessionFactory.getCurrentSession();

		DetachedCriteria query = DetachedCriteria.forClass(clazz).add(criteria);

		T type = null;
		try {
			type = (T) query.getExecutableCriteria(sesion).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return type;
	}

	public List<T> findAll(Class<T> clazz) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(clazz);
		return crit.list();
	}

}
