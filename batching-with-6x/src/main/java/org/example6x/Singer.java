package org.example6x;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Source;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "SINGER")
public class Singer {

  @Id
  private Long id;

  @Column(name = "FIRST_NAME", nullable = false)
  private String firstName;

  @Column(name = "LAST_NAME", nullable = false)
  private String lastName;

  @Column(name = "GENRE")
  private String genre;

  @Column(name = "createdAt")
  @CreationTimestamp(source = SourceType.VM)
  private Timestamp createdAt;

  @Column(name = "updatedAt")
  @UpdateTimestamp(source = SourceType.VM)
  private Timestamp updatedAt;

  // Default constructor is required by Hibernate
  public Singer() {}

  public Singer(String firstName, String lastName, String genre) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.genre = genre;
  }

  // Getters and Setters

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getFirstName() { return firstName; }
  public void setFirstName(String firstName) { this.firstName = firstName; }
  public String getLastName() { return lastName; }
  public void setLastName(String lastName) { this.lastName = lastName; }
  public String getGenre() { return genre; }
  public void setGenre(String genre) { this.genre = genre; }

  @Override
  public String toString() {
    return "Singer [id=" + id + ", firstName=" + firstName +
        ", lastName=" + lastName + ", genre=" + genre + "]";
  }
}