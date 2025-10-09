package Modules.Auth.VO.User;

import java.util.Optional;
import java.util.regex.Pattern;

import Modules.Core.Models.CustomException;
import Modules.Core.VO.IGenericVO;

public class UserSignatureVO implements IGenericVO<String> {
    private final String value;

    public UserSignatureVO(final String value) throws CustomException {
        this.value = value;
        validate();
    }

    public String getValue() {
        return this.value;
    }

    private void validate() throws CustomException {
        try {
            if (!Pattern.matches("^[A-Za-z0-9\s]{4,30}$", this.value)) {
                throw new CustomException(
                        400,
                        "validate",
                        "UserSignatureVO",
                        Optional.of("User signature format is invalid"),
                        Optional.of("User signature format is invalid"));
            }
        } catch (Exception ex) {
            if (ex instanceof CustomException)
                throw ex;
            else
                throw new CustomException(500, "validate", "UserSignatureVO", Optional.of(ex.getMessage()),
                        Optional.of(null));
        }
    }
}
