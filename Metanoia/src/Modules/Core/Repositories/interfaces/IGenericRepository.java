package Modules.Core.Repositories.interfaces;

import Modules.Core.VO.IdVO;

import java.util.List;
import java.util.Optional;

public interface IGenericRepository<T> {

    void save(T entity);

    Optional<T> getById(IdVO id);

    List<T> getAll(Optional<Boolean> deleted);
}