package Modules.Core.VO;

import java.time.LocalDate;
import java.util.Optional;

import Modules.Core.Models.CustomException;

public class UpdatedVO implements IGenericVO<Optional<LocalDate>> {
    private final Optional<LocalDate> value;

    public UpdatedVO(final Optional<LocalDate> value) throws CustomException {
        this.value = value;
        validate();
    }

    public Optional<LocalDate> getValue() {
        return this.value;
    }

    private void validate() throws CustomException {
        try {
            if (this.value.isPresent() && LocalDate.now().compareTo(this.value.get()) < 0) {
                throw new CustomException(
                        400,
                        "validate",
                        "UpdatedVO",
                        Optional.of("Updated date can not be greater than the current date"),
                        Optional.of("Updated date can not be greater than the current date"));
            }
        } catch (Exception ex) {
            if (ex instanceof CustomException)
                throw ex;
            else
                throw new CustomException(500, "validate", "UpdatedVO", Optional.of(ex.getMessage()),
                        Optional.of(null));
        }
    }
}
