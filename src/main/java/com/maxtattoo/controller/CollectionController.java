package com.maxtattoo.controller;

import com.maxtattoo.command.DeleteByIdCmd;
import com.maxtattoo.command.FindAllCmd;
import com.maxtattoo.command.FindByIdCmd;
import com.maxtattoo.command.SaveImageCmd;
import com.maxtattoo.dto.model.ImageModel;
import com.maxtattoo.dto.request.ImageRequest;
import com.maxtattoo.utils.GenericResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static com.maxtattoo.service.enums.Entity.COLLECTION;
import static com.maxtattoo.utils.StringUtils.*;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/collection")
public class CollectionController extends GenericController {

    @GetMapping(value = "/findById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ImageModel> findById(@RequestParam Long id){
        logger.info(START);
        var command = beanFactory.getBean(FindByIdCmd.class);
        logger.info("{}, id: {}", REQUEST, id);
        var model = command.execute(repositoryFactory.getRepository(COLLECTION), ImageModel.class, id);
        logger.info(MESSAGE_PATTERN, MODEL, model);
        logger.info(END);
        return ok(model);
    }

    @GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ImageModel>> findAll(){
        logger.info(START);
        var command = super.beanFactory.getBean(FindAllCmd.class);
        var result = command.execute(repositoryFactory.getRepository(COLLECTION), ImageModel.class);
        logger.info(MESSAGE_PATTERN, MODEL, result);
        logger.info(END);
        return ok(result);
    }

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ImageModel> save(@RequestParam(required = false) Long id,
                                           @RequestParam(required = false) String name,
                                           @RequestParam(name = "image") MultipartFile image,
                                           @RequestParam(required = false) String description) throws IOException {
        logger.info(START);
        ImageRequest request = new ImageRequest(id, name, image.getBytes(), description);
        var command = beanFactory.getBean(SaveImageCmd.class);
        logger.info("{}: id: {}, name: {}, description: {}", REQUEST, request.getImageId(), request.getName(), request.getDescription());
        var model = command.execute(request);
        logger.info("{}: id: {}, name: {}, description: {}", REQUEST, model.getImageId(), model.getName(), model.getDescription());
        logger.info(END);
        return ok(model);
    }

    @DeleteMapping(value = "/deleteById")
    public ResponseEntity<GenericResponse> deleteById(@RequestParam("imageId") Long id) {
        logger.info(START);
        var command = beanFactory.getBean(DeleteByIdCmd.class);
        logger.info(MESSAGE_PATTERN, REQUEST, id);
        var result = command.execute(repositoryFactory.getRepository(COLLECTION), COLLECTION, id);
        logger.info("RESULT: {}", result);
        logger.info(END);
        return ok(result);
    }
}
