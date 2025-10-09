package Modules.Core.VO;

import java.util.Optional;

import Modules.Core.Models.CustomException;

public class DeletedVO implements IGenericVO<Boolean> {
    private final Boolean value;

    public DeletedVO(final Boolean value) throws CustomException {
        this.value = value;
        validate();
    }

    public Boolean getValue() {
        return this.value;
    }

    private void validate() throws CustomException {
        try {

        } catch (Exception ex) {
            if (ex instanceof CustomException)
                throw ex;
            else
                throw new CustomException(500, "validate", "DeletedVO", Optional.of(ex.getMessage()),
                        Optional.of(null));
        }
    }
}
