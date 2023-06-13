/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeNaoInformadaException;
import br.unipar.central.exceptions.TamanhoCampoInvalidoException;
import br.unipar.central.exceptions.ValorNegativoException;
import br.unipar.central.models.Conta;
import br.unipar.central.models.Pais;
import br.unipar.central.repositories.ContaDAO;
import br.unipar.central.repositories.PaisDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author muril
 */
public class ContaService {

    private void validar(Conta conta) throws
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException,
            ValorNegativoException {

        if (conta == null) {
            throw new EntidadeNaoInformadaException("Conta");
        }

        if (conta.getAgenciaId() == null) {
            throw new EntidadeNaoInformadaException("Agencia id");
        }
        if (conta.getPessoaId() == null) {
            throw new EntidadeNaoInformadaException("Pessoa id");
        }

        if (conta.getTipoConta() == null) {
            throw new EntidadeNaoInformadaException("Tipo Conta");
        }

        if (conta.getDigito() == null
                || conta.getDigito().isEmpty()
                || conta.getDigito().isBlank()) {
            throw new CampoNaoInformadoException("Digito");
        }

        if (conta.getNumero() == null
                || conta.getNumero().isEmpty()
                || conta.getNumero().isBlank()) {
            throw new CampoNaoInformadoException("Numero");
        }
        if (conta.getRegistroAcademico() == null
                || conta.getRegistroAcademico().isEmpty()
                || conta.getRegistroAcademico().isBlank()) {
            throw new CampoNaoInformadoException("RA");
        }

        if (!(conta.getDigito().length() == 10)) {
            throw new TamanhoCampoInvalidoException("Digito", 10);
        }
        if (!(conta.getNumero().length() == 10)) {
            throw new TamanhoCampoInvalidoException("Numero", 10);
        }
        if (!(conta.getRegistroAcademico().length() == 10)) {
            throw new TamanhoCampoInvalidoException("RA", 10);
        }
        if (conta.getSaldo() < 0) {
            throw new ValorNegativoException("Saldo ", 0 );
        }

    }
        public List<Conta> findAll() throws SQLException {
        
        ContaDAO contaDAO = new ContaDAO();
        List<Conta> resultado = contaDAO.findAll();
        
        return resultado;
        
    }
    
    public Conta findById(int id) throws SQLException, 
            TamanhoCampoInvalidoException, Exception {
        
        if (id <= 0)
            throw new TamanhoCampoInvalidoException("id", 1);
        
        ContaDAO contaDAO = new ContaDAO();
        
       Conta retorno = contaDAO.findById(id);
        
        if (retorno == null)
            throw new Exception("Não foi possivel encontrar um pais"
                    + " com o id: "+id+" informado");
        
        return retorno;
        
    }
    
    public void insert(Conta conta) throws SQLException, 
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException,
            ValorNegativoException {
        validar(conta);
        
        ContaDAO contaDAO = new ContaDAO();
        contaDAO.insert(conta);
        
    }
    
    public void update(Conta conta) throws SQLException, 
            EntidadeNaoInformadaException, 
            CampoNaoInformadoException, 
            TamanhoCampoInvalidoException,
            ValorNegativoException {
        validar(conta);
        
        ContaDAO contaDAO = new ContaDAO();
        contaDAO.update(conta);
    }
    
    public void delete(int id) throws SQLException {
        ContaDAO contaDAO = new ContaDAO();
        contaDAO.delete(id);
    }
    
}
