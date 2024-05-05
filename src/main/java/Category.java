package burcak.library.libraryproject.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="categories")

public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id", columnDefinition = "serial", unique = true, nullable = false)
    private Long id;

    @Column(name = "cat_name", length = 100, nullable = false)
    private String name;

    @Column(name = "cat_description", length = 200)
    private String description;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "category_of_book",
            joinColumns = {@JoinColumn(name = "category_of_book_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_of_category_id")})
    private List<Book> bookList;

    public Category() {
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", bookList=" + bookList +
                '}';
    }
}
