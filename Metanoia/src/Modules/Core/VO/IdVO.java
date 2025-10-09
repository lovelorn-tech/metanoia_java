package Modules.Core.VO;

import Modules.Core.Models.CustomException;

import java.util.Optional;
import java.util.regex.Pattern;

public class IdVO implements IGenericVO<String> {
    private final String value;

    public IdVO(final String value) throws CustomException {
        this.value = value;
        validate();
    }

    public String getValue() {
        return this.value;
    }

    private void validate() throws CustomException {
        try {
            if (!Pattern.matches("^[\\da-f]{8}(?:-[\\da-f]{4}){3}-[\\da-f]{12}$", this.value)) {
                throw new CustomException(
                        400,
                        "validate",
                        "IdVO",
                        Optional.of("Id format is invalid, must be of type guid"),
                        Optional.of("Bad request. Invalid data"));
            }
            // ^[\da-f]{8}(?:-[\da-f]{4}){3}-[\da-f]{12}$
        } catch (Exception ex) {
            if (ex instanceof CustomException)
                throw ex;
            else
                throw new CustomException(500, "validate", "IdVO", Optional.of(ex.getMessage()),
                        Optional.of(null));
        }
    }
}
