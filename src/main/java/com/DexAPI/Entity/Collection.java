package com.DexAPI.Entity;

import lombok.*;

import java.util.List;
import javax.persistence.*;

@Entity(name = "Collection") // Creating Collection entity that maps to a table in our database
@AllArgsConstructor
@NoArgsConstructor
@Data // @Data is like having implicit @Getter, @Setter, @ToString, @EqualsAndHashCode and @RequiredArgsConstructor
@Table(
        name = "collection",
        uniqueConstraints = { // Establishing unique constraints for Collection entity
                @UniqueConstraint(
                        name = "collection_id_unique",
                        columnNames = "collection_id"
                ),
                @UniqueConstraint(
                        name = "collection_name_unique",
                        columnNames = "collection_name"
                )
        },
        indexes = @Index(name = "catalogue", columnList = "collection_catalogue_id")
        // Specifying how catalogue id shows in table attached to collection
)
public class Collection {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "collection_id",
            nullable = false, // id cannot be null
            updatable = false //id cannot be changed
    )
    @Id // primary key
    private Integer collectionID;

    @Column(
            name ="collection_name",
            nullable = false, // name cannot be null
            columnDefinition = "TEXT"
    )
    private String collectionName;

    @Column(
            name = "description",
            columnDefinition = "TEXT"
    )
    private String description; // info about the content of the collection

    @Column(
            name = "collection_catalogue_id",
            insertable = false,
            updatable = false,
            nullable = false // collection id cannot be null
    )
    private Integer catalogueID; // ID of collection that item beIntegers to

    @ManyToOne(targetEntity = Catalogue.class, fetch = FetchType.LAZY) /* mapping many collections to one catalogue */
    @JoinTable(name="catalogue_collection",
            joinColumns = @JoinColumn(name = "collection_catalogue_id"),
            inverseJoinColumns = @JoinColumn(name = "catalogue_id")
    )
    private Catalogue catalogue;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY) /* mapping many items to one collection */
    @JoinTable(name = "collection_item",
            joinColumns = @JoinColumn(name = "collection_id"),
            inverseJoinColumns = @JoinColumn(name = "item_collection_id")
    )
    private List<Item> items;
}
