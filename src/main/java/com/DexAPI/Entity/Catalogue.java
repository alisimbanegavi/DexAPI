package com.DexAPI.Entity;

import lombok.*;

import java.util.List;
import javax.persistence.*;

@Entity(name = "Catalogue") // Creating Catalogue entity that maps to a table in our database
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "catalogue",
        uniqueConstraints = { // Establishing unique constraints for Collection entity
                @UniqueConstraint(
                        name = "catalogue_id_unique",
                        columnNames = "catalogue_id"
                )
        },
        indexes = @Index(name = "user", columnList = "catalogue_user_id")
        // Specifying how user id shows in table attached to catalogue
)
public class Catalogue
{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "catalogue_id",
            nullable = false, // id cannot be null
            updatable = false // id cannot be changed
    )
    @Id // primary key
    private Integer catalogueID;

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getCatalogueID() {
        return catalogueID;
    }

    public void setCatalogueID(Integer catalogueID) {
        this.catalogueID = catalogueID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Collection> getCollections() {
        return collections;
    }

    public void setCollections(List<Collection> collections) {
        this.collections = collections;
    }

    @Column(
            name = "catalogue_user_id",
            nullable = false // owner cannot be null
    )
    private Integer userID;

    @Column(
            name = "description",
            columnDefinition = "TEXT"
    )
    private String description; // information about the content of the catalogue

    // Relation between catalogue and user
    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinTable(name="users_catalogue",
            joinColumns = @JoinColumn(name = "catalogue_user_id", insertable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private User user;

    // Relation between catalogue and collections
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY) /* mapping many collections to one catalogue */
    @JoinTable(name = "catalogue_collection",
            joinColumns = @JoinColumn(name = "catalogue_id"),
            inverseJoinColumns = @JoinColumn(name = "collection_catalogue_id")
    )
    private List<Collection> collections;
}
