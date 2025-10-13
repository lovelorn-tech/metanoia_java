package Modules.Auth.Repositories.implementation;

import java.util.List;
import java.util.Optional;

import Modules.Auth.Models.Profile;
import Modules.Auth.Models.User;
import Modules.Auth.Repositories.interfaces.IUserRepository;
import Modules.Auth.VO.User.UserEmailVO;
import Modules.Auth.VO.User.UserPasswordVO;
import Modules.Auth.VO.User.UserUsernameVO;
import Modules.Core.VO.IdVO;

public class UserRepository implements IUserRepository {

    private static Optional<UserRepository> instance = Optional.of(null);

    private UserRepository() {}

    public static UserRepository getInstance() {
        if (UserRepository.instance.isEmpty()) {
            UserRepository.instance = Optional.of(new UserRepository());
        }
        return UserRepository.instance.get();
    }

    @Override
    public void save(User entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Save'");
    }

    @Override
    public Optional<User> getById(IdVO id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'GetById'");
    }

    @Override
    public List<User> getAll(Optional<Boolean> deleted) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'GetAll'");
    }

    @Override
    public Optional<User> getByCredentials(UserUsernameVO username, UserPasswordVO password) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByCredentials'");
    }

    @Override
    public Optional<User> getByUsernameOrEmail(UserUsernameVO username, UserEmailVO email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByUsernameOrEmail'");
    }

    @Override
    public List<User> getByProfile(Profile profile) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByProfile'");
    }

}
