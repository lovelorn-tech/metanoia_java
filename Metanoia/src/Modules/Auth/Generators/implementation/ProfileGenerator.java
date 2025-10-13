package Modules.Auth.Generators.implementation;

import java.time.LocalDate;
import java.util.Optional;

import Modules.Auth.Generators.interfaces.IProfileGenerator;
import Modules.Auth.Models.Profile;
import Modules.Auth.VO.Profile.ProfileNameVO;
import Modules.Core.Models.CustomException;
import Modules.Core.VO.CreatedVO;
import Modules.Core.VO.DeletedVO;
import Modules.Core.VO.IdVO;
import Modules.Core.VO.UpdatedVO;

public class ProfileGenerator implements IProfileGenerator {
    
    private static Optional<ProfileGenerator> instance = Optional.of(null);

    private ProfileGenerator() {}

    public static ProfileGenerator getInstance() {
        if (ProfileGenerator.instance.isEmpty()) {
            ProfileGenerator.instance = Optional.of(new ProfileGenerator());
        }
        return ProfileGenerator.instance.get();
    }

    public Profile generateNew(
        final String id,
        final String name,
        final Boolean deleted,
        final LocalDate createdAt,
        final Optional<LocalDate> updatedAt
    ) throws CustomException {
        return new Profile(
            new IdVO(id), 
            new ProfileNameVO(name), 
            new DeletedVO(deleted), 
            new CreatedVO(createdAt), 
            new UpdatedVO(updatedAt)
            );
    }
}
