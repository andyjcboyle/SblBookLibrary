package com.jpmorgan.pb.sbl.sblBookLibrary.model.book;

import java.util.Collections;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.jpmorgan.pb.sbl.sblBookLibrary.common.Versioned;
import com.jpmorgan.pb.sbl.sblBookLibrary.model.people.Author;

@Entity
@Table(name="BOOK")
public class Book implements Versioned {

  @Id
  private long id;
  private String title;
  private String subtitle;
  private String edition;
  private Set<Author> authors = Collections.emptySet();

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSubtitle() {
    return subtitle;
  }

  public void setSubtitle(String subtitle) {
    this.subtitle = subtitle;
  }

  public Set<Author> getAuthors() {
    return authors;
  }

  public void setAuthors(Set<Author> authors) {
    this.authors = authors;
  }

  public String getEdition() {
    return edition;
  }

  public void setEdition(String edition) {
    this.edition = edition;
  }

  @Override
  public long getId() {
    return id;
  }

  @Override
  public void setId(long id) {
    this.id = id;
  }


}
