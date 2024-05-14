package spring.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"users"})
@Builder
@Entity
@Table(name = "mark")
public class Mark implements BaseEntity<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @Builder.Default
    @OneToMany(mappedBy = "mark", fetch = FetchType.LAZY)
    private List<User> users = new ArrayList<>();

}
