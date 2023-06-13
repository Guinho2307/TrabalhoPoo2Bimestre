/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeNaoInformadaException;
import br.unipar.central.exceptions.TamanhoCampoInvalidoException;
import br.unipar.central.models.Banco;
import br.unipar.central.repositories.BancoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author muril
 */
public class BancoService {

    private void validar(Banco banco) throws
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {

        if (banco == null) {
            throw new EntidadeNaoInformadaException("Banco");
        }

        if (banco.getNome() == null
                || banco.getNome().isEmpty()
                || banco.getNome().isBlank()) {
            throw new CampoNaoInformadoException("Nome");
        }
        if (banco.getRegistroAcademico() == null
                || banco.getRegistroAcademico().isEmpty()
                || banco.getRegistroAcademico().isBlank()) {
            throw new CampoNaoInformadoException("RA");
        }

        if (!(banco.getNome().length() == 60)) {
            throw new TamanhoCampoInvalidoException("Nome", 60);
        }
        if (!(banco.getRegistroAcademico().length() == 10)) {
            throw new TamanhoCampoInvalidoException("RA", 10);
        }

    }
    public List<Banco> findAll() throws SQLException {
        
        BancoDAO bancoDAO = new BancoDAO();
        List<Banco> resultado =  bancoDAO.findAll();
        
        return resultado;
        
    }
    
    public Banco findById(int id) throws SQLException, 
            TamanhoCampoInvalidoException, Exception {
        
        if (id <= 0)
            throw new TamanhoCampoInvalidoException("id", 1);
        
        BancoDAO bancoDAO = new BancoDAO();
        
        Banco retorno = bancoDAO.findById(id);
        
        if (retorno == null)
            throw new Exception("Não foi possivel encontrar um pais"
                    + " com o id: "+id+" informado");
        
        return retorno;
        
    }
    
    public void insert(Banco banco) throws SQLException, 
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        validar(banco);
        
        BancoDAO bancoDAO = new BancoDAO();
        bancoDAO.insert(banco);
        
    }
    
    public void update(Banco banco) throws SQLException, 
            EntidadeNaoInformadaException, 
            CampoNaoInformadoException, 
            TamanhoCampoInvalidoException {
        validar(banco);
        BancoDAO bancoDAO = new BancoDAO();
        bancoDAO.update(banco);
    }
    
    public void delete(int id) throws SQLException {
        BancoDAO bancoDAO = new BancoDAO();
        bancoDAO.delete(id);
    }
}
