package Modules.Auth.Mappers.interfaces;

import Modules.Auth.Models.User;

public interface IUserMapper {
    User rowToUser(Object row);
}
