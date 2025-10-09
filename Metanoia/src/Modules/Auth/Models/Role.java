package Modules.Auth.Models;

import java.util.Collections;
import java.util.List;

import Modules.Auth.VO.Role.RoleNameVO;
import Modules.Core.Models.BaseModel;
import Modules.Core.VO.CreatedVO;
import Modules.Core.VO.DeletedVO;
import Modules.Core.VO.IdVO;
import Modules.Core.VO.UpdatedVO;

public class Role extends BaseModel {
    private final RoleNameVO name;

    private List<Role> roles = Collections.emptyList();

    public Role(
            final IdVO id,
            final RoleNameVO name,
            final DeletedVO deleted,
            final CreatedVO createdAt,
            final UpdatedVO updatedAt) {
        this.name = name;
        super(id, deleted, createdAt, updatedAt);
    }

    public String getName() {
        return this.name.getValue();
    }

    public List<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
