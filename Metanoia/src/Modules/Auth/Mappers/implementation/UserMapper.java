package Modules.Auth.Mappers.implementation;

import java.util.Optional;

import Modules.Auth.Mappers.interfaces.IUserMapper;
import Modules.Auth.Models.User;

public class UserMapper implements IUserMapper {
    private static Optional<UserMapper> instance = Optional.of(null);

    private UserMapper() {}

    public static UserMapper getInstance() {
        if (UserMapper.instance.isEmpty()) {
            UserMapper.instance = Optional.of(new UserMapper());
        }
        return UserMapper.instance.get();
    }

    @Override
    public User rowToUser(Object row) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'rowToUser'");
    }
}
