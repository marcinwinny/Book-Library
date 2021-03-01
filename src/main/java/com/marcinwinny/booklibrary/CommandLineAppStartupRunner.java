package com.marcinwinny.booklibrary;

import com.google.gson.Gson;
import com.marcinwinny.booklibrary.dto.BookDto;
import com.marcinwinny.booklibrary.mapper.BookMapper;
import com.marcinwinny.booklibrary.model.Book;
import com.marcinwinny.booklibrary.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;

@Component
@AllArgsConstructor
public class CommandLineAppStartupRunner implements CommandLineRunner {
    private static final Logger LOG =
            LoggerFactory.getLogger(CommandLineAppStartupRunner.class);

    private final BookMapper bookMapper;
    private final BookRepository bookRepository;

    @Override
    public void run(String...args) throws Exception {
        LOG.info("I'm working on startup");
        readFromJSONFile("/Users/marcinwinny/Desktop/WTT/book-library/src/main/resources/books.json");
    }

    public void readFromJSONFile(String jsonFile) {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(jsonFile)) {
            Object obj = jsonParser.parse(reader);

            JSONObject object = (JSONObject) obj;

            JSONArray booksJsonList = (JSONArray) object.get("items");

            booksJsonList.forEach(book -> parseBookObject( (JSONObject) book) );

        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void parseBookObject(JSONObject jsonBook) {
        Gson gson = new Gson();
        BookDto bookDto = gson.fromJson(String.valueOf(jsonBook), BookDto.class);
        Book book = bookMapper.mapDtoToBook(bookDto);
//        System.out.println(book.getAccessInfo().getCountry().name());
        bookRepository.save(book);
    }
}