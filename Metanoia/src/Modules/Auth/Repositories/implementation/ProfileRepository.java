package Modules.Auth.Repositories.implementation;

import java.util.List;
import java.util.Optional;

import Modules.Auth.Models.Profile;
import Modules.Auth.Repositories.interfaces.IProfileRepository;
import Modules.Auth.VO.Profile.ProfileNameVO;
import Modules.Core.VO.IdVO;

public class ProfileRepository implements IProfileRepository {
    private static Optional<ProfileRepository> instance = Optional.of(null);

    private ProfileRepository() {}

    public static ProfileRepository getInstance() {
        if (ProfileRepository.instance.isEmpty()){
            ProfileRepository.instance = Optional.of(new ProfileRepository());
        }
        return ProfileRepository.instance.get();
    }

    @Override
    public void save(Profile entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Optional<Profile> getById(IdVO id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public List<Profile> getAll(Optional<Boolean> deleted) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public Optional<Profile> getByName(ProfileNameVO name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByName'");
    }
    
}
