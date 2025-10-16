package Modules.Auth.Mappers.implementation;

import java.util.Optional;

import Modules.Auth.Mappers.interfaces.IProfileMapper;
import Modules.Auth.Models.Profile;
import Modules.Core.Models.Row;

public class ProfileMapper implements IProfileMapper {
    private static Optional<ProfileMapper> instance = Optional.of(null);

    private ProfileMapper() {}

    public static ProfileMapper getInstance() {
        if (ProfileMapper.instance.isEmpty()) {
            ProfileMapper.instance = Optional.of(new ProfileMapper());
        }
        return ProfileMapper.instance.get();
    }

    @Override
    public Profile rowToProfile(Row row) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'rowToProfile'");
    }
    
}
