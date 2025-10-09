package Modules.Auth.Models;

import Modules.Auth.VO.User.UserDescriptionVO;
import Modules.Auth.VO.User.UserEmailVO;
import Modules.Auth.VO.User.UserPasswordVO;
import Modules.Auth.VO.User.UserSignatureVO;
import Modules.Auth.VO.User.UserUsernameVO;
import Modules.Core.Models.BaseModel;
import Modules.Core.VO.CreatedVO;
import Modules.Core.VO.DeletedVO;
import Modules.Core.VO.IdVO;
import Modules.Core.VO.UpdatedVO;

public class User extends BaseModel {
    private final UserUsernameVO username;
    private final UserPasswordVO password;
    private final UserEmailVO email;
    private final UserDescriptionVO description;
    private final UserSignatureVO signature;
    private final Profile profile;
    private final Boolean active;

    public User(
            final IdVO id,
            final UserUsernameVO username,
            final UserPasswordVO password,
            final UserEmailVO email,
            final UserDescriptionVO description,
            final UserSignatureVO signature,
            final Profile profile,
            final Boolean active,
            final DeletedVO deleted,
            final CreatedVO createdAt,
            final UpdatedVO updatedAt) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.description = description;
        this.signature = signature;
        this.profile = profile;
        this.active = active;
        super(id, deleted, createdAt, updatedAt);
    }

    public String getUsername() {
        return this.username.getValue();
    }

    public String getPassword() {
        return this.password.getValue();
    }

    public String getEmail() {
        return this.email.getValue();
    }

    public String getDescription() {
        return this.description.getValue();
    }

    public String getSignature() {
        return this.signature.getValue();
    }

    public Boolean getActive() {
        return this.active;
    }

    public Profile getProfile() {
        return this.profile;
    }

}
