package com.maxtattoo.database.view;

import com.maxtattoo.database.view.interfaces.GenericView;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "ClientView")
public class ClientView implements GenericView {

    private Long clientId;
    private String name;
    private String surname;
    private String gender;
    private String description;
}
