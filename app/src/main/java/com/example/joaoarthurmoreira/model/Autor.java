package com.example.joaoarthurmoreira.model;

import com.orm.SugarRecord;

/**
 * Created by joaoarthurmoreira on 29/10/15.
 */
public class Autor extends SugarRecord{

    private String nome;

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private String sobreNome;

    public Autor(){

    }

    public Autor(String nome, String sobreNome) {
        this.nome = nome;
        this.sobreNome = sobreNome;
    }
}
