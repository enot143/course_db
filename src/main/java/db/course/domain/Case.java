package db.course.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Set;
//TODO:manytomany
@Entity
@Data
@Table(name = "\"case\"")
@ToString(of = {"id", "client", "address", "name", "start_date", "end_date"})
@EqualsAndHashCode(of = {"id"})
public class Case {
    @Id
    @Column(name = "case_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    private Client client;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address address;
    @Column(name = "\"name\"")
    private String name;
    private Date start_date;
    private Date end_date;
}
