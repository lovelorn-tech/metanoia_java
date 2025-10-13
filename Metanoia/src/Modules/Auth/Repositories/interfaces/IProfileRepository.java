package Modules.Auth.Repositories.interfaces;

import java.util.Optional;

import Modules.Auth.Models.Profile;
import Modules.Auth.VO.Profile.ProfileNameVO;
import Modules.Core.Repositories.interfaces.IGenericRepository;

public interface IProfileRepository extends IGenericRepository<Profile> {
    Optional<Profile> getByName(ProfileNameVO name);
}
