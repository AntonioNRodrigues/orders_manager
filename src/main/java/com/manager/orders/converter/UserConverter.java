package com.manager.orders.converter;

import com.manager.orders.models.dto.UserDto;
import com.manager.orders.models.entities.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserConverter implements IConverter<User, UserDto> {
    @Override
    public UserDto entityToDto(User entity) {
        return new UserDto(entity.getName(), entity.getEmail());
    }

    @Override
    public User dtoToEntity(UserDto dto) {
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        return user;
    }
}
