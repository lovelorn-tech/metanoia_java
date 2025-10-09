package Modules.Auth.Generators.interfaces;

import java.time.LocalDate;
import java.util.Optional;

import Modules.Auth.Models.Profile;
import Modules.Core.Models.CustomException;

public interface IProfileGenerator {
    public Profile generateNew(
            final String id,
            final String name,
            final Boolean deleted,
            final LocalDate createdAt,
            final Optional<LocalDate> updatedAt) throws CustomException;
}
