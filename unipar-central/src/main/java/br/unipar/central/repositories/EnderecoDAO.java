/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.repositories;

import br.unipar.central.models.Endereco;
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
public class EnderecoDAO {

    private static final String INSERT
            = "INSERT INTO endereco(id, logradouro, numero, bairro ,cep, complemento, cidade, ra)"
            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String FIND_ALL
            = "SELECT id, logradouro, numero, bairro ,cep, complemento, cidade, ra FROM endereco";

    private static final String FIND_BY_ID
            = "SELECT id, logradouro, numero, bairro ,cep, complemento, cidade, ra FROM endereco WHERE ID = ?";

    private static final String DELETE_BY_ID
            = "DELETE FROM endereco WHERE ID = ?";

    private static final String UPDATE
            = "UPDATE endreco SET logradouro= ?, numero = ?, bairro = ?, cep = ?, complemento = ?, cidade = ?, ra = ? "
            + "WHERE ID = ?";

    public List<Endereco> findAll() throws SQLException {

        ArrayList<Endereco> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            conn = new DatabaseUtils().getConnection();

            pstmt = conn.prepareStatement(FIND_ALL);

            rs = pstmt.executeQuery();

            while (rs.next()) {

                Endereco endereco = new Endereco();
                endereco.setIdAbst(rs.getInt("ID"));
                endereco.setLogradouro(rs.getString("LOGRADOURO"));
                endereco.setNumero(rs.getString("NUMERO"));
                endereco.setBairro(rs.getString("BAIRRO"));
                endereco.setCep(rs.getString("CEP"));
                endereco.setComplemento(rs.getString("COMPLEMENTO"));
                endereco.setCidade(new CidadeDAO().findById(rs.getInt("ESTADO_ID")));
                endereco.setRegistroAcademico(rs.getString("RA"));

                retorno.add(endereco);

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

    public Endereco findById(int id) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Endereco retorno = null;

        try {

            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new Endereco();
                retorno.setIdAbst(rs.getInt("ID"));
                retorno.setLogradouro(rs.getString("LOGRADOURO"));
                retorno.setNumero(rs.getString("NUMERO"));
                retorno.setBairro(rs.getString("BAIRRO"));
                retorno.setCep(rs.getString("CEP"));
                retorno.setComplemento(rs.getString("COMPLEMENTO"));
                retorno.setCidade(new CidadeDAO().findById(rs.getInt("ESTADO_ID")));
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

    public void insert(Endereco endereco) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, endereco.getIdAbst());
            pstmt.setString(2, endereco.getLogradouro());
            pstmt.setString(3, endereco.getNumero());
            pstmt.setString(4, endereco.getBairro());
            pstmt.setString(5, endereco.getCep());
            pstmt.setString(6, endereco.getComplemento());
            pstmt.setInt(7, endereco.getCidade().getIdAbst());
            pstmt.setString(8, endereco.getRegistroAcademico());

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

    public void update(Endereco endereco) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setInt(1, endereco.getIdAbst());
            pstmt.setString(2, endereco.getLogradouro());
            pstmt.setString(3, endereco.getNumero());
            pstmt.setString(4, endereco.getBairro());
            pstmt.setString(5, endereco.getCep());
            pstmt.setString(6, endereco.getComplemento());
            pstmt.setInt(7, endereco.getCidade().getIdAbst());
            pstmt.setString(8, endereco.getRegistroAcademico());

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
