/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.repositories;

import br.unipar.central.models.Agencia;
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
public class AgenciaDAO {

    private static final String INSERT
            = "INSERT INTO agencia (id, codigo, razaosocial,cnpj,ra, banco_id)"
            + "VALUES(?, ?, ?, ?, ? ,?)";

    private static final String FIND_ALL
            = "SELECT id, codigo, razaosocial, cnpj, ra, banco_id FROM agencia";

    private static final String FIND_BY_ID
            = "SELECT id, codigo, razaosocial,cnpj,ra, banco_id FROM agencia WHERE ID = ?";

    private static final String DELETE_BY_ID
            = "DELETE FROM agencia WHERE ID = ?";

    private static final String UPDATE
            = "UPDATE PAIS SET codigo = ?, razaosocial = ?, cnpj = ? , ra = ?, banco_id = ? "
            + "WHERE ID = ?";

    public List<Agencia> findAll() throws SQLException {

        ArrayList<Agencia> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            conn = new DatabaseUtils().getConnection();

            pstmt = conn.prepareStatement(FIND_ALL);

            rs = pstmt.executeQuery();

            while (rs.next()) {

                Agencia agencia = new Agencia();
                agencia.setIdAbst(rs.getInt("ID"));
                agencia.setCodigo(rs.getString("CODIGO"));
                agencia.setRazaoSocial(rs.getString("RAZAOSOCIAL"));
                agencia.setCnpj(rs.getString("CNPJ"));
                agencia.setIdBanco(new BancoDAO().findById(rs.getInt("BANCO_ID")));

                retorno.add(agencia);

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

    public Agencia findById(int id) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Agencia retorno = null;

        try {

            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new Agencia();
                retorno.setIdAbst(rs.getInt("ID"));
                retorno.setCodigo(rs.getString("CODIGO"));
                retorno.setRazaoSocial(rs.getString("RAZAOSOCIAL"));
                retorno.setCnpj(rs.getString("CNPJ"));
                retorno.setIdBanco(new BancoDAO().findById(rs.getInt("BANCO_ID")));
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

    public void insert(Agencia agencia) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, agencia.getIdAbst());
            pstmt.setString(2, agencia.getCodigo());
            pstmt.setString(3, agencia.getRazaoSocial());
            pstmt.setString(4, agencia.getRazaoSocial());
            pstmt.setString(5, agencia.getRegistroAcademico());
            pstmt.setInt(6, agencia.getIdBanco().getIdAbst());

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

    public void update(Agencia agencia) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setInt(1, agencia.getIdAbst());
            pstmt.setString(2, agencia.getCodigo());
            pstmt.setString(3, agencia.getRazaoSocial());
            pstmt.setString(4, agencia.getRazaoSocial());
            pstmt.setString(5, agencia.getRegistroAcademico());
            pstmt.setInt(6, agencia.getIdBanco().getIdAbst());

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
