package com.marcinwinny.booklibrary.configuration;

import com.google.gson.Gson;
import com.marcinwinny.booklibrary.dto.BookDto;
import com.marcinwinny.booklibrary.mapper.BookMapper;
import com.marcinwinny.booklibrary.model.Book;
import com.marcinwinny.booklibrary.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(CommandLineAppStartupRunner.class);
    @Autowired
    private BookRepository bookRepository;

    private BookMapper bookMapper = BookMapper.INSTANCE;

    @Override
    public void run(String... args) {
        readFromJSONFile("src/main/resources/books.json");
        LOG.info("Loaded from file");
    }

    private void readFromJSONFile(String jsonFile) {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(jsonFile)) {
            Object obj = jsonParser.parse(reader);

            JSONObject object = (JSONObject) obj;

            JSONArray booksJsonList = (JSONArray) object.get("items");

            booksJsonList.forEach(book -> parseBookObject((JSONObject) book));

        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseBookObject(JSONObject jsonBook) {
        Gson gson = new Gson();
        BookDto bookDto = gson.fromJson(String.valueOf(jsonBook), BookDto.class);
        Book book = bookMapper.mapDtoToBook(bookDto);
        bookRepository.save(book);
    }
}
