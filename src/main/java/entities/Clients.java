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
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String client1;
    private String client2;
    private String client3;
    private String client4;
    private String client5;

    @OneToMany(mappedBy = "clients")
    private List<Car> cars;
}
