/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.repositories;

import br.unipar.central.models.Telefone;
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
public class TelefoneDAO {

    private static final String INSERT
            = "INSERT INTO telefone(id, numero,operadora, ra)"
            + "VALUES(?, ?, ?, ?)";

    private static final String FIND_ALL
            = "SELECT id, numero,operadora, ra FROM telefone";

    private static final String FIND_BY_ID
            = "SELECT id, numero,operadora, ra FROM telefone WHERE ID = ?";

    private static final String DELETE_BY_ID
            = "DELETE FROM telefone WHERE ID = ?";

    private static final String UPDATE
            = "UPDATE telefone SET numero = ?, operadora = ?, ra = ? "
            + "WHERE ID = ?";

    public List<Telefone> findAll() throws SQLException {

        ArrayList<Telefone> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            conn = new DatabaseUtils().getConnection();

            pstmt = conn.prepareStatement(FIND_ALL);

            rs = pstmt.executeQuery();

            while (rs.next()) {

                Telefone telefone = new Telefone();
                telefone.setIdAbst(rs.getInt("ID"));
                telefone.setNumero(rs.getString("NUMERO"));
                telefone.setOperadora(rs.getString("OPERADORA"));
                telefone.setRegistroAcademico(rs.getString("RA"));

                retorno.add(telefone);

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

    public Telefone findById(int id) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Telefone retorno = null;

        try {

            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new Telefone();
                retorno.setIdAbst(rs.getInt("ID"));
                retorno.setNumero(rs.getString("NUMERO"));
                retorno.setOperadora(rs.getString("OPERADORA"));
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

    public void insert(Telefone telefone) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, telefone.getIdAbst());
            pstmt.setString(2, telefone.getNumero());
            pstmt.setString(3, telefone.getOperadora());
            pstmt.setString(4, telefone.getRegistroAcademico());

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

    public void update(Telefone telefone) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setInt(1, telefone.getIdAbst());
            pstmt.setString(2, telefone.getNumero());
            pstmt.setString(3, telefone.getOperadora());
            pstmt.setString(4, telefone.getRegistroAcademico());

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
