/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.repositories;

import br.unipar.central.models.PessoaJuridica;
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
public class PessoaJuridicaDAO {

    private static final String INSERT
            = "INSERT INTO pessoajuridica(id, razaosocial, cnpj,cnaeprincipal,fantasia,pessoa_id, ra)"
            + "VALUES(?, ?, ?, ?,?, ?, ?)";

    private static final String FIND_ALL
            = "SELECT pessoajuridica(id, razaosocial, cnpj,cnaeprincipal,fantasia,pessoa_id, ra FROM pessoajuridica";

    private static final String FIND_BY_ID
            = "SELECT pessoajuridica(id, razaosocial, cnpj,cnaeprincipal,fantasia,pessoa_id, ra FROM pessoajuridica WHERE ID = ?";

    private static final String DELETE_BY_ID
            = "DELETE FROM pessoajuridica WHERE ID = ?";

    private static final String UPDATE
            = "UPDATE pessoajuridica SET razaosocial = ?, cnpj = ?, cnaeprincipal = ?, fatansia = ?, pessoa_id = ?, ra = ? "
            + "WHERE ID = ?";

    public List<PessoaJuridica> findAll() throws SQLException {

        ArrayList<PessoaJuridica> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            conn = new DatabaseUtils().getConnection();

            pstmt = conn.prepareStatement(FIND_ALL);

            rs = pstmt.executeQuery();

            while (rs.next()) {

                PessoaJuridica pessoaJuridica = new PessoaJuridica();
                pessoaJuridica.setIdAbst(rs.getInt("ID"));
                pessoaJuridica.setRazaoSocial(rs.getString("RAZAOSOCIAL"));
                pessoaJuridica.setCnpj(rs.getString("CNPJ"));
                pessoaJuridica.setCnaePrincipal(rs.getString("CNAEPRINCIPAL"));
                pessoaJuridica.setFantasia(rs.getString("FANTASIA"));
                pessoaJuridica.setPessoaId(new PessoaDAO().findById(rs.getInt("PESSOA_ID")));
                pessoaJuridica.setRegistroAcademico(rs.getString("RA"));

                retorno.add(pessoaJuridica);

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

    public PessoaJuridica findById(int id) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        PessoaJuridica retorno = null;

        try {

            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new PessoaJuridica();
                retorno.setIdAbst(rs.getInt("ID"));
                retorno.setRazaoSocial(rs.getString("RAZAOSOCIAL"));
                retorno.setCnpj(rs.getString("CNPJ"));
                retorno.setCnaePrincipal(rs.getString("CNAEPRINCIPAL"));
                retorno.setFantasia(rs.getString("FANTASIA"));
                retorno.setPessoaId(new PessoaDAO().findById(rs.getInt("PESSOA_ID")));
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

    public void insert(PessoaJuridica pessoaJuridica) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, pessoaJuridica.getIdAbst());
            pstmt.setString(2, pessoaJuridica.getRazaoSocial());
            pstmt.setString(3, pessoaJuridica.getCnpj());
            pstmt.setString(4, pessoaJuridica.getCnaePrincipal());
            pstmt.setString(5, pessoaJuridica.getFantasia());
            pstmt.setInt(6, pessoaJuridica.getPessoaId().getIdAbst());
            pstmt.setString(7, pessoaJuridica.getRegistroAcademico());

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

    public void update(PessoaJuridica pessoaJuridica) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setInt(1, pessoaJuridica.getIdAbst());
            pstmt.setString(2, pessoaJuridica.getRazaoSocial());
            pstmt.setString(3, pessoaJuridica.getCnpj());
            pstmt.setString(4, pessoaJuridica.getCnaePrincipal());
            pstmt.setString(5, pessoaJuridica.getFantasia());
            pstmt.setInt(6, pessoaJuridica.getPessoaId().getIdAbst());
            pstmt.setString(7, pessoaJuridica.getRegistroAcademico());

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
