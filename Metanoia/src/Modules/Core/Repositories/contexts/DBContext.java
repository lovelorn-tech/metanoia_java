package Modules.Core.Repositories.contexts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import Modules.Core.Models.CustomException;

public class DBContext implements IDBContext {
    private static Optional<DBContext> ctx = Optional.of(null);
    private final String connectionString = "";
    private Optional<Connection> conn = Optional.of(null);

    private DBContext() {
    };

    public static DBContext getInstance() {
        if (DBContext.ctx.isEmpty()) {
            DBContext.ctx = Optional.of(new DBContext());
        }
        return DBContext.ctx.get();
    }

    private void open() throws CustomException {
        try {
            if (this.conn.isEmpty()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                this.conn = Optional.of(
                        (Connection) DriverManager.getConnection(connectionString, connectionString, connectionString));
            }
        } catch (Exception ex) {
            if (ex instanceof CustomException) {
                throw (CustomException) ex;
            } else {
                throw new CustomException(
                        500,
                        "open",
                        "DBContext",
                        Optional.of(ex.getMessage()),
                        Optional.of(null));
            }

        }
    }

    @Override
    public List<Object> executeQuery(String SP) throws CustomException {
        try {
            this.open();
            Connection con = this.conn.get();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(SP);
            List<Object> o = List.of();
            while (rs.next()) {
                
            }
            return o;
        } catch (SQLException ex) {
            throw new CustomException(
                    500,
                    "executeQuery",
                    "DBContext",
                    Optional.of(ex.getMessage()),
                    Optional.of(null));
        } catch (Exception ex) {
            if (ex instanceof CustomException)
                throw ex;
            else
                throw new CustomException(
                        500,
                        "executeQuery",
                        "DBContext",
                        Optional.of(ex.getMessage()),
                        Optional.of(null));
        } finally {
            if (this.conn.isPresent()) {
                try {
                    this.conn.get().close();
                } catch (SQLException ex) {
                    throw new CustomException(
                            500,
                            "executeQuery",
                            "DBContext",
                            Optional.of(ex.getMessage()),
                            Optional.of(null));
                }
            }
        }
    }

    @Override
    public void executeCMD(String SP) throws CustomException {
        try {
            this.open();
            Connection con = this.conn.get();
        } catch (Exception ex) {
            if (ex instanceof CustomException)
                throw ex;
            else
                throw new CustomException(
                        500,
                        "executeCMD",
                        "DBContext",
                        Optional.of(ex.getMessage()),
                        Optional.of(null));
        } finally {
            if (this.conn.isPresent()) {
                try {
                    this.conn.get().close();
                } catch (SQLException ex) {
                    throw new CustomException(
                            500,
                            "executeCMD",
                            "DBContext",
                            Optional.of(ex.getMessage()),
                            Optional.of(null));
                }
            }
        }
    }

}
