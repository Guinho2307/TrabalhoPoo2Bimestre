/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeNaoInformadaException;
import br.unipar.central.exceptions.TamanhoCampoInvalidoException;
import br.unipar.central.models.Estado;
import br.unipar.central.repositories.EstadoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author muril
 */
public class EstadoService {

    private void validar(Estado estado) throws
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {

        if (estado == null) {
            throw new EntidadeNaoInformadaException("Estado");
        }

        if (estado.getNome() == null
                || estado.getNome().isEmpty()
                || estado.getNome().isBlank()) {
            throw new CampoNaoInformadoException("Nome");
        }

        if (estado.getSigla() == null
                || estado.getSigla().isEmpty()
                || estado.getSigla().isBlank()) {
            throw new CampoNaoInformadoException("Sigla");
        }

        if (!(estado.getSigla().length() == 2)) {
            throw new TamanhoCampoInvalidoException("Sigla", 2);
        }

        if (estado.getNome().length() > 60) {
            throw new TamanhoCampoInvalidoException("Nome", 60);
        }

    }
    
        public List<Estado> findAll() throws SQLException {
        
        EstadoDAO estadoDAO = new EstadoDAO();
        List<Estado> resultado =  estadoDAO.findAll();
        
        return resultado;
        
    }
    
    public Estado findById(int id) throws SQLException, 
            TamanhoCampoInvalidoException, Exception {
        
        if (id <= 0)
            throw new TamanhoCampoInvalidoException("id", 1);
        
       EstadoDAO estadoDAO = new EstadoDAO();
        
        Estado retorno = estadoDAO.findById(id);
        
        if (retorno == null)
            throw new Exception("Não foi possivel encontrar um pais"
                    + " com o id: "+id+" informado");
        
        return retorno;
        
    }

    public void insert(Estado estado) throws SQLException,
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        validar(estado);

        EstadoDAO estadoDAO = new EstadoDAO();
        estadoDAO.insert(estado);

    }

    public void update(Estado estado) throws SQLException,
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        validar(estado);
         EstadoDAO estadoDAO = new EstadoDAO();
        estadoDAO.update(estado);
    }

    public void delete(int id) throws SQLException {
         EstadoDAO estadoDAO = new EstadoDAO();
        estadoDAO.delete(id);
    }
    
    
}
