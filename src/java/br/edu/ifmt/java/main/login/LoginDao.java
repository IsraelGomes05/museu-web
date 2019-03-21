/**
 * @created  00/00/2018
 * @lastModified 00/00/2018
 */
package br.edu.ifmt.java.main.login;

import br.edu.ifmt.java.main.dao.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * funcion...
 *
 * @author Israel Gomes
 * @version 1.0
 * @since 1.0
 */
public class LoginDao {

    public boolean logar(String email, String senha) throws SQLException {
        String sql = "Select count(0) from login where email = ? and senha = ?";
        long usuarioEncontrado = 0;
        ResultSet rs;
        try (PreparedStatement psm = DAO.getConexao().prepareStatement(sql)) {
            psm.setString(1, email);
            psm.setString(2, senha);

            rs = psm.executeQuery();

            if (rs.next()) {
                usuarioEncontrado = rs.getLong(1);
            }
        }
        
        return usuarioEncontrado > 0;
    }
}
