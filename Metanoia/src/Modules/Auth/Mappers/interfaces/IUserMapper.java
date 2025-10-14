package Modules.Auth.Mappers.interfaces;

import Modules.Auth.Models.User;
import Modules.Core.Models.Row;

public interface IUserMapper {
    User rowToUser(Row row);
}
