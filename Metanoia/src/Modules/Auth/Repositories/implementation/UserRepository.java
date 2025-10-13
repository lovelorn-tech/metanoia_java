package Modules.Auth.Repositories.implementation;

import java.util.List;
import java.util.Optional;

// Mappers
import Modules.Auth.Mappers.implementation.UserMapper;

// Models
import Modules.Auth.Models.Profile;
import Modules.Auth.Models.User;

// Interfaces
import Modules.Auth.Repositories.interfaces.IUserRepository;
import Modules.Core.Repositories.contexts.IDBContext;
import Modules.Auth.Mappers.interfaces.IUserMapper;

// VO
import Modules.Auth.VO.User.*;
import Modules.Core.VO.IdVO;

// Exceptions
import Modules.Core.Models.CustomException;

// Contexts
import Modules.Core.Repositories.contexts.DBContext;

public class UserRepository implements IUserRepository {

    private static Optional<UserRepository> instance = Optional.of(null);
    private final IDBContext ctx;
    private final IUserMapper userMapper;

    private UserRepository() {
        this.ctx = DBContext.getInstance();
        this.userMapper = UserMapper.getInstance();
    }

    public static UserRepository getInstance() {
        if (UserRepository.instance.isEmpty()) {
            UserRepository.instance = Optional.of(new UserRepository());
        }
        return UserRepository.instance.get();
    }

    @Override
    public void save(User entity) throws CustomException {
        try {
            throw new UnsupportedOperationException("Unimplemented method 'GetById'");
        } catch (Exception ex) {
            if (ex instanceof CustomException) throw ex;
            else throw new CustomException(
                    500, 
                    "getById", 
                    "UserRepository", 
                    Optional.of(ex.getMessage()), 
                    Optional.of(null)
                );
        }
    }

    @Override
    public Optional<User> getById(IdVO id) throws CustomException {
        try {
            List<Object> o = this.ctx.executeQuery("SP_User_Get_ById");
            return Optional.of(o.isEmpty() ? null : this.userMapper.rowToUser(o.getFirst()));
        } catch (Exception ex) {
            if (ex instanceof CustomException) throw ex;
            else throw new CustomException(
                    500, 
                    "getById", 
                    "UserRepository", 
                    Optional.of(ex.getMessage()), 
                    Optional.of(null)
                );
        }
    }

    @Override
    public List<User> getAll(Optional<Boolean> deleted) throws CustomException {
        try {
            List<Object> o = this.ctx.executeQuery("SP_User_Get_All");
            List<User> users = List.of();
            for (Object user : o) {
                users.add(this.userMapper.rowToUser(user));
            }
            return users;
        } catch (Exception ex) {
            if (ex instanceof CustomException) throw ex;
            else throw new CustomException(
                    500, 
                    "getById", 
                    "UserRepository", 
                    Optional.of(ex.getMessage()), 
                    Optional.of(null)
                );
        }
    }

    @Override
    public Optional<User> getByCredentials(UserUsernameVO username, UserPasswordVO password) throws CustomException {
        try {
            throw new UnsupportedOperationException("Unimplemented method 'GetById'");
        } catch (Exception ex) {
            if (ex instanceof CustomException) throw ex;
            else throw new CustomException(
                    500, 
                    "getById", 
                    "UserRepository", 
                    Optional.of(ex.getMessage()), 
                    Optional.of(null)
                );
        }
    }

    @Override
    public Optional<User> getByUsernameOrEmail(UserUsernameVO username, UserEmailVO email) throws CustomException {
        try {
            throw new UnsupportedOperationException("Unimplemented method 'GetById'");
        } catch (Exception ex) {
            if (ex instanceof CustomException) throw ex;
            else throw new CustomException(
                    500, 
                    "getById", 
                    "UserRepository", 
                    Optional.of(ex.getMessage()), 
                    Optional.of(null)
                );
        }
    }

    @Override
    public List<User> getByProfile(Profile profile) throws CustomException {
        try {
            throw new UnsupportedOperationException("Unimplemented method 'GetById'");
        } catch (Exception ex) {
            if (ex instanceof CustomException) throw ex;
            else throw new CustomException(
                    500, 
                    "getById", 
                    "UserRepository", 
                    Optional.of(ex.getMessage()), 
                    Optional.of(null)
                );
        }
    }

}
