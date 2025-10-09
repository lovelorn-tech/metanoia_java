package Modules.Auth.VO.Role;

import java.util.Optional;
import java.util.regex.Pattern;

import Modules.Core.Models.CustomException;
import Modules.Core.VO.IGenericVO;

public class RoleNameVO implements IGenericVO<String> {
    private final String value;

    public RoleNameVO(final String value) throws CustomException {
        this.value = value;
        validate();
    }

    public String getValue() {
        return this.value;
    }

    private void validate() throws CustomException {
        try {
            if (!Pattern.matches("^[A-Za-z]{3,20}$", this.value)) {
                throw new CustomException(
                        400,
                        "validate",
                        "RoleNameVO",
                        Optional.of("Role name format is invalid."),
                        Optional.of("Bad request. Invalid data."));
            }
        } catch (Exception ex) {
            if (ex instanceof CustomException)
                throw ex;
            else
                throw new CustomException(500, "validate", "RoleNameVO", Optional.of(ex.getMessage()),
                        Optional.of(null));
        }
    }
}
