/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.repositories;


import br.unipar.central.models.Cidade;
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
public class CidadeDAO {

    private static final String INSERT
            = "INSERT INTO cidade (id, nome, ra, sigla, estado_id)"
            + "VALUES(?, ?, ?, ?)";

    private static final String FIND_ALL
            = "SELECT id, nome, ra,sigla, estado_id FROM cidade";

    private static final String FIND_BY_ID
            = "SELECT id, nome, ra, sigla,  estado_id FROM cidade WHERE ID = ?";

    private static final String DELETE_BY_ID
            = "DELETE FROM cidade WHERE ID = ?";

    private static final String UPDATE
            = "UPDATE cidade SET nome = ?,ra = ? , sigla = ?, estado_id = ? "
            + "WHERE ID = ?";
    
     public List<Cidade> findAll() throws SQLException {
        
        ArrayList<Cidade> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            
            conn = new DatabaseUtils().getConnection();
            
            pstmt = conn.prepareStatement(FIND_ALL);
            
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                
                Cidade cidade = new Cidade();
                cidade.setIdAbst(rs.getInt("ID"));
                cidade.setNome(rs.getString("NOME"));
                cidade.setRegistroAcademico(rs.getString("RA"));
                cidade.setSigla(rs.getString("SIGLA"));
                cidade.setEstado(new EstadoDAO().findById(rs.getInt("ESTADO_ID")));
                
                retorno.add(cidade);
                
            }
            
        } finally {
            
            if (rs != null)
                rs.close();
            
            if (pstmt != null)
                pstmt.close();
            
            if (conn != null) 
                conn.close();
        }
        
        return retorno;
        
    }
    
    public Cidade findById(int id) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Cidade retorno = null;
        
        try {
            
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
               retorno = new Cidade();
               retorno.setIdAbst(rs.getInt("ID"));
               retorno.setNome(rs.getString("NOME"));
               retorno.setRegistroAcademico( rs.getString("RA"));
               retorno.setSigla(rs.getString("SIGLA"));
               retorno.setEstado(new EstadoDAO().findById(rs.getInt("ESTADO_ID")));
            }
            
        } finally {
            
            if (rs != null)
                rs.close();
            
            if (pstmt != null)
                pstmt.close();
            
            if (conn != null)
                conn.close();
            
        }
        
        return retorno;
        
    }
    
    public void insert(Cidade cidade) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, cidade.getIdAbst());
            pstmt.setString(2, cidade.getNome());
            pstmt.setString(3, cidade.getSigla());
            pstmt.setString(4, cidade.getRegistroAcademico());
            pstmt.setInt(5, cidade.getEstado().getIdAbst());
            
            pstmt.executeUpdate();   
            
        } finally {
            if (pstmt != null)
                pstmt.close();
            
            if (conn != null)
                conn.close();
        }
        
    }
    
    public void update(Cidade cidade) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, cidade.getNome());
            pstmt.setString(2, cidade.getSigla());
            pstmt.setString(3, cidade.getRegistroAcademico());
            pstmt.setInt(4, cidade.getIdAbst());
            pstmt.setInt(5, cidade.getEstado().getIdAbst());
            
            pstmt.executeUpdate();
            
        } finally {
            
            if (pstmt != null)
                pstmt.close();
            
            if (conn != null)
                conn.close();
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
            if (pstmt != null)
                pstmt.close();
            if (conn != null)
                conn.close();
        }
    }
}
