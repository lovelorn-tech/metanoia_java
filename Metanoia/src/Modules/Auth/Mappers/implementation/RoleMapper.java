package Modules.Auth.Mappers.implementation;

import java.util.Optional;

import Modules.Auth.Mappers.interfaces.IRoleMapper;
import Modules.Auth.Models.Role;
import Modules.Core.Models.Row;

public class RoleMapper implements IRoleMapper {
    private static Optional<RoleMapper> instance = Optional.of(null);

    private RoleMapper() {}

    public static RoleMapper getInstance() {
        if (RoleMapper.instance.isEmpty()) {
            RoleMapper.instance = Optional.of(new RoleMapper());
        }
        return RoleMapper.instance.get();
    }

    @Override
    public Role rowToRole(Row row) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'rowToRole'");
    }
    
}
