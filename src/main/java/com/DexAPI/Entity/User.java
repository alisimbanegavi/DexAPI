package com.DexAPI.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "User")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data // @Data is like having implicit @Getter, @Setter, @ToString, @EqualsAndHashCode
      // and @RequiredArgsConstructor
@Table(name = "users", uniqueConstraints = { // Establishing unique constraints for User entity
    @UniqueConstraint(name = "user_id_unique", columnNames = "user_id"),
    @UniqueConstraint(name = "username_unique", columnNames = "username") })
public class User {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @org.hibernate.annotations.ColumnDefault("")
  @Column(name = "user_id", nullable = false // user id cannot be null
  )
  // primary key
  @Id
  private Integer userID; // unique user id

  @Column(name = "username", columnDefinition = "TEXT", nullable = false // username cannot be null
  )
  private String userName; // username chosen by user

  @Column(name = "password", columnDefinition = "TEXT", nullable = false, // password cannot be null
      length = 64)
  private String password; // password chosen by user

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY) /* mapping many catalogues to one user */
  @JoinTable(name = "users_catalogue", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "catalogue_user_id"))
  private List<Catalogue> catalogues;
}
