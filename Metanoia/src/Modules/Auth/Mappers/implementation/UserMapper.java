package Modules.Auth.Mappers.implementation;

import java.util.Optional;

// Interfaces
import Modules.Auth.Mappers.interfaces.IUserMapper;

// Models
import Modules.Auth.Models.User;
import Modules.Core.Models.Row;

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
    public User rowToUser(Row row) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'rowToUser'");
    }
}
