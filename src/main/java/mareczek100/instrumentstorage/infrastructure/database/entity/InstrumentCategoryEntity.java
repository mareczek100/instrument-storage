package mareczek100.instrumentstorage.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "instrument_category")
@EqualsAndHashCode(of = "category")
@ToString(exclude = "instruments")
public class InstrumentCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "instrument_category_id")
    private Short instrumentCategoryId;

    @Column(name = "name", unique = true)
    private InstrumentCategoryName category;

    @OneToMany(mappedBy = "category")
    private Set<InstrumentEntity> instruments;
}