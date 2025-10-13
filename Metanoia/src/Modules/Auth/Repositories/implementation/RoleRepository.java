package Modules.Auth.Repositories.implementation;

import java.util.List;
import java.util.Optional;

import Modules.Auth.Models.Profile;
import Modules.Auth.Models.Role;
import Modules.Auth.Repositories.interfaces.IRoleRepository;
import Modules.Auth.VO.Role.RoleNameVO;
import Modules.Core.VO.IdVO;

public class RoleRepository implements IRoleRepository {
    private static Optional<RoleRepository> instance = Optional.of(null);

    private RoleRepository() {}

    public static RoleRepository getInstance() {
        if (RoleRepository.instance.isEmpty()) {
            RoleRepository.instance = Optional.of(new RoleRepository());
        }
        return RoleRepository.instance.get();
    }

    @Override
    public void save(Role entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Optional<Role> getById(IdVO id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public List<Role> getAll(Optional<Boolean> deleted) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public Optional<Role> getByName(RoleNameVO name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByName'");
    }

    @Override
    public List<Role> getByProfile(Profile profile) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByProfile'");
    }

    @Override
    public List<Role> getByRole(Role role) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByRole'");
    }
    
}
