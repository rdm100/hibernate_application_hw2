package com.codeclan.db;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;


    public class DBHelper {

        private static Transaction transaction;
        private static Session session;

        public static void save(Object object) {

            session = HibernateUtil.getSessionFactory().openSession();
            try {
                transaction = session.beginTransaction();
                session.saveOrUpdate(object);
                transaction.commit();
            } catch (HibernateException e) {
                transaction.rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }
        }

        public static <T> List<T> getAll(Class classType) {
            session = HibernateUtil.getSessionFactory().openSession();
            List<T> results = null;
            try {
                transaction = session.beginTransaction();
                Criteria cr = session.createCriteria(classType);
                results = cr.list();
                transaction.commit();
            } catch (HibernateException e) {
                transaction.rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }
            return results;
        }

        public static <T> T find(Class classType, int id) {
            session = HibernateUtil.getSessionFactory().openSession();
            T result = null;
            try {
                transaction = session.beginTransaction();
                Criteria cr = session.createCriteria(classType);
                cr.add(Restrictions.eq("id", id));
                result = (T) cr.uniqueResult();
                transaction.commit();
            } catch (HibernateException e) {
                transaction.rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }
            return result;
        }


}//end of class
