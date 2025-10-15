package Modules.Core.Repositories.contexts;

import java.util.List;

import Modules.Core.Models.CustomException;
import Modules.Core.Models.Row;
import Modules.Core.Models.SqlParameter;

public interface IDBContext {
    public <T> List<Row> executeQuery(final String SP, final List<SqlParameter<T>> params) throws CustomException;
    public <T> void executeCMD(final String SP, final List<SqlParameter<T>> params) throws CustomException;
}
