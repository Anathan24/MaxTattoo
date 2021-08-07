package com.maxtattoo.builder;

import com.maxtattoo.pojo.entity.*;
import com.maxtattoo.pojo.model.*;
import com.maxtattoo.utils.EntityMock;
import com.maxtattoo.utils.StateEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ModelBuilder.class, EntityMock.class})
public class ModelBuilderTest {

    @Autowired
    private EntityMock entityMock;
    @Autowired
    private ModelBuilder modelBuilder;
    @Autowired
    private ListModelBuilder listModelBuilder;

    @Test
    public void clientTransformerTest(){
        List<Client> client = new ArrayList<>();
        client.add(entityMock.createClientEntity(1L));
        client.add(entityMock.createClientEntity(2L));
        List<ClientModel> clientModel = listModelBuilder.createClientModel(client);

        Assert.assertNotNull(clientModel);
        Assert.assertEquals(2, clientModel.size());
    }

    @Test
    public void orderTransformerTest(){
        Order order = entityMock.createOrderEntity(1L);
        OrderModel orderModel = modelBuilder.createOrderModel(order);

        Assert.assertNotNull(orderModel);
        Assert.assertEquals(1L, orderModel.getId().longValue());
    }

    @Test
    public void sittingTransformerTest(){
        Sitting sitting = entityMock.createSittingEntity(1L, 1L);
        SittingModel sittingModel = modelBuilder.createSittingModel(sitting);

        Assert.assertNotNull(sittingModel);
        Assert.assertEquals(1L, sittingModel.getOrderId().longValue());
    }

    @Test
    public void orderTypeTransformerTest(){
        OrderType orderType = entityMock.createOrderTypeEntity(1L, "Tattoo");
        OrderTypeModel orderTypeModel = modelBuilder.createOrderTypeModel(orderType);

        Assert.assertNotNull(orderTypeModel);
        Assert.assertEquals(1L, orderTypeModel.getId().longValue());
        Assert.assertEquals("Tattoo", orderTypeModel.getValue());
    }

    @Test
    public void stateTransformerTest(){
        State state = entityMock.createStateEntity(1L, "In progress");
        StateEnum stateModel = StateEnum.findByValue(state.getValue());

        Assert.assertNotNull(stateModel);
        Assert.assertEquals("In progress", stateModel.getValue());
    }

    @Test
    public void paintTransformerTest(){
        Paint paint = entityMock.createPaintEntity(1L);
        PaintModel paintModel = modelBuilder.createPaintModel(paint);

        Assert.assertNotNull(paintModel);
        Assert.assertEquals(1L, paintModel.getId().longValue());
    }

    @Test
    public void needleTransformerTest(){
        Needle needle = entityMock.createNeedleEntity(1L);
        NeedleModel needleModel = modelBuilder.createNeedleModel(needle);

        Assert.assertNotNull(needleModel);
        Assert.assertEquals(1L, needleModel.getId().longValue());
    }
}
