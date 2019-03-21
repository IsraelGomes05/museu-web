/**
 * @created      25/12/2017
 * @lastModified 11/11/2018
 */
package br.com.devninja.bingomania.dao;

import br.com.devninja.bingomania.main.AppLocal;
import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

/**
 * Classe responsável por abrir e fechar conexões com o banco de dados.
 *
 * @author Israel Gomes
 * @version 3.0
 * @since 1.0
 */
public final class Session {

    private static MysqlConnectionPoolDataSource pool = null;
    private final String user, banco, senha;
    private static final Session SESSION = null;

    private Session(String user, String banco, String senha) {
        this.user = user;
        this.banco = banco;
        this.senha = senha;
    }

    public static Session getInstance(String user, String banco, String senha) {
        if (SESSION == null) {
            return new Session(user, banco, senha);
        }
        return SESSION;
    }

    public Connection getConexao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            if (pool == null) {
                pool = new MysqlConnectionPoolDataSource();
                pool.setServerTimezone("UTC");
                pool.setDatabaseName(this.banco);
                pool.setPassword(this.senha);
                pool.setUser(this.user);
            }
            return pool.getConnection();

        } catch (SQLException | ClassNotFoundException ex) {
            AppLocal.logger.log(Level.SEVERE, Session.class.getName(), ex);
            return null;
        }
    }

    public static void close(Connection connection) {

        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            AppLocal.logger.log(Level.SEVERE, Session.class.getName(), ex);
        }
    }

    public static void close(Statement stm) {
        try {
            if (stm != null) {
                stm.close();
            }
        } catch (SQLException ex) {
            AppLocal.logger.log(Level.SEVERE, Session.class.getName(), ex);
        }
    }

    public static void close(Connection conection, Statement stm, ResultSet rst) {
        close(stm);
        close(rst);
        try {
            if (conection != null) {
                conection.close();
            }
        } catch (SQLException ex) {
            AppLocal.logger.log(Level.SEVERE, Session.class.getName(), ex);
        }
    }

    public static void close(ResultSet rst) {
        try {
            if (rst != null) {
                rst.close();
            }
        } catch (SQLException ex) {
            AppLocal.logger.log(Level.SEVERE, Session.class.getName(), ex);
        }
    }

    public static void close(ResultSet rst, Statement ps) {
        close(rst);
        close(ps);
    }
}
