package Modules.Core.VO;

import java.time.LocalDate;
import java.util.Optional;

import Modules.Core.Models.CustomException;

public class CreatedVO implements IGenericVO<LocalDate> {
    private final LocalDate value;

    public CreatedVO(final LocalDate value) throws CustomException {
        this.value = value;
        validate();
    }

    public LocalDate getValue() {
        return this.value;
    }

    private void validate() throws CustomException {
        try {
            if (LocalDate.now().compareTo(this.value) < 0) {
                throw new CustomException(
                        400,
                        "validate",
                        "CreatedVO",
                        Optional.of("Created date can not be greater than the current date"),
                        Optional.of("Created date can not be greater than the current date"));
            }
        } catch (Exception ex) {
            if (ex instanceof CustomException)
                throw ex;
            else
                throw new CustomException(
                        500,
                        "validate",
                        "CreatedVO",
                        Optional.of(ex.getMessage()),
                        Optional.of(null));
        }
    }
}
