/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.central.models;

/**
 *
 * @author muril
 */
public class PessoaJuridica extends AbstractBaseEntity {
    
    private int id;
    private String RazaoSocial;
    private String cnpj;
    private String CnaePrincipal;
    private String Fantasia;
    private Pessoa PessoaId;

    public PessoaJuridica() {
    }

    public PessoaJuridica(int id, String RazaoSocial, String cnpj, String CnaePrincipal, String Fantasia, Pessoa PessoaId, int idAbst, String registroAcademico) {
        super(idAbst, registroAcademico);
        this.id = id;
        this.RazaoSocial = RazaoSocial;
        this.cnpj = cnpj;
        this.CnaePrincipal = CnaePrincipal;
        this.Fantasia = Fantasia;
        this.PessoaId = PessoaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCnaePrincipal() {
        return CnaePrincipal;
    }

    public void setCnaePrincipal(String CnaePrincipal) {
        this.CnaePrincipal = CnaePrincipal;
    }

    public String getFantasia() {
        return Fantasia;
    }

    public void setFantasia(String Fantasia) {
        this.Fantasia = Fantasia;
    }

    public Pessoa getPessoaId() {
        return PessoaId;
    }

    public void setPessoaId(Pessoa PessoaId) {
        this.PessoaId = PessoaId;
    }

    @Override
    public String toString() {
        return "PessoaJuridica{" + "id=" + id + ", RazaoSocial=" + RazaoSocial + ", cnpj=" + cnpj + ", CnaePrincipal=" + CnaePrincipal + ", Fantasia=" + Fantasia + ", PessoaId=" + PessoaId + '}';
    }
    
    
    
    
    
}
