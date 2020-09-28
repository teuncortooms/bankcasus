package Exceptions;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;

public class FileReaderException extends Throwable {
    public FileReaderException(IOException e) {
    }

    public FileReaderException(JsonMappingException e) {
    }
}
