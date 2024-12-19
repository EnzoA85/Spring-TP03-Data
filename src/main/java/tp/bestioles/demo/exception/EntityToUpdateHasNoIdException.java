package tp.bestioles.demo.exception;

public class EntityToUpdateHasNoIdException extends RuntimeException {
    public EntityToUpdateHasNoIdException(String message) {
        super(message);
    }
}
