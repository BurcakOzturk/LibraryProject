package burcak.library.libraryproject.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "borrowings")
public class BookBorrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrow_book_id")
    private int id;

    @Column(name = "borrow_book_name", nullable = false)
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "book_borrow_date")
    private LocalDate borrowing_date;

    @Temporal(TemporalType.DATE)
    @Column(name = "book_return_date")
    private LocalDate return_date;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "book_borrow_id", referencedColumnName = "book_id")
    private Book book;

    public BookBorrowing() {
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBorrowing_date() {
        return borrowing_date;
    }

    public void setBorrowing_date(LocalDate borrowing_date) {
        this.borrowing_date = borrowing_date;
    }

    public LocalDate getReturn_date() {
        return return_date;
    }

    public void setReturn_date(LocalDate return_date) {
        this.return_date = return_date;
    }

    @Override
    public String toString() {
        return "FollowBorrowBook{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", borrowing_date=" + borrowing_date +
                ", return_date=" + return_date +
                ", book=" + book +
                '}';
    }
}
