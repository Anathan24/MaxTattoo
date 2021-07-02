package com.maxtattoo.builder;

import com.maxtattoo.model.*;
import com.maxtattoo.response.*;
import com.maxtattoo.utils.ResponseMock;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ResponseBuilder.class, ResponseMock.class})
public class ResponseBuilderTest {

    @Autowired
    private ResponseMock entityMock;
    @Autowired
    private ResponseBuilder modelBuilder;

    @Test
    public void clientTransformerTest(){
        List<ClientModel> client = new ArrayList<>();
        client.add(entityMock.createClientModel(1L));
        client.add(entityMock.createClientModel(2L));
        List<ClientResponse> clientModel = modelBuilder.createClientResponse(client);

        Assert.assertNotNull(clientModel);
        Assert.assertEquals(2, clientModel.size());
    }

    @Test
    public void orderTransformerTest(){
        OrderModel order = entityMock.createOrderModel(1L);
        OrderResponse orderModel = modelBuilder.createOrderResponse(order);

        Assert.assertNotNull(orderModel);
        Assert.assertEquals(1L, orderModel.getId().longValue());
    }

    @Test
    public void sittingTransformerTest(){
        SittingModel sitting = entityMock.createSittingModel(1L, 1L);
        SittingResponse sittingModel = modelBuilder.createSittingResponse(sitting);

        Assert.assertNotNull(sittingModel);
        Assert.assertEquals(1L, sittingModel.getOrderId().longValue());
    }

    @Test
    public void orderTypeTransformerTest(){
        OrderTypeModel orderType = entityMock.createOrderTypeModel(1L, "Tattoo");
        OrderTypeResponse orderTypeModel = modelBuilder.createOrderTypeModel(orderType);

        Assert.assertNotNull(orderTypeModel);
        Assert.assertEquals(1L, orderTypeModel.getId().longValue());
        Assert.assertEquals("Tattoo", orderTypeModel.getValue());
    }

    @Test
    public void stateTransformerTest(){
        StateModel state = entityMock.createStateModel(1L, "In progress");
        StateResponse stateModel = modelBuilder.createStateResponse(state);

        Assert.assertNotNull(stateModel);
        Assert.assertEquals("In progress", stateModel.getValue());
    }

    @Test
    public void paintTransformerTest(){
        PaintModel paint = entityMock.createPaintModel(1L);
        PaintResponse paintModel = modelBuilder.createPaintResponse(paint);

        Assert.assertNotNull(paintModel);
        Assert.assertEquals(1L, paintModel.getId().longValue());
    }

    @Test
    public void needleTransformerTest(){
        NeedleModel needle = entityMock.createNeedleModel(1L);
        NeedleResponse needleModel = modelBuilder.createNeedleResponse(needle);

        Assert.assertNotNull(needleModel);
        Assert.assertEquals(1L, needleModel.getId().longValue());
    }
}
