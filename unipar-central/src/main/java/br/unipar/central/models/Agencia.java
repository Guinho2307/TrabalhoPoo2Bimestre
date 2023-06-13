/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.models;

/**
 *
 * @author muril
 */
public class Agencia extends AbstractBaseEntity{
    
    private int id;
    private String codigo ;
    private String RazaoSocial;
    private String cnpj;
    private Banco idBanco;

    public Agencia() {
    }


    public Agencia(int id, String codigo, String RazaoSocial, String cnpj, Banco idBanco, int idAbst, String registroAcademico) {
        super(idAbst, registroAcademico);
        this.id = id;
        this.codigo = codigo;
        this.RazaoSocial = RazaoSocial;
        this.cnpj = cnpj;
        this.idBanco = idBanco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getRazaoSocial() {
        return RazaoSocial;
    }

    public void setRazaoSocial(String RazaoSocial) {
        this.RazaoSocial = RazaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Banco getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(Banco idBanco) {
        this.idBanco = idBanco;
    }

    @Override
    public String toString() {
        return "Agencia{" + "id=" + id + ", codigo=" + codigo + ", RazaoSocial=" + RazaoSocial + ", cnpj=" + cnpj + ", idBanco=" + idBanco + '}';
    }
    
    
    
    
}
