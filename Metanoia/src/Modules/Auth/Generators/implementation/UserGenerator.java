package Modules.Auth.Generators.implementation;

import java.time.LocalDate;
import java.util.Optional;

// Models
import Modules.Auth.Models.*;

// Interfaces
import Modules.Auth.Generators.interfaces.IUserGenerator;

// VO
import Modules.Auth.VO.User.UserDescriptionVO;
import Modules.Auth.VO.User.UserEmailVO;
import Modules.Auth.VO.User.UserPasswordVO;
import Modules.Auth.VO.User.UserSignatureVO;
import Modules.Auth.VO.User.UserUsernameVO;
import Modules.Core.Models.CustomException;
import Modules.Core.VO.CreatedVO;
import Modules.Core.VO.DeletedVO;
import Modules.Core.VO.IdVO;
import Modules.Core.VO.UpdatedVO;


public class UserGenerator implements IUserGenerator {
    
    private static Optional<UserGenerator> instance = Optional.of(null);

    private UserGenerator(){}

    public static UserGenerator getInstance() {
        if (UserGenerator.instance.isEmpty()){
            UserGenerator.instance = Optional.of(new UserGenerator());
        }
        return UserGenerator.instance.get();
    }

    public User generateNew(
        final String id,
        final String username,
        final String password,
        final String email,
        final String description,
        final String signature,
        final Profile profile,
        final Boolean active,
        final Boolean deleted,
        final LocalDate createdAt,
        final Optional<LocalDate> updatedAt,
        final Optional<Boolean> isHash
    ) throws CustomException {
        return new User(
            new IdVO(id), 
            new UserUsernameVO(username), 
            new UserPasswordVO(password, isHash), 
            new UserEmailVO(email), 
            new UserDescriptionVO(description), 
            new UserSignatureVO(signature), 
            profile,
            active, 
            new DeletedVO(deleted), 
            new CreatedVO(createdAt), 
            new UpdatedVO(updatedAt)
        );
    }
}
