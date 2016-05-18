package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="livros")
public class Livro {
    @Id
    @GeneratedValue
    private int id;
    private String titulo;
    private String primeiroNomeAutor;
    private String sobrenomeAutor;
    private String sinopse;
    private int anoPublicacao;
    private String editora;
    private boolean doacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPrimeiroNomeAutor() {
        return primeiroNomeAutor;
    }

    public void setPrimeiroNomeAutor(String primeiroNomeAutor) {
        this.primeiroNomeAutor = primeiroNomeAutor;
    }

    public String getSobrenomeAutor() {
        return sobrenomeAutor;
    }

    public void setSobrenomeAutor(String sobrenomeAutor) {
        this.sobrenomeAutor = sobrenomeAutor;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public boolean isDoacao() {
        return doacao;
    }

    public void setDoacao(boolean doacao) {
        this.doacao = doacao;
    }
}
