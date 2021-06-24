package com.maxtattoo.database.view;

import com.maxtattoo.database.view.interfaces.GenericView;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "OrderView")
public class OrderView implements GenericView {

    @Id
    private Long orderId;
    private int sittingNumber;
    private int orderPrice;
    private int prepayment;
    private Date startDate;
    private Date endDate;
    private String stateName;
    private String type;
}
