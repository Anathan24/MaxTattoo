package com.maxtattoo.database.view;

import com.maxtattoo.database.view.interfaces.GenericView;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "NeedleView")
public class NeedleView implements GenericView {

    @Id
    private Long needleId;
    private String needleProducer;
    private String needleCode;
    private String needleSharpening;
}
