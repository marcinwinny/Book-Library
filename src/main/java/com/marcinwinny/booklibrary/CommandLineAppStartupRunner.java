package com.marcinwinny.booklibrary;

import com.google.gson.Gson;
import com.marcinwinny.booklibrary.model.Book;
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
public class CommandLineAppStartupRunner implements CommandLineRunner {
    private static final Logger LOG =
            LoggerFactory.getLogger(CommandLineAppStartupRunner.class);

    @Override
    public void run(String...args) throws Exception {
        LOG.info("I'm working on startup");
        readFromJSONFile("/Users/marcinwinny/Desktop/WTT/book-library/src/main/resources/books.json");
    }

    public static void readFromJSONFile(String jsonFile) {
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

    public static void parseBookObject(JSONObject jsonBook) {
//        Get book object within list
        String id = (String) jsonBook.get("etag");
        System.out.println(id);
//        String y = jsonBook.toString();

        Gson gson = new Gson();
//        Book book = gson.fromJson(y, Book.class);

    }
}