/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeNaoInformadaException;
import br.unipar.central.exceptions.TamanhoCampoInvalidoException;
import br.unipar.central.exceptions.ValorNegativoException;
import br.unipar.central.models.Transacao;
import br.unipar.central.repositories.TransacaoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author muril
 */
public class TransacaoService {

    private void validar(Transacao transacao) throws
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException,
            ValorNegativoException {

        if (transacao == null) {
            throw new EntidadeNaoInformadaException("Transação");
        }
        if (transacao.getContaDestino() == null) {
            throw new EntidadeNaoInformadaException("Conta Destino");
        }
        if (transacao.getContaOrigem() == null) {
            throw new EntidadeNaoInformadaException("Conta Origem");
        }
        if (transacao.getDataHora() == null) {
            throw new EntidadeNaoInformadaException("Data Transação");
        }

        if (transacao.getTipoTransacao() == null) {
            throw new EntidadeNaoInformadaException("Tipo Transação");
        }

        if (transacao.getRegistroAcademico() == null
                || transacao.getRegistroAcademico().isEmpty()
                || transacao.getRegistroAcademico().isBlank()) {
            throw new CampoNaoInformadoException("RA");
        }

        if (transacao.getRegistroAcademico().length() > 10) {
            throw new TamanhoCampoInvalidoException("RA", 10);
        }

        if (transacao.getValor() < 0) {
            throw new ValorNegativoException(" Valor ", 0);
        }
    }

    public List<Transacao> findAll() throws SQLException {

        TransacaoDAO transacaoDAO = new TransacaoDAO();
        List<Transacao> resultado = transacaoDAO.findAll();

        return resultado;

    }

    public Transacao findById(int id) throws SQLException,
            TamanhoCampoInvalidoException, Exception {

        if (id <= 0) {
            throw new TamanhoCampoInvalidoException("id", 1);
        }

        TransacaoDAO transacaoDAO = new TransacaoDAO();

        Transacao retorno = transacaoDAO.findById(id);

        if (retorno == null) {
            throw new Exception("Não foi possivel encontrar um pais"
                    + " com o id: " + id + " informado");
        }

        return retorno;

    }

    public void insert(Transacao transacao) throws SQLException,
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException,
            ValorNegativoException {
        validar(transacao);

        TransacaoDAO transacaoDAO = new TransacaoDAO();
        transacaoDAO.insert(transacao);

    }

    public void update(Transacao transacao) throws SQLException,
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException,
            ValorNegativoException {
        validar(transacao);

        TransacaoDAO transacaoDAO = new TransacaoDAO();
        transacaoDAO.update(transacao);
    }

    public void delete(int id) throws SQLException {


        TransacaoDAO transacaoDAO = new TransacaoDAO();
        transacaoDAO.delete(id);
    }

}
