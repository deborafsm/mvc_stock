/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Debora Freire T.I JobHome
 */
public class model_operador {
    /*`id_operador`, `nome_operador`, 
`email_operador`, `tel`, `celular`, `endereco`, `cep`, 
`numero`, `complemento`, `referencia`, `bairro`, `cidade`, 
`estado`, `setor`, `cargo`, `status_operador`, `empresa`, 
`supervisor`*/
    private String id_operador ;
    private String nome_operador;
    private String email;
    private String tel;
    private String celular;
    private String end;
    private String num;
    private String cep;
    private String estado;
    private String setor;
    private String cargo;
    private String status;
    private String empresa;
    private String supervisor;
    private String complemento;
    private String referencia;
    private String bairro;
    private String cidade;
    private String datacad;
    private String cpf;
 

    public model_operador() {
    }

    public model_operador(String id_operador, String nome_operador, String email, String tel, String celular, String end, String num, String cep, String estado, String setor, String cargo, String status, String empresa, String supervisor, String complemento, String referencia, String bairro, String cidade, String datacad, String cpf) {
        this.id_operador = id_operador;
        this.nome_operador = nome_operador;
        this.email = email;
        this.tel = tel;
        this.celular = celular;
        this.end = end;
        this.num = num;
        this.cep = cep;
        this.estado = estado;
        this.setor = setor;
        this.cargo = cargo;
        this.status = status;
        this.empresa = empresa;
        this.supervisor = supervisor;
        this.complemento = complemento;
        this.referencia = referencia;
        this.bairro = bairro;
        this.cidade = cidade;
        this.datacad = datacad;
        this.cpf = cpf;
    }

    
    
    

    public String getDatacad() {
        return datacad;
    }

    public void setDatacad(String datacad) {
        this.datacad = datacad;
    }

  

    public String getId_operador() {
        return id_operador;
    }

    public void setId_operador(String id_operador) {
        this.id_operador = id_operador;
    }

    public String getNome_operador() {
        return nome_operador;
    }

    public void setNome_operador(String nome_operador) {
        this.nome_operador = nome_operador;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getStatus() {
        return status;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

   
}
