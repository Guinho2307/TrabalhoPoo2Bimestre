/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeNaoInformadaException;
import br.unipar.central.exceptions.TamanhoCampoInvalidoException;
import br.unipar.central.models.Pais;
import br.unipar.central.models.Pessoa;
import br.unipar.central.repositories.PaisDAO;
import br.unipar.central.repositories.PessoaDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author muril
 */
public class PessoaService {

    private void validar(Pessoa pessoa) throws
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {

        if (pessoa == null) {
            throw new EntidadeNaoInformadaException("Pessoa");
        }
        if (pessoa.getEnderecos() == null) {
            throw new EntidadeNaoInformadaException("Endereços");
        }
        if (pessoa.getTelefones() == null) {
            throw new EntidadeNaoInformadaException("Telefones");
        }

        if (pessoa.getEmail() == null
                || pessoa.getEmail().isEmpty()
                || pessoa.getEmail().isBlank()) {
            throw new CampoNaoInformadoException("Email");
        }

        if (pessoa.getRegistroAcademico() == null
                || pessoa.getRegistroAcademico().isEmpty()
                || pessoa.getRegistroAcademico().isBlank()) {
            throw new CampoNaoInformadoException("RA");
        }

        if (!(pessoa.getEmail().length() == 60)) {
            throw new TamanhoCampoInvalidoException("Email", 60);
        }
        if (!(pessoa.getRegistroAcademico().length() == 10)) {
            throw new TamanhoCampoInvalidoException("RA", 10);
        }

    }
    public List<Pessoa> findAll() throws SQLException {
        
        PessoaDAO pessoaDAO = new PessoaDAO();
        List<Pessoa> resultado =  pessoaDAO.findAll();
        
        return resultado;
        
    }
    
    public Pessoa findById(int id) throws SQLException, 
            TamanhoCampoInvalidoException, Exception {
        
        if (id <= 0)
            throw new TamanhoCampoInvalidoException("id", 1);
        
        PessoaDAO pessoaDAO = new PessoaDAO();
        
        Pessoa retorno = pessoaDAO.findById(id);
        
        if (retorno == null)
            throw new Exception("Não foi possivel encontrar um pais"
                    + " com o id: "+id+" informado");
        
        return retorno;
        
    }
    
    public void insert(Pessoa pessoa) throws SQLException, 
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        validar(pessoa);
        
        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.insert(pessoa);
        
    }
    
    public void update(Pessoa pessoa) throws SQLException, 
            EntidadeNaoInformadaException, 
            CampoNaoInformadoException, 
            TamanhoCampoInvalidoException {
        validar(pessoa);
        
        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.update(pessoa);
    }
    
    public void delete(int id) throws SQLException {
        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.delete(id);
    }
}
