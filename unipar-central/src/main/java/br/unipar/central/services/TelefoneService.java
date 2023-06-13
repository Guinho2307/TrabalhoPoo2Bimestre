/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeNaoInformadaException;
import br.unipar.central.exceptions.TamanhoCampoInvalidoException;
import br.unipar.central.models.Telefone;
import br.unipar.central.repositories.TelefoneDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author muril
 */
public class TelefoneService {

    private void validar(Telefone telefone) throws
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {

        if (telefone == null) {
            throw new EntidadeNaoInformadaException("Telefone");
        }

        if (telefone.getNumero() == null
                || telefone.getNumero().isEmpty()
                || telefone.getNumero().isBlank()) {
            throw new CampoNaoInformadoException("Numero");
        }

        if (telefone.getOperadora() == null
                || telefone.getOperadora().isEmpty()
                || telefone.getOperadora().isBlank()) {
            throw new CampoNaoInformadoException("Operadora");
        }

        if (!(telefone.getNumero().length() == 14)) {
            throw new TamanhoCampoInvalidoException("Numero", 14);
        }

        if (!(telefone.getOperadora().length() == 20)) {
            throw new TamanhoCampoInvalidoException("Operadora", 20);
        }
    }
    public List<Telefone> findAll() throws SQLException {
        
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        List<Telefone> resultado = telefoneDAO.findAll();
        
        return resultado;
        
    }
    
    public Telefone findById(int id) throws SQLException, 
            TamanhoCampoInvalidoException, Exception {
        
        if (id <= 0)
            throw new TamanhoCampoInvalidoException("id", 1);
        
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        
        Telefone retorno = telefoneDAO.findById(id);
        
        if (retorno == null)
            throw new Exception("Não foi possivel encontrar um pais"
                    + " com o id: "+id+" informado");
        
        return retorno;
        
    }
    
    public void insert(Telefone telefone) throws SQLException, 
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        validar(telefone);
        
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        telefoneDAO.insert(telefone);
        
    }
    
    public void update(Telefone telefone) throws SQLException, 
            EntidadeNaoInformadaException, 
            CampoNaoInformadoException, 
            TamanhoCampoInvalidoException {
        validar(telefone);
        
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        telefoneDAO.update(telefone);
    }
    
    public void delete(int id) throws SQLException {
      
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        telefoneDAO.delete(id);
    }

}
