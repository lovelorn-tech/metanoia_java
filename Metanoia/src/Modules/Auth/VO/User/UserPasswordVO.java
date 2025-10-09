package Modules.Auth.VO.User;

import java.util.Optional;
import java.util.regex.Pattern;

import Modules.Core.Models.CustomException;
import Modules.Core.VO.IGenericVO;

public class UserPasswordVO implements IGenericVO<String> {
    private final String value;

    public UserPasswordVO(final String value, final Optional<Boolean> isHash) throws CustomException{
        this.value = value;
        if (isHash.isEmpty() || isHash.get() == false){
            validate();
        }
    }

    public String getValue() {
        return this.value;
    }

    private void validate() throws CustomException {
        try {
            if (!Pattern.matches("/^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])([A-Za-z\\d$@$!%*?&]|[^ ]){12,30}$/", this.value)) {
                throw new CustomException(
                    400, 
                    "validate", 
                    "UserPasswordVO", 
                    Optional.of("User password format is invalid"),
                    Optional.of("User password format is invalid")
                );
            }
        } catch(Exception ex) {
            if (ex instanceof CustomException) throw ex;
            else throw new CustomException(500, "validate", "UserPasswordVO", Optional.of(ex.getMessage()),
                        Optional.of(null));
        }
    }
}
