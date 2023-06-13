/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.repositories;

import br.unipar.central.enums.TipoTransacaoEnum;
import br.unipar.central.models.Transacao;
import br.unipar.central.utils.DatabaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author muril
 */
public class TransacaoDAO {

    private static final String INSERT
            = "INSERT INTO transacao(id, datahora, valor, tipo, contaorigem, contadestino, ra)"
            + "VALUES(?, ?, ?, ?, ?, ?, ?)";

    private static final String FIND_ALL
            = "SELECT id, datahora, valor, tipo, contaorigem, contadestino, ra FROM transacao";

    private static final String FIND_BY_ID
            = "SELECT id, datahora, valor, tipo, contaorigem, contadestino, ra transacao WHERE ID = ?";

    private static final String DELETE_BY_ID
            = "DELETE FROM transacao WHERE ID = ?";

    private static final String UPDATE
            = "UPDATE transacao SET datahora = ?, valor = ?, tipo = ?, contaorigem = ?, contadestino = ?, ra = ? "
            + "WHERE ID = ?";

    public List<Transacao> findAll() throws SQLException {

        ArrayList<Transacao> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            conn = new DatabaseUtils().getConnection();

            pstmt = conn.prepareStatement(FIND_ALL);

            rs = pstmt.executeQuery();

            while (rs.next()) {

                Transacao transacao = new Transacao();
                transacao.setIdAbst(rs.getInt("ID"));
                transacao.setDataHora(rs.getDate("DATAHORA"));
                transacao.setValor(rs.getDouble("VALOR"));
                transacao.setTipoTransacao(TipoTransacaoEnum.valueOf("TIPO"));
                transacao.setContaOrigem(new ContaDAO().findById(rs.getInt("CONTAORIGEM")));
                transacao.setContaDestino(new ContaDAO().findById(rs.getInt("CONTADESTINO")));
                transacao.setRegistroAcademico(rs.getString("RA"));

                retorno.add(transacao);

            }

        } finally {

            if (rs != null) {
                rs.close();
            }

            if (pstmt != null) {
                pstmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        }

        return retorno;

    }

    public Transacao findById(int id) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Transacao retorno = null;

        try {

            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new Transacao();
                retorno.setIdAbst(rs.getInt("ID"));
                retorno.setDataHora(rs.getDate("DATAHORA"));
                retorno.setValor(rs.getDouble("VALOR"));
                retorno.setTipoTransacao(TipoTransacaoEnum.valueOf("TIPO"));
                retorno.setContaOrigem(new ContaDAO().findById(rs.getInt("CONTAORIGEM")));
                retorno.setContaDestino(new ContaDAO().findById(rs.getInt("CONTADESTINO")));
                retorno.setRegistroAcademico(rs.getString("RA"));
            }
        } finally {

            if (rs != null) {
                rs.close();
            }

            if (pstmt != null) {
                pstmt.close();
            }

            if (conn != null) {
                conn.close();
            }

        }

        return retorno;

    }

    public void insert(Transacao transacao) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, transacao.getIdAbst());
            pstmt.setDate(2, transacao.getDataHora());
            pstmt.setDouble(3, transacao.getValor());
            pstmt.setObject(4, transacao.getTipoTransacao());
            pstmt.setInt(5, transacao.getContaOrigem().getIdAbst());
            pstmt.setInt(6, transacao.getContaDestino().getIdAbst());
            pstmt.setString(7, transacao.getRegistroAcademico());

            pstmt.executeUpdate();

        } finally {
            if (pstmt != null) {
                pstmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        }

    }

    public void update(Transacao transacao) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);

            pstmt.setInt(1, transacao.getIdAbst());
            pstmt.setDate(2, transacao.getDataHora());
            pstmt.setDouble(3, transacao.getValor());
            pstmt.setObject(4, transacao.getTipoTransacao());
            pstmt.setInt(5, transacao.getContaOrigem().getIdAbst());
            pstmt.setInt(6, transacao.getContaDestino().getIdAbst());
            pstmt.setString(7, transacao.getRegistroAcademico());

            pstmt.executeUpdate();

        } finally {

            if (pstmt != null) {
                pstmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        }

    }

    public void delete(int id) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(DELETE_BY_ID);
            pstmt.setInt(1, id);

            pstmt.executeUpdate();

        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }
}
