package tp.bestioles.demo.dto;

import java.time.LocalDateTime;
import java.util.List;

public class InvalidEntityErrorDto extends ErrorDto {
    private List<String> globalErrors;
    private List<String> fieldErrors;

    public InvalidEntityErrorDto(LocalDateTime timestamp, String message, String path, List<String> globalErrors, List<String> fieldErrors) {
        super(timestamp, message, path);
        this.globalErrors = globalErrors;
        this.fieldErrors = fieldErrors;
    }

    public List<String> getGlobalErrors() {
        return globalErrors;
    }

    public void setGlobalErrors(List<String> globalErrors) {
        this.globalErrors = globalErrors;
    }

    public List<String> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(List<String> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }
}
