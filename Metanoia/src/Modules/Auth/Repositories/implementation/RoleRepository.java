package Modules.Auth.Repositories.implementation;

import java.util.List;
import java.util.Optional;

// Models
import Modules.Auth.Models.Profile;
import Modules.Auth.Models.Role;
import Modules.Core.Models.Row;
import Modules.Core.Models.SqlParameter;

// Exceptions
import Modules.Core.Models.CustomException;

// Interfaces
import Modules.Auth.Repositories.interfaces.IRoleRepository;
import Modules.Core.Repositories.contexts.IDBContext;
import Modules.Auth.Mappers.interfaces.IRoleMapper;

// Contexts
import Modules.Core.Repositories.contexts.DBContext;

// VO
import Modules.Auth.VO.Role.RoleNameVO;
import Modules.Core.VO.IdVO;

// Mappers
import Modules.Auth.Mappers.implementation.RoleMapper;

public class RoleRepository implements IRoleRepository {
    private static Optional<RoleRepository> instance = Optional.of(null);
    private IDBContext ctx;
    private IRoleMapper roleMapper;

    private RoleRepository() {
        this.ctx = DBContext.getInstance();
        this.roleMapper = RoleMapper.getInstance();
    }

    public static RoleRepository getInstance() {
        if (RoleRepository.instance.isEmpty()) {
            RoleRepository.instance = Optional.of(new RoleRepository());
        }
        return RoleRepository.instance.get();
    }

    @Override
    public void save(Role entity) throws CustomException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Optional<Role> getById(IdVO id) throws CustomException {
        try {
            SqlParameter<String> paramId = new SqlParameter<String>("id", id.getValue());
            List<SqlParameter<? extends Object>> params = List.of();
            params.add(paramId);
            List<Row> rows = this.ctx.executeQuery("SP_Role_Get_ById(:" + paramId.getName() + ")", params);
            return Optional.of(rows.isEmpty() ? null :
            this.roleMapper.rowToRole(rows.getFirst()));
        } catch (Exception ex) {
            if (ex instanceof CustomException)
                throw ex;
            else
                throw new CustomException(
                        500,
                        "getById",
                        "RoleRepository",
                        Optional.of(ex.getMessage()),
                        Optional.of(null));
        }
    }

    @Override
    public List<Role> getAll(Optional<Boolean> deleted) throws CustomException {
        try {
            SqlParameter<Boolean> paramDeleted = new SqlParameter<Boolean>("deleted", deleted.orElseGet(null));
            List<SqlParameter<? extends Object>> params = List.of();
            params.add(paramDeleted);
            List<Row> rows = this.ctx.executeQuery("SP_Role_Get_All(:" + paramDeleted.getName() + ")", params);
            List<Role> roles = List.of();
            for (Row row : rows) {
                roles.add(this.roleMapper.rowToRole(row));
            }
            return roles;
        } catch (Exception ex) {
            if (ex instanceof CustomException)
                throw ex;
            else
                throw new CustomException(
                        500,
                        "getAll",
                        "RoleRepository",
                        Optional.of(ex.getMessage()),
                        Optional.of(null));
        }
    }

    @Override
    public Optional<Role> getByName(RoleNameVO name) throws CustomException {
        try {
            SqlParameter<String> paramName = new SqlParameter<String>("name", name.getValue());
            List<SqlParameter<? extends Object>> params = List.of();
            params.add(paramName);
            List<Row> rows = this.ctx.executeQuery("SP_Role_Get_ByName(:" + paramName.getName() + ")", params);
            return Optional.of(rows.isEmpty() ? null :
            this.roleMapper.rowToRole(rows.getFirst()));
        } catch (Exception ex) {
            if (ex instanceof CustomException)
                throw ex;
            else
                throw new CustomException(
                        500,
                        "getByName",
                        "RoleRepository",
                        Optional.of(ex.getMessage()),
                        Optional.of(null));
        }
    }

    @Override
    public List<Role> getByProfile(Profile profile) throws CustomException {
        try {
            SqlParameter<String> paramProfileId = new SqlParameter<String>("profileId", profile.getId());
            List<SqlParameter<? extends Object>> params = List.of();
            params.add(paramProfileId);
            List<Row> rows = this.ctx.executeQuery("SP_Role_Get_ByProfile(:" + paramProfileId.getName() + ")", params);
            List<Role> roles = List.of();
            for (Row row : rows) {
                roles.add(this.roleMapper.rowToRole(row));
            }
            return roles;
        } catch (Exception ex) {
            if (ex instanceof CustomException)
                throw ex;
            else
                throw new CustomException(
                        500,
                        "getByProfile",
                        "RoleRepository",
                        Optional.of(ex.getMessage()),
                        Optional.of(null));
        }
    }

    @Override
    public List<Role> getByRole(Role role) throws CustomException {
        try {
            SqlParameter<String> paramRoleId = new SqlParameter<String>("roleId", role.getId());
            List<SqlParameter<? extends Object>> params = List.of();
            params.add(paramRoleId);
            List<Row> rows = this.ctx.executeQuery("SP_Role_Get_ByProfile(:" + paramRoleId.getName() + ")", params);
            List<Role> roles = List.of();
            for (Row row : rows) {
                roles.add(this.roleMapper.rowToRole(row));
            }
            return roles;
        } catch (Exception ex) {
            if (ex instanceof CustomException)
                throw ex;
            else
                throw new CustomException(
                        500,
                        "getByRole",
                        "RoleRepository",
                        Optional.of(ex.getMessage()),
                        Optional.of(null));
        }
    }
    
}
