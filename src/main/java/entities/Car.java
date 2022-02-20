package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Version;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int number;

    @Enumerated(EnumType.STRING)
    private Brand brand;
    private int date_of_manufacture;

    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date updated;

    private Boolean machine_in_stock;

    @Version
    private long version;

    @ManyToOne(cascade = CascadeType.ALL)
    private Clients clients;

    @ManyToMany
    private List<Region> regions;


    public Car(int number, Brand brand, int date_of_manufacture, Boolean machine_in_stock) {
        this.number = number;
        this.brand = brand;
        this.date_of_manufacture = date_of_manufacture;
        this.created = created;
        this.updated = updated;
        this.machine_in_stock = machine_in_stock;
        this.version = version;
    }

}
