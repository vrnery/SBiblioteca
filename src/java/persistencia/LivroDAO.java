package persistencia;

import java.util.List;
import modelo.Livro;
import org.hibernate.Session;

public class LivroDAO {
    private final Session sessao;
    
    public LivroDAO() {
        sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        sessao.beginTransaction();
    }
    
    public void salvar(Livro l) {
        sessao.saveOrUpdate(l);
    }
    
    public Livro carregar(int id) {
        return (Livro) sessao.load(Livro.class, id);
    }
    
    public List<Livro> listar() {
        return sessao.createCriteria(Livro.class).list();
    }
    
    public void remover(Livro l) {
        sessao.delete(l);
    }
    
    public void encerrar() {
        sessao.getTransaction().commit();
    }
}
