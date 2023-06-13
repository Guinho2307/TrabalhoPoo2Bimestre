/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeNaoInformadaException;
import br.unipar.central.exceptions.TamanhoCampoInvalidoException;
import br.unipar.central.models.PessoaJuridica;
import br.unipar.central.repositories.PessoaJuridicaDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author muril
 */
public class PessoaJuridicaService {

    private void validar(PessoaJuridica pessoaJuridica) throws
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {

        if (pessoaJuridica == null) {
            throw new EntidadeNaoInformadaException("Pais");
        }

        if (pessoaJuridica.getCnaePrincipal() == null
                || pessoaJuridica.getCnaePrincipal().isEmpty()
                || pessoaJuridica.getCnaePrincipal().isBlank()) {
            throw new CampoNaoInformadoException("Cnae Principal");
        }
        if (pessoaJuridica.getCnpj() == null
                || pessoaJuridica.getCnpj().isEmpty()
                || pessoaJuridica.getCnpj().isBlank()) {
            throw new CampoNaoInformadoException("Cnpj");
        }
        if (pessoaJuridica.getFantasia() == null
                || pessoaJuridica.getFantasia().isEmpty()
                || pessoaJuridica.getFantasia().isBlank()) {
            throw new CampoNaoInformadoException("Fantasia");
        }
        if (pessoaJuridica.getRazaoSocial() == null
                || pessoaJuridica.getRazaoSocial().isEmpty()
                || pessoaJuridica.getRazaoSocial().isBlank()) {
            throw new CampoNaoInformadoException("Razao Social");
        }
        if (pessoaJuridica.getRegistroAcademico() == null
                || pessoaJuridica.getRegistroAcademico().isEmpty()
                || pessoaJuridica.getRegistroAcademico().isBlank()) {
            throw new CampoNaoInformadoException("RA");
        }

        if (!(pessoaJuridica.getCnaePrincipal().length() == 30)) {
            throw new TamanhoCampoInvalidoException("Cnae Principal", 30);
        }
        if (!(pessoaJuridica.getCnpj().length() == 11)) {
            throw new TamanhoCampoInvalidoException("Cnpj", 11);
        }

        if (!(pessoaJuridica.getFantasia().length() == 30)) {
            throw new TamanhoCampoInvalidoException("Fantasia", 30);
        }

        if (!(pessoaJuridica.getRazaoSocial().length() == 30)) {
            throw new TamanhoCampoInvalidoException("Razao Social", 30);
        }
        if (!(pessoaJuridica.getRegistroAcademico().length() == 10)) {
            throw new TamanhoCampoInvalidoException("RA", 10);
        }

    }

    public List<PessoaJuridica> findAll() throws SQLException {

        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        List<PessoaJuridica> resultado = pessoaJuridicaDAO.findAll();

        return resultado;

    }

    public PessoaJuridica findById(int id) throws SQLException,
            TamanhoCampoInvalidoException, Exception {

        if (id <= 0) {
            throw new TamanhoCampoInvalidoException("id", 1);
        }

        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();

        PessoaJuridica retorno = pessoaJuridicaDAO.findById(id);

        if (retorno == null) {
            throw new Exception("Não foi possivel encontrar um pais"
                    + " com o id: " + id + " informado");
        }

        return retorno;

    }

    public void insert(PessoaJuridica pessoaJuridica) throws SQLException,
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        validar(pessoaJuridica);

        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        pessoaJuridicaDAO.insert(pessoaJuridica);

    }

    public void update(PessoaJuridica pessoaJuridica) throws SQLException,
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        validar(pessoaJuridica);

        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        pessoaJuridicaDAO.update(pessoaJuridica);
    }

    public void delete(int id) throws SQLException {
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        pessoaJuridicaDAO.delete(id);
    }
}
