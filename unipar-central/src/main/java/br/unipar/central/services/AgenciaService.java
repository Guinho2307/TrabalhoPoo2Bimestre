/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeNaoInformadaException;
import br.unipar.central.exceptions.TamanhoCampoInvalidoException;
import br.unipar.central.models.Agencia;
import br.unipar.central.repositories.AgenciaDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author muril
 */
public class AgenciaService {

    private void validar(Agencia agencia) throws
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {

        if (agencia == null) {
            throw new EntidadeNaoInformadaException("Agencia");
        }

        if (agencia.getIdBanco() == null) {
            throw new EntidadeNaoInformadaException("Banco");
        }

        if (agencia.getCnpj() == null
                || agencia.getCnpj().isEmpty()
                || agencia.getCnpj().isBlank()) {
            throw new CampoNaoInformadoException("Cnpj");
        }

        if (agencia.getCodigo() == null
                || agencia.getCodigo().isEmpty()
                || agencia.getCodigo().isBlank()) {
            throw new CampoNaoInformadoException("Codigo");
        }
        if (agencia.getRazaoSocial() == null
                || agencia.getRazaoSocial().isEmpty()
                || agencia.getRegistroAcademico().isBlank()) {
            throw new CampoNaoInformadoException("Razão Social");
        }
        if (agencia.getRegistroAcademico() == null
                || agencia.getRegistroAcademico().isEmpty()
                || agencia.getRegistroAcademico().isBlank()) {
            throw new CampoNaoInformadoException("RA");
        }

        if (!(agencia.getCnpj().length() == 11)) {
            throw new TamanhoCampoInvalidoException("Cnpj", 11);
        }
        if (!(agencia.getCodigo().length() == 10)) {
            throw new TamanhoCampoInvalidoException("Codigo", 10);
        }
        if (!(agencia.getRazaoSocial().length() == 60)) {
            throw new TamanhoCampoInvalidoException("Razão Social", 60);
        }
        if (!(agencia.getRegistroAcademico().length() == 10)) {
            throw new TamanhoCampoInvalidoException("RA", 10);
        }

    }

    public List<Agencia> findAll() throws SQLException {

        AgenciaDAO agenciaDAO = new AgenciaDAO();
        List<Agencia> resultado = agenciaDAO.findAll();

        return resultado;

    }

    public Agencia findById(int id) throws SQLException,
            TamanhoCampoInvalidoException, Exception {

        if (id <= 0) {
            throw new TamanhoCampoInvalidoException("id", 1);
        }

        AgenciaDAO agenciaDAO = new AgenciaDAO();

        Agencia retorno = agenciaDAO.findById(id);

        if (retorno == null) {
            throw new Exception("Não foi possivel encontrar um pais"
                    + " com o id: " + id + " informado");
        }

        return retorno;

    }

    public void insert(Agencia agencia) throws SQLException,
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        validar(agencia);

        AgenciaDAO agenciaDAO = new AgenciaDAO();
        agenciaDAO.insert(agencia);

    }

    public void update(Agencia agencia) throws SQLException,
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {
        validar(agencia);
        AgenciaDAO agenciaDAO = new AgenciaDAO();
        agenciaDAO.update(agencia);
    }

    public void delete(int id) throws SQLException {
        AgenciaDAO agenciaDAO = new AgenciaDAO();
        agenciaDAO.delete(id);
    }

}
