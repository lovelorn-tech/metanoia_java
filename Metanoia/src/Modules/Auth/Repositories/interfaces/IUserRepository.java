package Modules.Auth.Repositories.interfaces;

import java.util.List;
import java.util.Optional;

// Models
import Modules.Auth.Models.*;

// VO
import Modules.Auth.VO.User.*;

// Exceptions
import Modules.Core.Models.CustomException;

// Interfaces
import Modules.Core.Repositories.interfaces.IGenericRepository;

public interface IUserRepository extends IGenericRepository<User> {
    Optional<User> getByUsername(UserUsernameVO username) throws CustomException;
    List<User> getByUsernameOrEmail(UserUsernameVO username, UserEmailVO email) throws CustomException;
    List<User> getByProfile(Profile profile) throws CustomException;
}
