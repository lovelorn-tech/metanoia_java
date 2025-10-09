package Modules.Auth.Generators.interfaces;

import java.time.LocalDate;
import java.util.Optional;

// Models
import Modules.Auth.Models.*;
import Modules.Core.Models.CustomException;

public interface IUserGenerator {
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
    ) throws CustomException;
}
