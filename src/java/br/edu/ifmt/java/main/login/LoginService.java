/**
 * @created  00/00/2018
 * @lastModified 00/00/2018 
 */

package br.edu.ifmt.java.main.login;

import java.sql.SQLException;

/** funcion...
 * @author Israel Gomes
 * @version 1.0
 * @since 1.0
 */
public class LoginService {
    
    private final LoginDao loginDao;

    public LoginService() {
        this.loginDao = new LoginDao();
    }
    
    public boolean login(String email, String senha) {
        try {
            return this.loginDao.logar(email, senha);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
