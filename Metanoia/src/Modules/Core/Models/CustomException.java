package Modules.Core.Models;

import java.time.LocalDate;
import java.util.Optional;

public class CustomException extends Exception {
    private final int status;
    private final String method;
    private final String file;
    private final String message;
    private final String publicMessage;
    
    public CustomException(
        final int status,
        final String method,
        final String file,
        final Optional<String> message,
        final Optional<String> publicMessage
    ) {
        this.message = message.isEmpty() ? "Fatal: Unknown error!" : message.get();
        this.publicMessage = publicMessage.isEmpty() ? "Something went wrong!" : publicMessage.get();
        super(message.isEmpty() ? "Fatal: Unknown error!" : message.get());
    }

    public int getStatus() {
        return this.status;
    }

    public String getMessage() {
        return "Status '" + this.status +"' | " + LocalDate.now() + " | '" + this.method +"' method in '" + this.file  + "' file | Message => " + this.message;
    }

    public String getPublicMessage() {
        return this.publicMessage;
    }
}
