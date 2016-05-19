package beans;




import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 10070124
 */
public class FiltroTransacao implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession sessaoHTTP = req.getSession(false);
        TransacaoSistemaBiblioteca transacaoCorrente = null;
        if(req.getRequestURI().endsWith(".xhtml") && sessaoHTTP != null) {
            transacaoCorrente = (TransacaoSistemaBiblioteca) sessaoHTTP.getAttribute("transacaoCorrente");
            if(transacaoCorrente != null)
                transacaoCorrente.iniciarRequisicao();
        }
        chain.doFilter(request, response);
        if(req.getRequestURI().endsWith(".xhtml") && sessaoHTTP != null && transacaoCorrente != null)
            transacaoCorrente.finalizarRequisicao();
    }

    @Override
    public void destroy() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
