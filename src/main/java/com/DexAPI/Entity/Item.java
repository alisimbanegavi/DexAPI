package com.DexAPI.Entity;

import lombok.*;

import javax.persistence.*;
// TODO MERGE CONTROLLER, SERVICE, AND REPO WITH YACINE'S CHANGES

@Entity(name = "Item") // Creating Item entity that maps to a table in our database
@AllArgsConstructor
@NoArgsConstructor
@Data // @Data is like having implicit @Getter, @Setter, @ToString, @EqualsAndHashCode and @RequiredArgsConstructor
@Table(
        name = "item",
        uniqueConstraints = { // Establishing unique constraints for Item entity
                @UniqueConstraint(
                        name = "item_id_unique",
                        columnNames = "item_id"
                ),
                @UniqueConstraint(
                        name = "item_name_unique",
                        columnNames = "item_name"
                )
        },
        indexes = @Index(name = "collection", columnList = "item_collection_id")
        // Specifying how collection id shows in table attached to item
)
public class Item {
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(
            name = "item_id",
            nullable = false // id cannot be null
    )
    @Id // primary key
    private Integer itemID; // Item id

    @Column(
            name = "item_name",
            columnDefinition = "TEXT",
            nullable = false // item name cannot be null
    )
    private String itemName; // item name

    @Column(
            name = "description",
            columnDefinition = "TEXT"
    )
    private String description; // info about the item

    @Column(
            name = "item_collection_id",
            insertable = false,
            updatable = false
    )
    private Integer collectionID; // ID of collection that item beIntegers to

    @Column(
            name = "item_date"
    )
    private java.sql.Date itemDate; // Date that item was created/found

    @ManyToOne(targetEntity = Collection.class, fetch = FetchType.LAZY) /* mapping many items to one collection */
    @JoinTable(name="collection_item",
            joinColumns = @JoinColumn(name = "item_collection_id"),
            inverseJoinColumns = @JoinColumn(name = "collection_id")
    )
    private Collection collection; // the collection this item beIntegers to
}