package burcak.library.libraryproject.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "publishers")

public class Publisher {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "pub_id", columnDefinition = "serial", unique = true, nullable = false)
    private Long id;

    @Column (name = "pub_name", nullable = false)
    private String name;

    @Column (name = "pub_establishment_year")
    private int establishmentYear;

    @Column (name = "pub_address")
    private String address;

    @OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY)
    private List<Book> bookList;

    public Publisher() {
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

    public int getEstablishmentYear() {
        return establishmentYear;
    }

    public void setEstablishmentYear(int establishmentYear) {
        this.establishmentYear = establishmentYear;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", establishmentYear=" + establishmentYear +
                ", address='" + address + '\'' +
                ", bookList=" + bookList +
                '}';
    }
}
