package Modules.Auth.Repositories.contexts;

import Modules.Core.Models.CustomException;

public interface IDBContext {
    public void executeQuery(String SP) throws CustomException;
    public void executeCMD(String SP) throws CustomException;
}
