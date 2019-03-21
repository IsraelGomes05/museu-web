/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.java.main.obradearte;

import java.text.SimpleDateFormat;

/**
 *
 * @author Israel 1846
 */
public class ObraDeArte {

    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Long id;
    private String titulo;
    private String autor;
    private String data;
    private String tipo;
    private String procedencia;
    private String tecnica;
    private String imagem;

    public ObraDeArte() {
    }
    
    public ObraDeArte(Long id, String titulo, String autor, String data, String tipo, String procedencia, String tecnica, String imagem) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.data = data;
        this.tipo = tipo;
        this.procedencia = procedencia;
        this.tecnica = tecnica;
        this.imagem = imagem;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String printData() {
        return this.data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
}
