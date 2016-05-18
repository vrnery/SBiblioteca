package modelo;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Representa um item de um empréstimo.
 * 
 * @author Leonardo
 */
public class ItemDeEmprestimo {
    private int id;
    //private double valorOriginal;
    private Date dataParaDevolucao;
    private int diasEmAtraso;
    private Livro livro;

    public ItemDeEmprestimo() {
        
    }
    
    public ItemDeEmprestimo(Livro livro) {
        this.livro = livro;
        //this.valorOriginal = livro.getPreco();
        this.dataParaDevolucao = calcularDataDevolucao();
        //this.livro.setItemDeEmprestimoCorrente(this);
    }

    private Date calcularDataDevolucao() {
        GregorianCalendar cal = new GregorianCalendar();
        cal.add(GregorianCalendar.DAY_OF_MONTH, 7);
        return cal.getTime();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

//    public double getValorOriginal() {
//        return valorOriginal;
//    }

//    public void setValorOriginal(double valorOriginal) {
//        this.valorOriginal = valorOriginal;
//    }

    public Date getDataParaDevolucao() {
        return dataParaDevolucao;
    }

    public void setDataParaDevolucao(Date dataParaDevolucao) {
        this.dataParaDevolucao = dataParaDevolucao;
    }

    public int getDiasEmAtraso() {
        return diasEmAtraso;
    }

    public void setDiasEmAtraso(int diasEmAtraso) {
        this.diasEmAtraso = diasEmAtraso;
    }

//    public DVD getDvd() {
//        return dvd;
//    }

//    public void setDvd(DVD dvd) {
//        this.dvd = dvd;
//    }
    
    public void devolver() {
        Date hoje = new Date();
        if(hoje.after(dataParaDevolucao))
            this.diasEmAtraso = (int)((hoje.getTime() - this.dataParaDevolucao.getTime())/86400000L);
        else
            this.diasEmAtraso = 0;
        //livro.setItemDeEmprestimoCorrente(null);
    }
    
//    public double getValorMulta() {
//        return diasEmAtraso * valorOriginal;
//    }
    
//    public double getValorFinal() {
//        return valorOriginal + getValorMulta();
//    }
    
    public boolean isAtrasado() {
        return diasEmAtraso > 0;
    }
}
