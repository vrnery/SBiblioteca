package beans;




import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.context.internal.ManagedSessionContext;
import persistencia.HibernateUtil;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 10070124
 */
public class TransacaoSistemaBiblioteca {
    private Session sessaoHibernate;
    
    public void iniciar(){
        sessaoHibernate = HibernateUtil.getSessionFactory().openSession();
        sessaoHibernate.setFlushMode(FlushMode.MANUAL);
    }
    
    public void finalizar(){
        if(!sessaoHibernate.getTransaction().wasCommitted())
            sessaoHibernate.getTransaction().commit();
        sessaoHibernate.flush();
        sessaoHibernate.close();
    }
    
    public void iniciarRequisicao(){
        ManagedSessionContext.bind(sessaoHibernate);
        if(!sessaoHibernate.getTransaction().isActive())
            sessaoHibernate.beginTransaction();
    }
    
    public void finalizarRequisicao(){
        if(sessaoHibernate.isOpen() && sessaoHibernate.getTransaction().isActive())
            sessaoHibernate.getTransaction().commit();
        ManagedSessionContext.unbind(HibernateUtil.getSessionFactory());
    }
}
