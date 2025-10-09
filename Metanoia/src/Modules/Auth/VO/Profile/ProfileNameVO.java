package Modules.Auth.VO.Profile;

import java.util.Optional;
import java.util.regex.Pattern;

// Exceptions
import Modules.Core.Models.CustomException;

// VO
import Modules.Core.VO.IGenericVO;

public class ProfileNameVO implements IGenericVO<String> {
    private String value;

    public ProfileNameVO(final String value) throws CustomException{
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
                        "ProfileNameVO",
                        Optional.of("Profile name format is invalid."),
                        Optional.of("Bad request. Invalid data."));
            }
        } catch(Exception ex) {
            if (ex instanceof CustomException) throw ex;
            else throw new CustomException(
                    500, 
                    "validate", 
                    "ProfileNameVO", 
                    Optional.of(ex.getMessage()), 
                    Optional.of(null)
                );
        }
    }
}
