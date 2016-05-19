package beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 10070124
 */
public abstract class AbstractBean {
    private TransacaoSistemaBiblioteca transacaoCorrente;
    
    public void aoIniciar(){}
    public void aoFinalizar(){}
    
    @PostConstruct
    public void inicializacao(){
        aoIniciar();
        transacaoCorrente = new TransacaoSistemaBiblioteca();
        transacaoCorrente.iniciar();
        HttpSession sessaoHTTP = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        sessaoHTTP.setAttribute("transacaoCorrente", transacaoCorrente);
    }
    
    @PreDestroy
    public void finalizacao(){
        aoFinalizar();
        transacaoCorrente.finalizar();
        HttpSession sessaoHTTP = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        sessaoHTTP.removeAttribute("transacaoCorrente");
    }
}
