package Modules.Auth.Repositories.interfaces;

import java.util.Optional;
import java.util.List;

import Modules.Auth.Models.Profile;
import Modules.Auth.Models.Role;
import Modules.Auth.VO.Role.RoleNameVO;
import Modules.Core.Repositories.interfaces.IGenericRepository;

public interface IRoleRepository extends IGenericRepository<Role> {
    Optional<Role> getByName(RoleNameVO name);
    List<Role> getByProfile(Profile profile);
    List<Role> getByRole(Role role);
}
