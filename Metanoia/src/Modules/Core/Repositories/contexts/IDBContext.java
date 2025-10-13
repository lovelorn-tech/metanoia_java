package Modules.Core.Repositories.contexts;

import java.util.List;

import Modules.Core.Models.CustomException;

public interface IDBContext {
    public List<Object> executeQuery(String SP) throws CustomException;
    public void executeCMD(String SP) throws CustomException;
}
