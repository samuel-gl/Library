/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaguardadolibreria.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author SAMUEL
 */

@Entity
public class Book implements Serializable {
    @Id
    private Long isbn;
    private String title;
    private Integer year;
    private Integer totalCopies;
    private Integer lentCopies;
    private Integer availableCopies;
    private boolean alta;
    @ManyToOne
    private Author author;
    @ManyToOne
    private Editorial editorial;

    public Book() {
    }

    public Book(Long isbn, String title, Integer year, Integer totalCopies, Integer lentCopies, Integer availableCopies, boolean alta, Author author, Editorial editorial) {
        this.isbn = isbn;
        this.title = title;
        this.year = year;
        this.totalCopies = totalCopies;
        this.lentCopies = lentCopies;
        this.availableCopies = availableCopies;
        this.alta = alta;
        this.author = author;
        this.editorial = editorial;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(Integer totalCopies) {
        this.totalCopies = totalCopies;
    }

    public Integer getLentCopies() {
        return lentCopies;
    }

    public void setLentCopies(Integer lentCopies) {
        this.lentCopies = lentCopies;
    }

    public Integer getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(Integer availableCopies) {
        this.availableCopies = availableCopies;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.isbn);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (!Objects.equals(this.isbn, other.isbn)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Book{" + "isbn=" + isbn + ", title=" + title + ", year=" + year + ", totalCopies=" + totalCopies + ", lentCopies=" + lentCopies + ", availableCopies=" + availableCopies +  author.toString() + editorial.toString() + '}';
    }

                    
                    
}

