package com.example.mdamaceno.concessionaria.model;

import java.io.Serializable;

/**
 * Created by mdamaceno on 13/04/15.
 */
public class Usuario implements Serializable {
    private Long id;
    private String nome, email, senha;
    private int tipo;

    public Usuario() {
    }

    public Usuario(Long id, String nome, String email, String senha, int tipo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
