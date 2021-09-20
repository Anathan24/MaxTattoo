package com.maxtattoo.command;

import com.maxtattoo.database.repository.ImageRepository;
import com.maxtattoo.dto.entity.Image;
import com.maxtattoo.dto.model.ImageModel;
import com.maxtattoo.dto.request.ImageRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static com.maxtattoo.utils.StringUtils.*;

@Component
@Scope("prototype")
public class SaveImageCmd extends GenericCommand {

    @Autowired
    private ImageRepository imageRepository;

    public ImageModel execute(ImageRequest request) {
        var entity = (Image) entityFactory.getObject(Image.class.getSimpleName());
        BeanUtils.copyProperties(request, entity);

        logger.info("{}: id: {}, name: {}, description: {}", ENTITY, entity.getImageId(), entity.getName(), entity.getDescription());
        entity = imageRepository.save(entity);

        return modelBuilder.buildModel(entity, ImageModel.class);
    }
}
