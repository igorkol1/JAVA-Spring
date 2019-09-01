package pl.coderslab.services;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class WorkerService {

    //Relative path is not working on tomcat
    //TODO Find a way to replace it
    private static final String FILE_NAME = "/Users/igorkolodziejczyk/Projects/WAR_JEE_W_09_Spring/b_Zadania_Domowe/a_Dzien_2/Homework_02/Workers.txt";

    public List<String> readAllWorkers() {
        try (Stream<String> stream = Files.lines(Paths.get(FILE_NAME))) {

            return stream.collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public String readRandomWorker() {
        Random random = new Random();
        List<String> worker = readAllWorkers();
        return worker.get(random.nextInt(worker.size()));
    }
}
