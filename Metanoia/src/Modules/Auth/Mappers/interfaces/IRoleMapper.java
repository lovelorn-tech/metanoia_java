package Modules.Auth.Mappers.interfaces;

import Modules.Auth.Models.Role;
import Modules.Core.Models.Row;

public interface IRoleMapper {
    Role rowToRole(Row row);
}
