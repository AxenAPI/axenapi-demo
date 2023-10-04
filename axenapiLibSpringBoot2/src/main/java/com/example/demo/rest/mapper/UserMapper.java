package com.example.demo.rest.mapper;


import com.example.demo.rest.dto.request.UserCreateRequestDTO;
import com.example.demo.rest.dto.response.UserResponseDTO;
import com.example.demo.rest.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponseDTO toDTO(User user);
    @Mapping(target = "id", ignore = true)
    User toEntityFromCreateRequestDTO(UserCreateRequestDTO requestDto);
}
