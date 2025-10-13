package Modules.Auth.Generators.implementation;

import java.time.LocalDate;
import java.util.Optional;

import Modules.Auth.Models.Role;
import Modules.Auth.VO.Role.RoleNameVO;
import Modules.Core.Models.CustomException;
import Modules.Core.VO.CreatedVO;
import Modules.Core.VO.DeletedVO;
import Modules.Core.VO.IdVO;
import Modules.Core.VO.UpdatedVO;

public class RoleGenerator {

    private static Optional<RoleGenerator> instance = Optional.of(null);

    private RoleGenerator() {
    }

    public static RoleGenerator getInstance() {
        if (RoleGenerator.instance.isEmpty()) {
            RoleGenerator.instance = Optional.of(new RoleGenerator());
        }
        return RoleGenerator.instance.get();
    }

    public Role generateNew(
            final String id,
            final String name,
            final Boolean deleted,
            final LocalDate createdAt,
            final Optional<LocalDate> updatedAt) throws CustomException {
        return new Role(
                new IdVO(id),
                new RoleNameVO(name),
                new DeletedVO(deleted),
                new CreatedVO(createdAt),
                new UpdatedVO(updatedAt));
    }
}
