package Modules.Auth.Repositories.interfaces;

import java.util.Optional;
import java.util.List;

// Models
import Modules.Auth.Models.Profile;
import Modules.Auth.Models.Role;

// VO
import Modules.Auth.VO.Role.RoleNameVO;

// Exceptions
import Modules.Core.Models.CustomException;

// Interfaces
import Modules.Core.Repositories.interfaces.IGenericRepository;

public interface IRoleRepository extends IGenericRepository<Role> {
    Optional<Role> getByName(RoleNameVO name) throws CustomException;
    List<Role> getByProfile(Profile profile) throws CustomException;
    List<Role> getByRole(Role role) throws CustomException;
}
