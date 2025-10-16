package Modules.Core.Repositories.contexts;

import java.util.List;

import Modules.Core.Models.CustomException;
import Modules.Core.Models.Row;
import Modules.Core.Models.SqlParameter;

public interface IDBContext {
    public List<Row> executeQuery(final String SP, final List<SqlParameter<? extends Object>> params) throws CustomException;
    public void executeCMD(final String SP, final List<SqlParameter<? extends Object>> params) throws CustomException;
}
