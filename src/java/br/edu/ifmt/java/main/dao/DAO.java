/**
 * @created  00/00/2018
 * @lastModified 00/00/2018
 */
package br.edu.ifmt.java.main.dao;

/**
 * funcion...
 *
 * @author Israel Gomes
 * @version 1.0
 * @since 1.0
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.sqlite.javax.SQLiteConnectionPoolDataSource;

/**
 * Classe responsável por abrir e fechar conexões com o banco de dados.
 *
 * @author Israel Gomes
 * @version 2.8
 * @since 1.0
 */
public class DAO {

    private static SQLiteConnectionPoolDataSource pool = null;
    private static final String prefix = "jdbc:sqlite:";

    public static Connection getConexao() {
        try {
            Class.forName("org.sqlite.JDBC");
            if (pool == null) {
                String path = DAO.class.getProtectionDomain().getCodeSource().getLocation().getPath();
                path = path.substring(1, path.lastIndexOf("/") + 1);
                pool = new SQLiteConnectionPoolDataSource();
                pool.setUrl(( prefix + path + "web-db.db").replace("%20", " "));
            }
            return pool.getConnection();

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static void close(Connection connection) {

        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void close(Statement stm) {
        try {
            if (stm != null) {
                stm.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public static void close(Connection conection, Statement stm, ResultSet rst) {
        close(stm);
        try {
            if (rst != null) {
                rst.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void close(ResultSet rst) {

        try {
            if (rst != null) {
                rst.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
