package course.springframework.WebApp.domain;

import javax.persistence.*;
import java.util.Set;
@Entity       //Bu classin bir jpa entity yani veri tabani tablosunu oldugunu belirtir.
public class Author {
    @Id  //Bu kolonun id kolonu oldugunu belirtir.
    @GeneratedValue(strategy = GenerationType.AUTO) // Bu satir id nin database tarafinda uretilecegini belirtir.
    private Long id;

    private String firstName;
    private String lastName;
    @ManyToMany(mappedBy = "authors") // tablolar arasi many2many iliski kurulmasi icin yazilmis bir anotasyon
    private Set<Book> books;

    public Author() {
    }

    public Author(String firstName, String lastName, Set<Book> books) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
