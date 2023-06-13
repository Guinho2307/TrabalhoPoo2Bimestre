/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.repositories;

import br.unipar.central.models.PessoaFisica;
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
public class PessoaFisicaDAO {

    private static final String INSERT
            = "INSERT INTO pessoafisica(id, nome, cpf,rg,datanascimento,pessoa_id, ra)"
            + "VALUES(?, ?, ?, ?, ?, ?, ?)";

    private static final String FIND_ALL
            = "SELECT id, nome, cpf,rg,datanascimento,pessoa_id, ra FROM Ppessoafisca";

    private static final String FIND_BY_ID
            = "SELECT id, nome, cpf,rg,datanascimento,pessoa_id, ra FROM pessoafisica WHERE ID = ?";

    private static final String DELETE_BY_ID
            = "DELETE FROM pessoafsica WHERE ID = ?";

    private static final String UPDATE
            = "UPDATE pessoafsica SET nome = ?, cpf = ?, rg = ?, datanascimento = ?, pessoa_id = ?, ra = ? "
            + "WHERE ID = ?";

    public List<PessoaFisica> findAll() throws SQLException {

        ArrayList<PessoaFisica> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            conn = new DatabaseUtils().getConnection();

            pstmt = conn.prepareStatement(FIND_ALL);

            rs = pstmt.executeQuery();

            while (rs.next()) {

                PessoaFisica pessoaFisica = new PessoaFisica();
                pessoaFisica.setIdAbst(rs.getInt("ID"));
                pessoaFisica.setNome(rs.getString("NOME"));
                pessoaFisica.setCpf(rs.getString("CPF"));
                pessoaFisica.setRg(rs.getString("RG"));
                pessoaFisica.setDataNasc(rs.getDate("DATANASCIMENTO"));
                pessoaFisica.setPessoaId(new PessoaDAO().findById(rs.getInt("PESSOA_ID")));
                pessoaFisica.setRegistroAcademico(rs.getString("RA"));

                retorno.add(pessoaFisica);

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

    public PessoaFisica findById(int id) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        PessoaFisica retorno = null;

        try {

            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new PessoaFisica();
                retorno.setIdAbst(rs.getInt("ID"));
                retorno.setNome(rs.getString("NOME"));
                retorno.setCpf(rs.getString("CPF"));
                retorno.setRg(rs.getString("RG"));
                retorno.setDataNasc(rs.getDate("DATANASCIMENTO"));
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

    public void insert(PessoaFisica pessoaFisica) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, pessoaFisica.getIdAbst());
            pstmt.setString(2, pessoaFisica.getCpf());
            pstmt.setString(3, pessoaFisica.getRg());
            pstmt.setDate(4, pessoaFisica.getDataNasc());
            pstmt.setString(5, pessoaFisica.getRg());
            pstmt.setInt(6, pessoaFisica.getPessoaId().getIdAbst());
            pstmt.setString(7, pessoaFisica.getRegistroAcademico());

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

    public void update(PessoaFisica pessoaFisica) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setInt(1, pessoaFisica.getIdAbst());
            pstmt.setString(2, pessoaFisica.getCpf());
            pstmt.setString(3, pessoaFisica.getRg());
            pstmt.setDate(4, pessoaFisica.getDataNasc());
            pstmt.setString(5, pessoaFisica.getRg());
            pstmt.setInt(6, pessoaFisica.getPessoaId().getIdAbst());
            pstmt.setString(7, pessoaFisica.getRegistroAcademico());

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
