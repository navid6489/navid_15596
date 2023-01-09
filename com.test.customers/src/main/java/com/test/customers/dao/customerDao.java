package com.test.customers.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.test.customers.model.customer;
import com.test.customers.HibernateUtil.*;

public class customerDao implements IDao<customer> {
	private Session session;
	private Transaction transaction;
	private Query query;

	@Override
	public boolean createcustomer(customer customers) {
		boolean result=false;
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		if(session.save(customers)!=null) {
			result=true;
		}		
		transaction.commit();
		return result;
	}

	@Override
	public List<customer> findAll() {
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("from customer");//select * from customers
		final List<customer> customerList=query.list();
		transaction.commit();
		return customerList;
	}

	@Override
	public customer findOne(int id) {
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("from customer c where c.id="+id);//select * from customers
		final customer customers=(customer) query.getSingleResult();
		transaction.commit();
		return customers;
	}

	@Override
	public boolean findOneandDelete(int id) {
		boolean result=false;
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("Delete from customer c where c.id=:id");
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
	public boolean findOneandUpdate(int id, customer newObj) {
		boolean result=false;
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("Update customer c set c.name=:name where id=:id");
		query.setParameter("id",id);
		query.setParameter("name",newObj.getName());
		final int statusUpdate=query.executeUpdate();		
		transaction.commit();
		if(statusUpdate>0) {
			result=true;
		}
		return result;
	}

}
