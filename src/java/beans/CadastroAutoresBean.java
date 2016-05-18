package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import modelo.Autor;
import persistencia.AutorDAO;

@ManagedBean(name="autoresBean")
@ViewScoped
public class CadastroAutoresBean extends AbstractBean {
    private Autor autor;
    private AutorDAO dao = new AutorDAO();

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    
    
}
