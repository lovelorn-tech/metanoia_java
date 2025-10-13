package Modules.Core.Repositories.interfaces;

// Exceptions
import Modules.Core.Models.CustomException;

// VO
import Modules.Core.VO.IdVO;

import java.util.List;
import java.util.Optional;

public interface IGenericRepository<T> {

    void save(T entity) throws CustomException;

    Optional<T> getById(IdVO id) throws CustomException;

    List<T> getAll(Optional<Boolean> deleted) throws CustomException;
}