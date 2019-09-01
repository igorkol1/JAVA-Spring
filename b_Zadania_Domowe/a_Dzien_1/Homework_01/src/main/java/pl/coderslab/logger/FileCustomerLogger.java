package pl.coderslab.logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.time.LocalDateTime;

@Component()
@Primary
public class FileCustomerLogger implements CustomerLogger {

    private String fileName;


    public FileCustomerLogger(@Value("log.txt") String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void log() {
        String message = LocalDateTime.now() + " customer operation \n";

        try {
            Files.write(Paths.get(fileName), message.getBytes(), APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
