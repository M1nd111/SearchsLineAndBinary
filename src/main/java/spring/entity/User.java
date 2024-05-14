package spring.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user", schema = "dataspring")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) сущность с данной аннотацией
// от которой будут наследоваться другие сущности. Hibernate будет мапить на единую таблицу в бд
// подлкючили кжширование во второй уровень юзера
// region - добавили настройки кэширования
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "User")
public class User implements BaseEntity<Long>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "time")
    private LocalTime time;

    @Embedded
    private PersonalInfo personalInfo;

    @Column(name = "mark_name", nullable = false)
    private String mark;

    @Column(name = "application_number", unique = true, nullable = false)
    private Long applicationNumber;

}
