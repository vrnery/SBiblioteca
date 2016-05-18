package beans;

import java.util.List;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import modelo.Livro;
import persistencia.LivroDAO;

@ManagedBean(name="livroBean")
@RequestScoped
public class CadastroLivrosBean {
    private Livro livro = new Livro();
    private LivroDAO dao = new LivroDAO();
    private List<Livro> listaLivros;

    public CadastroLivrosBean() {
        listaLivros = dao.listar();
    }
    
    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public List<Livro> getListaLivros() {
        return listaLivros;
    }
    
    public void salvar() {
        dao.salvar(livro);
        listaLivros = dao.listar();
        enviarMensagem(FacesMessage.SEVERITY_INFO, "Livro cadastrado com sucesso");
    }
    
    public void carregar(int idLivro) {
        livro = dao.carregar(idLivro);
    }
    
    public void remover(Livro livro) {
        dao.remover(livro);
        listaLivros = dao.listar();
        enviarMensagem(FacesMessage.SEVERITY_INFO, "Livro removido com sucesso");
    }
    
    private void enviarMensagem(Severity sev, String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(sev, msg, ""));
    }
    
    @PreDestroy
    public void encerrar() {
        dao.encerrar();
    }
}
