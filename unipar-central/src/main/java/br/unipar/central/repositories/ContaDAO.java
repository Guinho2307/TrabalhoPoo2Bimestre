/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.repositories;

import br.unipar.central.enums.TipoContaEnum;
import br.unipar.central.models.Conta;
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
public class ContaDAO {

    private static final String INSERT
            = "INSERT INTO conta(id, numero, digito,saldo,agencia_id, pessoa_id, tipo ,ra)"
            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String FIND_ALL
            = "SELECT id, numero, digito,saldo,agencia_id, pessoa_id, tipo ,ra FROM conta";

    private static final String FIND_BY_ID
            = "SELECT id, numero, digito,saldo,agencia_id, pessoa_id, tipo ,ra FROM conta WHERE ID = ?";

    private static final String DELETE_BY_ID
            = "DELETE FROM conta WHERE ID = ?";

    private static final String UPDATE
            = "UPDATE conta SET numero = ?, digto = ?, saldo = ?, agencia_id = ?, pessoa_id = ?, tipo = ?, ra = ? "
            + "WHERE ID = ?";

    public List<Conta> findAll() throws SQLException {

        ArrayList<Conta> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            conn = new DatabaseUtils().getConnection();

            pstmt = conn.prepareStatement(FIND_ALL);

            rs = pstmt.executeQuery();

            while (rs.next()) {

                Conta conta = new Conta();
                conta.setIdAbst(rs.getInt("ID"));
                conta.setNumero(rs.getString("NUMERO"));
                conta.setDigito(rs.getString("DIGITO"));
                conta.setSaldo(rs.getDouble("SALDO"));
                conta.setAgenciaId(new AgenciaDAO().findById(rs.getInt("AGENCIA_ID")));
                conta.setPessoaId(new PessoaDAO().findById(rs.getInt("PESSOA_ID")));
                conta.setTipoConta(TipoContaEnum.valueOf("TIPO"));
                conta.setRegistroAcademico(rs.getString("RA"));

                retorno.add(conta);

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

    public Conta findById(int id) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Conta retorno = null;

        try {

            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new Conta();
                retorno.setIdAbst(rs.getInt("ID"));
                retorno.setNumero(rs.getString("NUMERO"));
                retorno.setDigito(rs.getString("DIGITO"));
                retorno.setSaldo(rs.getDouble("SALDO"));
                 retorno.setAgenciaId(new AgenciaDAO().findById(rs.getInt("AGENCIA_ID")));
                retorno.setPessoaId(new PessoaDAO().findById(rs.getInt("PESSOA_ID")));
                retorno.setTipoConta(TipoContaEnum.valueOf("TIPO"));
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

    public void insert(Conta conta) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, conta.getIdAbst());
            pstmt.setString(2, conta.getNumero());
            pstmt.setString(3, conta.getDigito());
            pstmt.setDouble(4, conta.getSaldo());
            pstmt.setInt(5, conta.getAgenciaId().getIdAbst());
            pstmt.setInt(6, conta.getPessoaId().getIdAbst());
            pstmt.setObject(7, conta.getTipoConta());
            pstmt.setString(8, conta.getRegistroAcademico());

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

    public void update(Conta conta) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setInt(1, conta.getIdAbst());
            pstmt.setString(2, conta.getNumero());
            pstmt.setString(3, conta.getDigito());
            pstmt.setDouble(4, conta.getSaldo());
            pstmt.setInt(5, conta.getAgenciaId().getIdAbst());
            pstmt.setInt(6, conta.getPessoaId().getIdAbst());
            pstmt.setObject(7, conta.getTipoConta());
            pstmt.setString(8, conta.getRegistroAcademico());

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
