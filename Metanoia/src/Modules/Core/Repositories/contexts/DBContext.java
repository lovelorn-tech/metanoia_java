package Modules.Core.Repositories.contexts;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import Modules.Core.Models.CustomException;
import Modules.Core.Models.Row;

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
    public List<Row> executeQuery(final String SP) throws CustomException {
        try {
            this.open();
            Connection con = this.conn.get();
            CallableStatement cs = con.prepareCall("{ CALL " + SP + " }");
            //TODO:  Add sql parameters here
            cs.execute();
            List<Row> rows = List.of();
            ResultSet rs = cs.getResultSet();
            if (rs != null) {
                while (rs.next()) {
                    Row row = new Row(rs);
                    rows.add(row);
                }
                rs.close();
            }
            cs.close();
            con.close();
            return rows;
        } catch (SQLException ex) {
            try {
                this.conn.get().rollback();
            } catch (SQLException e) {
                throw new CustomException(
                        500,
                        "executeQuery",
                        "DBContext",
                        Optional.of(ex.getMessage()),
                        Optional.of(null));
            }
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
