package Modules.Core.Repositories.contexts;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import Modules.Core.Models.CustomException;
import Modules.Core.Models.Row;
import Modules.Core.Models.SqlParameter;

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

    private <T> void loadSqlParameters(CallableStatement cs, final List<SqlParameter<T>> params)
            throws CustomException {
        try {
            for (SqlParameter<T> param : params) {
                switch (param.getValue()) {
                    case Integer _:
                    case int _: {
                        cs.setInt(param.getName(), Integer.class.cast(param.getValue()));
                        break;
                    }
                    case String _: {
                        cs.setString(param.getName(), String.class.cast(param.getValue()));
                        break;
                    }
                    case Boolean _:
                    case boolean _: {
                        cs.setBoolean(param.getName(), Boolean.class.cast(param.getValue()));
                        break;
                    }
                    case BigDecimal _:
                        cs.setBigDecimal(param.getName(), BigDecimal.class.cast(param.getValue()));
                        break;
                    case Date _:
                        cs.setDate(param.getName(), java.sql.Date.class.cast(param.getValue()));
                    default:
                        break;
                }
            }
        } catch (SQLException ex) {
            throw new CustomException(
                    500,
                    "loadSqlParameters",
                    "DBContext",
                    Optional.of(ex.getMessage()),
                    Optional.of(null));
        } catch (Exception ex) {
            if (ex instanceof CustomException)
                throw ex;
            else
                throw new CustomException(
                        500,
                        "loadSqlParameters",
                        "DBContext",
                        Optional.of(ex.getMessage()),
                        Optional.of(null));
        }
    }

    @Override
    public <T> List<Row> executeQuery(final String SP, final List<SqlParameter<T>> params) throws CustomException {
        try {
            this.open();
            Connection con = this.conn.get();
            CallableStatement cs = con.prepareCall("{ CALL " + SP + " }");
            loadSqlParameters(cs, params);
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
    public <T> void executeCMD(final String SP, final List<SqlParameter<T>> params) throws CustomException {
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
