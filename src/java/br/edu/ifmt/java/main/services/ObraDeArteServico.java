/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.java.main.services;

import br.edu.ifmt.java.main.obradearte.ObraDeArte;
import br.edu.ifmt.java.main.obradearte.ObraDeArteDao;
import br.edu.ifmt.java.main.obradearte.TipoObraDeArte;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Israel 1846
 */
public class ObraDeArteServico {

    private final ObraDeArteDao obraDeArteDao;

    public ObraDeArteServico() {
        obraDeArteDao = new ObraDeArteDao();
    }

    public ArrayList<ObraDeArte> getObraDeArtes() {
        try {
            return this.obraDeArteDao.listarTodasObrasDeArte();
        } catch (SQLException ex) {
            Logger.getLogger(ObraDeArteServico.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<TipoObraDeArte> getTiposObrasDeArte() {
        try {
            return this.obraDeArteDao.listarTiposDeObra();
        } catch (SQLException ex) {
            Logger.getLogger(ObraDeArteServico.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean cadastrarObraDeArte(ObraDeArte obraDeArte) {
        if (this.isDadosValidos(obraDeArte)) {
            try {
                obraDeArteDao.cadastrarObraDeArte(obraDeArte);
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean isDadosValidos(ObraDeArte obraDeArte) {
        boolean dadosValidos = true;
        if (obraDeArte.getAutor() == null || obraDeArte.getAutor().isEmpty()) 
            dadosValidos = false;
        if (obraDeArte.getTipo( )== null || obraDeArte.getTipo().isEmpty()) 
            dadosValidos = false;
        if (obraDeArte.getData() == null || obraDeArte.getData().isEmpty()) 
            dadosValidos = false;
        if (obraDeArte.getProcedencia() == null || obraDeArte.getProcedencia().isEmpty()) 
            dadosValidos = false;
        if (obraDeArte.getTitulo() == null || obraDeArte.getTecnica().isEmpty()) 
            dadosValidos = false;
            
        return dadosValidos;    
    }
}
