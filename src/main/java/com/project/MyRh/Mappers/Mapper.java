package com.project.MyRh.Mappers;

public interface Mapper<Entity, EntityDto> {

    EntityDto mapTo(final Entity entity);
    Entity mapFrom(final EntityDto dto);

}
