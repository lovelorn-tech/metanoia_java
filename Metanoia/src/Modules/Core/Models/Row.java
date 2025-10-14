package Modules.Core.Models;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Row {
    private final List<Column> columns;

    public Row(final ResultSet rs) throws CustomException {
        this.columns = new ArrayList<Column>();
        this.addColumn(rs);
    }

    private void addColumn(final ResultSet rs) throws CustomException {
        try {
            ResultSetMetaData metadata = rs.getMetaData();
            int columnsCount = metadata.getColumnCount();
            for (int i = 0; i <= columnsCount; i++) {
                this.columns.add(new Column(rs.getObject(i), metadata.getColumnLabel(i), metadata.getColumnTypeName(i)));
            }
        } catch (SQLException ex) {
            throw new CustomException(
                    500,
                    "addColumn",
                    "Row",
                    Optional.of(ex.getMessage()),
                    Optional.of(null));
        } catch (Exception ex) {
            if (ex instanceof CustomException)
                throw ex;
            else
                throw new CustomException(
                        500,
                        "addColumn",
                        "Row",
                        Optional.of(ex.getMessage()),
                        Optional.of(null));
        }
    }
}
