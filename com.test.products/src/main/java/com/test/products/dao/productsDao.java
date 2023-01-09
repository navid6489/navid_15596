package com.test.products.dao;

import java.util.List;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.test.products.model.products;
import com.test.products.HibernateUtil.HibernateUtil;

public class productsDao implements IDao<products> {
	private Session session;
	private Transaction transaction;
	private Query query;

	@Override
	public boolean createproduct(products product) {
		boolean result=false;
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		if(session.save(product)!=null) {
			result=true;
		}		
		transaction.commit();
		return result;
	}

	@Override
	public List<products> findAll() {
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("from products");//select * from products
		final List<products> productList=query.list();
		transaction.commit();
		return productList;
	}

	@Override
	public products findOne(int id) {
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("from products p where p.id="+id);//select * from products
		final products product=(products) query.getSingleResult();
		transaction.commit();
		return product;
	}

	@Override
	public boolean findOneandDelete(int id) {
		boolean result=false;
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("Delete from products p where p.id=:id");
		query.setParameter("id",id);
		final int statusDelete=query.executeUpdate();		
		transaction.commit();
//		System.out.println("statusDeleted: "+statusDelete);
		if(statusDelete>0) {
			result=true;
		}
		return result;
	}

	@Override
	public boolean findOneandUpdate(int id, products product) {
		boolean result=false;
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("Update products p set p.name=:name where id=:id");
		query.setParameter("id",id);
		query.setParameter("name",product.getName());
		final int statusUpdate=query.executeUpdate();		
		transaction.commit();
		if(statusUpdate>0) {
			result=true;
		}
		return result;
	}

}
