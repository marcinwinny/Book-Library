# Book-Library
Book library management platform which goal is to enable libraries to share information about their book collections
with customers. 

### Technologies
* Java
* Spring Framework - platform that provides comprehensive infrastructure support for developing Java applications
* Apache Maven - project management and comprehension tool
* H2 Database Engine - Java SQL database, in-memory databases
* Project Lombok - Java library for automatically complement boilerplate code 
* Mapstruct - code generator that simplifies the implementation of mappings
* Guava - set of core Java libraries from Google, Guava Cache was especially used
* JUnit 5 - testing framework

### How to run
 Build the application, deploy it and run tests.
```sh
mvn deploy
```
 Run application
```sh
java -jar target/book-library-0.0.1-SNAPSHOT.jar
```
 Run application with given dataset
```sh
java -jar target/book-library-0.0.1-SNAPSHOT.jar [path-to-file]
```

### API endpoints
#### Book details endpoint
Returns a book identified by the given ISBN number in the form of a JSON document. Returns a 404 if the book does not exist in the data set.
```sh
GET: /api/books/by-isbn/{isbn}
```
#### Books category endpoint
Returns a list of all books that are assigned to the requested category.
```sh
GET: /api/books/by-category/{category}
```
#### Book volume endpoint
Returns first book, which number of pages is greater than specified value. 
```sh
GET: /api/books/pages-greater-than/{pages}
```
#### The best books endpoint
Returns JSON document with a list of the best rated books which can be read in month. User can specify the number of pages he can read per hour and average number of hours he spends on reading during the day. 
```sh
GET: /api/books/best-books/{howManyPages}/{howManyHours}
```
#### Recently viewed books
Returns JSON document with a list of 5 books recently viewed via details endpoint (described previously).
```sh
GET: /api/books/recently-viewed
```
#### Rating endpoint
Returns JSON document with a list of all authors and their rating in descending order of the average rating of their books.
```sh
GET: /api/authors/ratings
```
