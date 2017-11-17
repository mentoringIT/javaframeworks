package mx.com.mentoringit.model.interfaces;

import java.util.List;

import org.hibernate.criterion.Criterion;

public interface IPurchaseOrder<T> {

	public List<T> findAll(Class<T> clazz) throws Exception;

	public T find(Class<T> clazz, Criterion criteria) throws Exception;

	public T saveOrUpdate(T type) throws Exception;

}
