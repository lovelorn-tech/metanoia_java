package Modules.Auth.Repositories.implementation;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// Mappers
import Modules.Auth.Mappers.implementation.UserMapper;

// Models
import Modules.Auth.Models.Profile;
import Modules.Auth.Models.User;
import Modules.Core.Models.Row;
import Modules.Core.Models.SqlParameter;

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
            if (ex instanceof CustomException)
                throw ex;
            else
                throw new CustomException(
                        500,
                        "save",
                        "UserRepository",
                        Optional.of(ex.getMessage()),
                        Optional.of(null));
        }
    }

    @Override
    public Optional<User> getById(IdVO id) throws CustomException {
        try {
            SqlParameter<String> paramId = new SqlParameter<String>("id", id.getValue());
            List<SqlParameter<? extends Object>> params = List.of();
            params.add(paramId);
            List<Row> rows = this.ctx.executeQuery("SP_User_Get_ById(:" + paramId.getName() + ")", params);
            return Optional.of(rows.isEmpty() ? null : this.userMapper.rowToUser(rows.getFirst()));
        } catch (Exception ex) {
            if (ex instanceof CustomException)
                throw ex;
            else
                throw new CustomException(
                        500,
                        "getById",
                        "UserRepository",
                        Optional.of(ex.getMessage()),
                        Optional.of(null));
        }
    }

    @Override
    public List<User> getAll(Optional<Boolean> deleted) throws CustomException {
        try {
            List<SqlParameter<? extends Object>> params = List.of();
            SqlParameter<Boolean> paramDeleted = new SqlParameter<Boolean>("deleted", deleted.orElseGet(null));
            params.add(paramDeleted);

            List<Row> rows = this.ctx.executeQuery("SP_User_Get_All(:" + paramDeleted.getName() + ")", params);
            List<User> users = List.of();
            for (Row user : rows) {
                users.add(this.userMapper.rowToUser(user));
            }

            return users;
        } catch (Exception ex) {
            if (ex instanceof CustomException)
                throw ex;
            else
                throw new CustomException(
                        500,
                        "getAll",
                        "UserRepository",
                        Optional.of(ex.getMessage()),
                        Optional.of(null));
        }
    }

    @Override
    public Optional<User> getByUsername(UserUsernameVO username) throws CustomException {
        try {
            SqlParameter<String> paramUsername = new SqlParameter<String>("username", username.getValue());
            List<SqlParameter<? extends Object>> params = List.of();
            params.add(paramUsername);
            List<Row> rows = ctx.executeQuery("SP_User_Get_ByUsername(:" + paramUsername.getName() + ")", params);
            return Optional.of(rows.isEmpty() ? null : this.userMapper.rowToUser(rows.getFirst()));
        } catch (Exception ex) {
            if (ex instanceof CustomException)
                throw ex;
            else
                throw new CustomException(
                        500,
                        "getByUsername",
                        "UserRepository",
                        Optional.of(ex.getMessage()),
                        Optional.of(null));
        }
    }

    @Override
    public List<User> getByUsernameOrEmail(UserUsernameVO username, UserEmailVO email) throws CustomException {
        try {
            SqlParameter<String> paramUsername = new SqlParameter<String>("username", username.getValue());
            SqlParameter<String> paramEmail = new SqlParameter<String>("email", email.getValue());

            List<SqlParameter<? extends Object>> params = List.of();
            params.addAll(Arrays.asList(paramUsername, paramEmail));

            List<Row> rows = ctx.executeQuery("SP_User_Get_ByUsernameOrEmail(:" + paramUsername.getName() + ", :" + paramEmail.getName() + ")", params);
            List<User> users = List.of();
            for (Row row : rows) {
                users.add(userMapper.rowToUser(row));
            }

            return users;
        } catch (Exception ex) {
            if (ex instanceof CustomException)
                throw ex;
            else
                throw new CustomException(
                        500,
                        "getByUsernameOrEmail",
                        "UserRepository",
                        Optional.of(ex.getMessage()),
                        Optional.of(null));
        }
    }

    @Override
    public List<User> getByProfile(Profile profile) throws CustomException {
        try {
            SqlParameter<String> paramProfileId = new SqlParameter<String>("profileId", profile.getId());

            List<SqlParameter<? extends Object>> params = List.of();
            params.addAll(Arrays.asList(paramProfileId));

            List<User> users = List.of();
            List<Row> rows = ctx.executeQuery("SP_User_Get_ByProfile(:" + paramProfileId.getName() + ")", params);
            for (Row row : rows) {
                users.add(userMapper.rowToUser(row));
            }

            return users;
        } catch (Exception ex) {
            if (ex instanceof CustomException)
                throw ex;
            else
                throw new CustomException(
                        500,
                        "getByProfile",
                        "UserRepository",
                        Optional.of(ex.getMessage()),
                        Optional.of(null));
        }
    }

}
