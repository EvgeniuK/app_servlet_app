package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Region {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String grodno;
    private String vitebsk;
    private String minsk;
    private String brest;
    private String gomel;

    @ManyToMany(mappedBy = "regions")
    private List<Clients> clients;
}
