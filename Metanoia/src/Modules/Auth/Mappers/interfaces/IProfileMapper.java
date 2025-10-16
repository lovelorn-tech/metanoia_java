package Modules.Auth.Mappers.interfaces;

import Modules.Auth.Models.Profile;
import Modules.Core.Models.Row;

public interface IProfileMapper {
    Profile rowToProfile(Row row);
}
