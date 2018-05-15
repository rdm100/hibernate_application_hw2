package com.codeclan.db;

import com.codeclan.models.File;
import com.codeclan.models.Folder;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.transaction.Transaction;
import java.util.List;

public class DBFolder {

    private static Transaction transaction;
    private static Session session;

    public static List<File> getFilesInFolder(Folder folder){
        session = HibernateUtil.getSessionFactory().openSession();
        List<File> results = null;
        try{
            Criteria criteria = session.createCriteria(File.class);
            criteria.add(Restrictions.eq("folder", folder));
            results = criteria.list();
        } catch (HibernateException e){
            e.printStackTrace();
        } session.close();
        return results;
    }



}
