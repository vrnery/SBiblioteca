/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import modelo.Autor;
import org.hibernate.Session;

public class AutorDAO {
    private final Session sessao;
    
    public AutorDAO() {
        sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        sessao.beginTransaction();
    }
    
    public void salvar(Autor a) {
        sessao.saveOrUpdate(a);
    }
    
    public Autor carregar(int id) {
        return (Autor) sessao.get(Autor.class, id);
    }
    
    public void remover(Autor a) {
        sessao.delete(a);
    }
    
    public List<Autor> listar() {
        return sessao.createCriteria(Autor.class).list();
    }
    
    public void encerrar() {
        sessao.getTransaction().commit();
    }
}
