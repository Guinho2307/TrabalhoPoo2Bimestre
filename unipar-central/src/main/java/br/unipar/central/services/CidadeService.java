/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeNaoInformadaException;
import br.unipar.central.exceptions.TamanhoCampoInvalidoException;
import br.unipar.central.models.Cidade;
import br.unipar.central.repositories.CidadeDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author muril
 */
public class CidadeService {

    private void validar(Cidade cidade) throws
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {

        if (cidade == null) {
            throw new EntidadeNaoInformadaException("Cidade");
        }

        if (cidade.getNome() == null
                || cidade.getNome().isEmpty()
                || cidade.getNome().isBlank()) {
            throw new CampoNaoInformadoException("Nome");
        }

        if (cidade.getSigla() == null
                || cidade.getSigla().isEmpty()
                || cidade.getSigla().isBlank()) {
            throw new CampoNaoInformadoException("Sigla");
        }

        if (!(cidade.getSigla().length() == 2)) {
            throw new TamanhoCampoInvalidoException("Sigla", 2);
        }

        if (cidade.getNome().length() > 60) {
            throw new TamanhoCampoInvalidoException("Nome", 60);
        }

    }
    
    public List<Cidade> findAll() throws SQLException {
        
        CidadeDAO cidadeDAO = new CidadeDAO();
        List<Cidade> resultado =  cidadeDAO.findAll();
        
        return resultado;
        
    }
    
    public Cidade findById(int id) throws SQLException, 
            TamanhoCampoInvalidoException, Exception {
        
        if (id <= 0)
            throw new TamanhoCampoInvalidoException("id", 1);
        
        CidadeDAO cidadeDAO = new CidadeDAO();
        
        Cidade retorno = cidadeDAO.findById(id);
        
        if (retorno == null)
            throw new Exception("Não foi possivel encontrar um pais"
                    + " com o id: "+id+" informado");
        
        return retorno;
        
    }
    
    public void insert(Cidade cidade) throws SQLException, 
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        validar(cidade);
        
        CidadeDAO cidadeDAO = new CidadeDAO();
        cidadeDAO.insert(cidade);
        
    }
    
    public void update(Cidade cidade) throws SQLException, 
            EntidadeNaoInformadaException, 
            CampoNaoInformadoException, 
            TamanhoCampoInvalidoException {
        validar(cidade);
        CidadeDAO cidadeDAO = new CidadeDAO();
        cidadeDAO.update(cidade);
    }
    
    public void delete(int id) throws SQLException {
        CidadeDAO cidadeDAO = new CidadeDAO();
        cidadeDAO.delete(id);
    }
}
