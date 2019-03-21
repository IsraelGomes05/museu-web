/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.java.main.obradearte;

import br.edu.ifmt.java.main.dao.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Israel 1846
 */
public class ObraDeArteDao {

    public ArrayList<ObraDeArte> listarTodasObrasDeArte() throws SQLException {
        String sql = "Select id, titulo, autor, data, tipo, procedencia, tecnica, img from obra_de_arte;";
        ArrayList<ObraDeArte> livros = new ArrayList<>();
        ResultSet rs;

        try (PreparedStatement psm = DAO.getConexao().prepareStatement(sql)) {

            rs = psm.executeQuery();

            while (rs.next()) {
                ObraDeArte livro = new ObraDeArte(
                        rs.getLong("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getString("data"),
                        rs.getString("tipo"),
                        rs.getString("autor"),
                        rs.getString("tecnica"),
                        rs.getString("img")
                );
                livros.add(livro);
            }
        }
        return livros;
    }

    public ArrayList<TipoObraDeArte> listarTiposDeObra() throws SQLException {
        String sql = "Select id, descricao from opcoes;";
        ArrayList<TipoObraDeArte> tipos = new ArrayList<>();
        ResultSet rs;

        try (PreparedStatement psm = DAO.getConexao().prepareStatement(sql)) {

            rs = psm.executeQuery();

            while (rs.next()) {
                TipoObraDeArte livro = new TipoObraDeArte(rs.getLong("id"), rs.getString("descricao"));

                tipos.add(livro);
            }
        }
        return tipos;
    }

    public void cadastrarObraDeArte(ObraDeArte obraDeArte) throws SQLException, ParseException {
        String sql = "INSERT INTO obra_de_arte(titulo, autor, data, tipo, procedencia, tecnica, img) VALUES ( ?, ?, ?, ?, ?, ?, ?);";

        try (PreparedStatement psm = DAO.getConexao().prepareStatement(sql)) {

            DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
            DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
            Date data = df2.parse(obraDeArte.getData());
                    
            psm.setString(1, obraDeArte.getTitulo());
            psm.setString(2, obraDeArte.getAutor());
            psm.setString(3, df1.format(data));
            psm.setString(4, obraDeArte.getTipo());
            psm.setString(5, obraDeArte.getProcedencia());
            psm.setString(6, obraDeArte.getTecnica());
            psm.setString(7, obraDeArte.getImagem() == null ? "assets/img/vazio.jpg" : obraDeArte.getImagem());

            psm.executeUpdate();
        }
    }
}
