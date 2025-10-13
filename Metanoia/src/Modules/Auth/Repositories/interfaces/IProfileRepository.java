package Modules.Auth.Repositories.interfaces;

import java.util.Optional;

// Models
import Modules.Auth.Models.Profile;

// VO
import Modules.Auth.VO.Profile.ProfileNameVO;

// Exceptions
import Modules.Core.Models.CustomException;

// Interfaces
import Modules.Core.Repositories.interfaces.IGenericRepository;

public interface IProfileRepository extends IGenericRepository<Profile> {
    Optional<Profile> getByName(ProfileNameVO name) throws CustomException;
}
