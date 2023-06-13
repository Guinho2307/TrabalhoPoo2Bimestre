/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeNaoInformadaException;
import br.unipar.central.exceptions.TamanhoCampoInvalidoException;
import br.unipar.central.models.Endereco;
import br.unipar.central.repositories.EnderecoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author muril
 */
public class EnderecoService {

    private void validar(Endereco endereco) throws
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {

        if (endereco == null) {
            throw new EntidadeNaoInformadaException("Endereco");
        }

        if (endereco.getCidade() == null) {
            throw new EntidadeNaoInformadaException("Cidade");
        }

        if (endereco.getBairro() == null
                || endereco.getBairro().isEmpty()
                || endereco.getBairro().isBlank()) {
            throw new CampoNaoInformadoException("Bairro");
        }

        if (endereco.getCep() == null
                || endereco.getCep().isEmpty()
                || endereco.getCep().isBlank()) {
            throw new CampoNaoInformadoException("Cep");
        }

        if (endereco.getComplemento() == null
                || endereco.getComplemento().isEmpty()
                || endereco.getComplemento().isBlank()) {
            throw new CampoNaoInformadoException("Complemento");
        }

        if (endereco.getLogradouro() == null
                || endereco.getLogradouro().isEmpty()
                || endereco.getLogradouro().isBlank()) {
            throw new CampoNaoInformadoException("Logradouro");
        }
        if (endereco.getNumero() == null
                || endereco.getNumero().isEmpty()
                || endereco.getNumero().isBlank()) {
            throw new CampoNaoInformadoException("Numero");
        }

        if (endereco.getRegistroAcademico() == null
                || endereco.getRegistroAcademico().isEmpty()
                || endereco.getRegistroAcademico().isBlank()) {
            throw new CampoNaoInformadoException("RA");

        }

        if (!(endereco.getBairro().length() == 60)) {
            throw new TamanhoCampoInvalidoException("Bairro", 60);
        }

        if (!(endereco.getCep().length() == 9)) {
            throw new TamanhoCampoInvalidoException("Cep", 9);
        }

        if (!(endereco.getComplemento().length() == 60)) {
            throw new TamanhoCampoInvalidoException("Complemento", 60);
        }

        if (!(endereco.getLogradouro().length() == 30)) {
            throw new TamanhoCampoInvalidoException("Logradouro", 30);
        }

        if (!(endereco.getNumero().length() == 4)) {
            throw new TamanhoCampoInvalidoException("Numero", 4);
        }

        if (!(endereco.getRegistroAcademico().length() == 10)) {
            throw new TamanhoCampoInvalidoException("RA", 10);
        }

    }
    public List<Endereco> findAll() throws SQLException {
        
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        List<Endereco> resultado =  enderecoDAO.findAll();
        
        return resultado;
        
    }
    
    public Endereco findById(int id) throws SQLException, 
            TamanhoCampoInvalidoException, Exception {
        
        if (id <= 0)
            throw new TamanhoCampoInvalidoException("id", 1);
        
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        
        Endereco retorno = enderecoDAO.findById(id);
        
        if (retorno == null)
            throw new Exception("Não foi possivel encontrar um pais"
                    + " com o id: "+id+" informado");
        
        return retorno;
        
    }
    
    public void insert(Endereco endereco) throws SQLException, 
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        validar(endereco);
        
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.insert(endereco);
        
    }
    
    public void update(Endereco endereco) throws SQLException, 
            EntidadeNaoInformadaException, 
            CampoNaoInformadoException, 
            TamanhoCampoInvalidoException {
        validar(endereco);
        
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.update(endereco);
    }
    
    public void delete(int id) throws SQLException {
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.delete(id);
    }
}
