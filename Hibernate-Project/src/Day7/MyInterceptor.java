package Day7;

import java.io.Serializable;
import java.util.Iterator;

import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.EntityMode;
import org.hibernate.Transaction;
import org.hibernate.type.Type;

public class MyInterceptor extends EmptyInterceptor{

	@Override
	public void afterTransactionBegin(Transaction tx) {
		// TODO Auto-generated method stub
		super.afterTransactionBegin(tx);
	}

	@Override
	public void afterTransactionCompletion(Transaction tx) {
		// TODO Auto-generated method stub
		super.afterTransactionCompletion(tx);
	}

	@Override
	public void beforeTransactionCompletion(Transaction tx) {
		// TODO Auto-generated method stub
		super.beforeTransactionCompletion(tx);
	}

	@Override
	public int[] findDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {
		// TODO Auto-generated method stub
		return super.findDirty(entity, id, currentState, previousState, propertyNames, types);
	}

	@Override
	public Object getEntity(String entityName, Serializable id) {
		// TODO Auto-generated method stub
		return super.getEntity(entityName, id);
	}

	@Override
	public String getEntityName(Object object) {
		// TODO Auto-generated method stub
		return super.getEntityName(object);
	}

	@Override
	public Object instantiate(String entityName, EntityMode entityMode, Serializable id) {
		// TODO Auto-generated method stub
		return super.instantiate(entityName, entityMode, id);
	}

	@Override
	public Boolean isTransient(Object entity) {
		// TODO Auto-generated method stub
		return super.isTransient(entity);
	}

	@Override
	public void onCollectionRecreate(Object collection, Serializable key) throws CallbackException {
		// TODO Auto-generated method stub
		super.onCollectionRecreate(collection, key);
	}

	@Override
	public void onCollectionRemove(Object collection, Serializable key) throws CallbackException {
		// TODO Auto-generated method stub
		super.onCollectionRemove(collection, key);
	}

	@Override
	public void onCollectionUpdate(Object collection, Serializable key) throws CallbackException {
		// TODO Auto-generated method stub
		super.onCollectionUpdate(collection, key);
	}

	@Override
	public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		// TODO Auto-generated method stub
		super.onDelete(entity, id, state, propertyNames, types);
	}

	@Override
	public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {
		// TODO Auto-generated method stub
		return super.onFlushDirty(entity, id, currentState, previousState, propertyNames, types);
	}

	@Override
	public boolean onLoad(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		// TODO Auto-generated method stub
		return super.onLoad(entity, id, state, propertyNames, types);
	}

	@Override
	public String onPrepareStatement(String sql) {
		// TODO Auto-generated method stub
		System.out.println(sql);
		return super.onPrepareStatement(sql);
	}

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		// TODO Auto-generated method stub
		System.out.println("Saving now");
		return super.onSave(entity, id, state, propertyNames, types);
	}

	@Override
	public void postFlush(Iterator entities) {
		// TODO Auto-generated method stub
		super.postFlush(entities);
	}

	@Override
	public void preFlush(Iterator entities) {
		// TODO Auto-generated method stub
		super.preFlush(entities);
	}
	

}
