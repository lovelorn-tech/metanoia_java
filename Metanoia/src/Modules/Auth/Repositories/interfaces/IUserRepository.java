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
    Optional<User> getByCredentials(UserUsernameVO username, UserPasswordVO password) throws CustomException;
    Optional<User> getByUsernameOrEmail(UserUsernameVO username, UserEmailVO email) throws CustomException;
    List<User> getByProfile(Profile profile) throws CustomException;
}
