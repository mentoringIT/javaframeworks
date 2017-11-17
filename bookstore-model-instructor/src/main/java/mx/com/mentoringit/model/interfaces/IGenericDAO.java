package mx.com.mentoringit.model.interfaces;

import java.util.List;

import org.hibernate.criterion.Criterion;

public interface IGenericDAO<T> {

	public T saveOrUpdate(T type) throws Exception;

	public void delete(T type) throws Exception;

	public T find(Class<T> clazz, Criterion criteria) throws Exception;

	public List<T> findAll(Class<T> clazz) throws Exception;
}
