package com.maxtattoo.transformer;

import com.maxtattoo.database.entity.*;
import com.maxtattoo.model.*;
import com.maxtattoo.util.EntityMock;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {EntityModelTransformer.class, EntityMock.class})
public class EntityModelTransformerTest {

    @Autowired
    private EntityMock entityMock;
    @Autowired
    private EntityModelTransformer entityModelTransformer;

    @Test
    public void clientTransformerTest(){
        List<Client> client = new ArrayList<>();
        client.add(entityMock.createClientEntity(1L));
        List<ClientModel> clientModel = entityModelTransformer.clientEntityModelTransformer(client);

        Assert.assertNotNull(clientModel);
        Assert.assertEquals(1, clientModel.size());
    }

    @Test
    public void orderTransformerTest(){
        Order order = entityMock.createOrderEntity(1L);
        OrderModel orderModel = entityModelTransformer.orderEntityModelTransformer(order);

        Assert.assertNotNull(orderModel);
        Assert.assertEquals(1L, orderModel.getId().longValue());
    }

    @Test
    public void sittingTransformerTest(){
        Sitting sitting = entityMock.createSittingEntity(1L, 1L);
        SittingModel sittingModel = entityModelTransformer.sittingEntityModelTransformer(sitting);

        Assert.assertNotNull(sittingModel);
        Assert.assertEquals(1L, sittingModel.getOrderId().longValue());
    }

    @Test
    public void orderTypeTransformerTest(){
        OrderType orderType = entityMock.createOrderTypeEntity(1L, "Tattoo");
        OrderTypeModel orderTypeModel = entityModelTransformer.orderTypeEntityModelTransformer(orderType);

        Assert.assertNotNull(orderTypeModel);
        Assert.assertEquals(1L, orderTypeModel.getId().longValue());
        Assert.assertEquals("Tattoo", orderTypeModel.getValue());
    }

    @Test
    public void stateTransformerTest(){
        State state = entityMock.createStateEntity(1L, "In progress");
        StateModel stateModel = entityModelTransformer.stateEntityModelTransformer(state);

        Assert.assertNotNull(stateModel);
        Assert.assertEquals("In progress", stateModel.getValue());
    }

    @Test
    public void paintTransformerTest(){
        Paint paint = entityMock.createPaintEntity(1L);
        PaintModel paintModel = entityModelTransformer.paintEntityModelTransformer(paint);

        Assert.assertNotNull(paintModel);
        Assert.assertEquals(1L, paintModel.getId().longValue());
    }

    @Test
    public void needleTransformerTest(){
        Needle needle = entityMock.createNeedleEntity(1L);
        NeedleModel needleModel = entityModelTransformer.needleEntityModelTransformer(needle);

        Assert.assertNotNull(needleModel);
        Assert.assertEquals(1L, needleModel.getId().longValue());
    }
}
