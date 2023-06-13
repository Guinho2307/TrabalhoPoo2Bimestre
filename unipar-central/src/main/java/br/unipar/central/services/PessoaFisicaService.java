/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeNaoInformadaException;
import br.unipar.central.exceptions.TamanhoCampoInvalidoException;
import br.unipar.central.models.PessoaFisica;
import br.unipar.central.repositories.PessoaFisicaDAO;
import java.sql.SQLException;
import java.util.List;

public class PessoaFisicaService {

    private void validar(PessoaFisica pessoaFisica) throws
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {

        if (pessoaFisica == null) {
            throw new EntidadeNaoInformadaException("Pessoa Fisica");
        }

        if (pessoaFisica.getDataNasc() == null) {
            throw new EntidadeNaoInformadaException("Data de Nascimento");
        }
        if (pessoaFisica.getPessoaId() == null) {
            throw new EntidadeNaoInformadaException("Pessoa id");
        }

        if (pessoaFisica.getNome() == null
                || pessoaFisica.getNome().isEmpty()
                || pessoaFisica.getNome().isBlank()) {
            throw new CampoNaoInformadoException("Nome");
        }
        if (pessoaFisica.getRegistroAcademico() == null
                || pessoaFisica.getRegistroAcademico().isEmpty()
                || pessoaFisica.getRegistroAcademico().isBlank()) {
            throw new CampoNaoInformadoException("RA");
        }
        if (pessoaFisica.getRg() == null
                || pessoaFisica.getRg().isEmpty()
                || pessoaFisica.getRg().isBlank()) {
            throw new CampoNaoInformadoException("Rg");
        }
        if (pessoaFisica.getCpf() == null
                || pessoaFisica.getCpf().isEmpty()
                || pessoaFisica.getCpf().isBlank()) {
            throw new CampoNaoInformadoException("Cpf");
        }

        if (!(pessoaFisica.getCpf().length() == 15)) {
            throw new TamanhoCampoInvalidoException("Cpf", 15);
        }
        if (!(pessoaFisica.getNome().length() == 60)) {
            throw new TamanhoCampoInvalidoException("Nome", 60);
        }
        if (!(pessoaFisica.getRegistroAcademico().length() == 10)) {
            throw new TamanhoCampoInvalidoException("RA", 10);
        }
        if (!(pessoaFisica.getRg().length() == 7)) {
            throw new TamanhoCampoInvalidoException("Rg", 10);
        }

    }

    public List<PessoaFisica> findAll() throws SQLException {

        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        List<PessoaFisica> resultado = pessoaFisicaDAO.findAll();

        return resultado;

    }

    public PessoaFisica findById(int id) throws SQLException,
            TamanhoCampoInvalidoException, Exception {

        if (id <= 0) {
            throw new TamanhoCampoInvalidoException("id", 1);
        }

        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();

        PessoaFisica retorno = pessoaFisicaDAO.findById(id);

        if (retorno == null) {
            throw new Exception("Não foi possivel encontrar um pais"
                    + " com o id: " + id + " informado");
        }

        return retorno;

    }

    public void insert(PessoaFisica pessoaFisica) throws SQLException,
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        validar(pessoaFisica);

        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        pessoaFisicaDAO.insert(pessoaFisica);

    }

    public void update(PessoaFisica pessoaFisica) throws SQLException,
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        validar(pessoaFisica);
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        pessoaFisicaDAO.update(pessoaFisica);
    }

    public void delete(int id) throws SQLException {
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        pessoaFisicaDAO.delete(id);
    }

}
