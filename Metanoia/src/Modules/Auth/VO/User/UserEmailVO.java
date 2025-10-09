package Modules.Auth.VO.User;

import java.util.Optional;
import java.util.regex.Pattern;

import Modules.Core.Models.CustomException;
import Modules.Core.VO.IGenericVO;

public class UserEmailVO implements IGenericVO<String> {
    private final String value;

    public UserEmailVO(final String value) throws CustomException{
        this.value = value;
        validate();
    }

    public String getValue() {
        return this.value;
    }

    private void validate() throws CustomException {
        try {
            if (!Pattern.matches("/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$/", this.value)) {
                throw new CustomException(
                    400, 
                    "validate", 
                    "UserEmailVO", 
                    Optional.of("User email format is invalid"),
                    Optional.of("User email format is invalid")
                );
            }
        } catch(Exception ex) {
            if (ex instanceof CustomException) throw ex;
            else throw new CustomException(500, "validate", "UserEmailVO", Optional.of(ex.getMessage()),
                        Optional.of(null));
        }
    }
}
