package Modules.Auth.Repositories.implementation;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// Models
import Modules.Auth.Models.Profile;
import Modules.Core.Models.Row;
import Modules.Core.Models.SqlParameter;

// Exceptions
import Modules.Core.Models.CustomException;

// Contexts
import Modules.Core.Repositories.contexts.DBContext;

// Interfaces
import Modules.Core.Repositories.contexts.IDBContext;
import Modules.Auth.Repositories.interfaces.IProfileRepository;
import Modules.Auth.Mappers.interfaces.IProfileMapper;

// Mappers
import Modules.Auth.Mappers.implementation.ProfileMapper;

// VO
import Modules.Core.VO.IdVO;
import Modules.Auth.VO.Profile.ProfileNameVO;

public class ProfileRepository implements IProfileRepository {
    private static Optional<ProfileRepository> instance = Optional.of(null);
    private IDBContext ctx;
    private IProfileMapper profileMapper;

    private ProfileRepository() {
        this.ctx = DBContext.getInstance();
        this.profileMapper = ProfileMapper.getInstance();
    }

    public static ProfileRepository getInstance() {
        if (ProfileRepository.instance.isEmpty()) {
            ProfileRepository.instance = Optional.of(new ProfileRepository());
        }
        return ProfileRepository.instance.get();
    }

    @Override
    public void save(Profile entity) throws CustomException {
        try {
            throw new UnsupportedOperationException("Unimplemented method 'save'");
        } catch (Exception ex) {
            if (ex instanceof CustomException)
                throw ex;
            else
                throw new CustomException(
                        500,
                        "save",
                        "ProfileRepository",
                        Optional.of(ex.getMessage()),
                        Optional.of(null));
        }
    }

    @Override
    public Optional<Profile> getById(IdVO id) throws CustomException {
        try {
            SqlParameter<String> paramId = new SqlParameter<String>("id", id.getValue());
            List<SqlParameter<? extends Object>> params = List.of();
            params.add(paramId);
            List<Row> rows = this.ctx.executeQuery("SP_Profile_Get_ById(:" + paramId.getName() + ")", params);
            return Optional.of(rows.isEmpty() ? null :
            this.profileMapper.rowToProfile(rows.getFirst()));
        } catch (Exception ex) {
            if (ex instanceof CustomException)
                throw ex;
            else
                throw new CustomException(
                        500,
                        "getById",
                        "ProfileRepository",
                        Optional.of(ex.getMessage()),
                        Optional.of(null));
        }
    }

    @Override
    public List<Profile> getAll(Optional<Boolean> deleted) throws CustomException {
        try {
            SqlParameter<Boolean> paramDeleted = new SqlParameter<Boolean>("deleted", deleted.orElseGet(null));
            List<SqlParameter<? extends Object>> params = List.of();
            params.addAll(Arrays.asList(paramDeleted));
            
            List<Row> rows = ctx.executeQuery("SP_Profile_Get_All(:" + paramDeleted.getName() + ")", params);
            List<Profile> profiles = List.of();
            for (Row row : rows) {
                profiles.add(this.profileMapper.rowToProfile(row));
            }

            return profiles;
        } catch (Exception ex) {
            if (ex instanceof CustomException)
                throw ex;
            else
                throw new CustomException(
                        500,
                        "getAll",
                        "ProfileRepository",
                        Optional.of(ex.getMessage()),
                        Optional.of(null));
        }
    }

    @Override
    public Optional<Profile> getByName(ProfileNameVO name) throws CustomException {
        try {
            SqlParameter<String> paramName = new SqlParameter<String>("name", name.getValue());
            List<SqlParameter<? extends Object>> params = List.of();
            params.add(paramName);
            List<Row> rows = this.ctx.executeQuery("SP_Profile_Get_ByName(:" + paramName.getName() + ")", params);
            return Optional.of(rows.isEmpty() ? null :
            this.profileMapper.rowToProfile(rows.getFirst()));
        } catch (Exception ex) {
            if (ex instanceof CustomException)
                throw ex;
            else
                throw new CustomException(
                        500,
                        "getByName",
                        "ProfileRepository",
                        Optional.of(ex.getMessage()),
                        Optional.of(null));
        }
    }

}
