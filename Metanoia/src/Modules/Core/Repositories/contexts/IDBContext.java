package Modules.Core.Repositories.contexts;

import java.util.List;

import Modules.Core.Models.CustomException;
import Modules.Core.Models.Row;

public interface IDBContext {
    public List<Row> executeQuery(String SP) throws CustomException;
    public void executeCMD(String SP) throws CustomException;
}
