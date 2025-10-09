package Modules.Core.Models;

import java.time.LocalDate;
import java.util.Optional;

import Modules.Core.VO.CreatedVO;
import Modules.Core.VO.DeletedVO;
import Modules.Core.VO.IdVO;
import Modules.Core.VO.UpdatedVO;

public abstract class BaseModel {
    private final IdVO id;
    private final DeletedVO deleted;
    private final CreatedVO createdAt;
    private final UpdatedVO updatedAt;

    public BaseModel(
            final IdVO id,
            final DeletedVO deleted,
            final CreatedVO createdAt,
            final UpdatedVO updatedAt) {
        this.id = id;
        this.deleted = deleted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return this.id.getValue();
    }

    public Boolean getDeleted() {
        return this.deleted.getValue();
    }

    public LocalDate getCreatedAt() {
        return this.createdAt.getValue();
    }

    public Optional<LocalDate> getUpdatedAt() {
        return this.updatedAt.getValue();
    }
}
