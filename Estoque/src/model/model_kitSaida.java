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
public class model_kitSaida {
    private String id_kit;
    private String datakitSaida;
    private String id_pc;
    private String cod_pc;
    private String id_monitor;
    private String cod_monitor;
    private String cod_mouse;
    private String cod_teclado;
    private String id_head;
    private String cod_webcam;
    private String qntEnergia;
    private String qntVga;
    private String id_operador;
    private String nome;
    private String telefone;
    private String email;
    private String cargo;
    private String setor;
    private String supervisor;
    private String status;

    public model_kitSaida() {
    }

    public model_kitSaida(String id_kit, String datakitSaida, String id_pc, String cod_pc, String id_monitor, String cod_monitor, String id_operador, String nome, String telefone, String email, String cargo, String setor, String supervisor, String status) {
        this.id_kit = id_kit;
        this.datakitSaida = datakitSaida;
        this.id_pc = id_pc;
        this.cod_pc = cod_pc;
        this.id_monitor = id_monitor;
        this.cod_monitor = cod_monitor;
        this.id_operador = id_operador;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cargo = cargo;
        this.setor = setor;
        this.supervisor = supervisor;
        this.status = status;
    }

    public model_kitSaida(String datakitSaida, String id_pc, String cod_pc, String id_monitor, String cod_monitor, String cod_mouse, String cod_teclado, String id_head, String cod_webcam, String qntEnergia, String qntVga, String id_operador, String nome, String telefone, String email, String cargo, String setor, String supervisor, String status) {
        this.datakitSaida = datakitSaida;
        this.id_pc = id_pc;
        this.cod_pc = cod_pc;
        this.id_monitor = id_monitor;
        this.cod_monitor = cod_monitor;
        this.cod_mouse = cod_mouse;
        this.cod_teclado = cod_teclado;
        this.id_head = id_head;
        this.cod_webcam = cod_webcam;
        this.qntEnergia = qntEnergia;
        this.qntVga = qntVga;
        this.id_operador = id_operador;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cargo = cargo;
        this.setor = setor;
        this.supervisor = supervisor;
        this.status = status;
    }

    public String getCod_mouse() {
        return cod_mouse;
    }

    public void setCod_mouse(String cod_mouse) {
        this.cod_mouse = cod_mouse;
    }

    public String getCod_teclado() {
        return cod_teclado;
    }

    public void setCod_teclado(String cod_teclado) {
        this.cod_teclado = cod_teclado;
    }

    public String getId_head() {
        return id_head;
    }

    public void setId_head(String id_head) {
        this.id_head = id_head;
    }

    public String getCod_webcam() {
        return cod_webcam;
    }

    public void setCod_webcam(String cod_webcam) {
        this.cod_webcam = cod_webcam;
    }

    public String getQntEnergia() {
        return qntEnergia;
    }

    public void setQntEnergia(String qntEnergia) {
        this.qntEnergia = qntEnergia;
    }

    public String getQntVga() {
        return qntVga;
    }

    public void setQntVga(String qntVga) {
        this.qntVga = qntVga;
    }

    

    public String getId_kit() {
        return id_kit;
    }

    public void setId_kit(String id_kit) {
        this.id_kit = id_kit;
    }

    public String getDatakitSaida() {
        return datakitSaida;
    }

    public void setDatakitSaida(String datakitSaida) {
        this.datakitSaida = datakitSaida;
    }

    public String getId_pc() {
        return id_pc;
    }

    public void setId_pc(String id_pc) {
        this.id_pc = id_pc;
    }

    public String getCod_pc() {
        return cod_pc;
    }

    public void setCod_pc(String cod_pc) {
        this.cod_pc = cod_pc;
    }

    public String getId_monitor() {
        return id_monitor;
    }

    public void setId_monitor(String id_monitor) {
        this.id_monitor = id_monitor;
    }

    public String getCod_monitor() {
        return cod_monitor;
    }

    public void setCod_monitor(String cod_monitor) {
        this.cod_monitor = cod_monitor;
    }

    public String getId_operador() {
        return id_operador;
    }

    public void setId_operador(String id_operador) {
        this.id_operador = id_operador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
