package com.example.demo.rest.controller;

import com.example.demo.rest.dto.request.UserCreateRequestDTO;
import com.example.demo.rest.dto.request.UserUpdateRequestDTO;
import com.example.demo.rest.dto.response.UserResponseDTO;

import com.example.demo.rest.mapper.UserMapper;
import com.example.demo.rest.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private static List<User> users = new ArrayList<>();

    private final UserMapper mapper;

    static {
        users.add(new User(1L, "Charlie", "ratking@zds.com"));
        users.add(new User(2L, "Dea", "deandra@zds.corp"));
        users.add(new User(3L, "Mac", "ronald@zds.corp"));
        users.add(new User(4L, "Dennis", "denis@zds.corp"));

        users.add(new User(5L, "Frank", "frank@zds.corp"));
    }


    @Operation(summary = "get user by its id", servers = {
            @Server(url = "localhost:8085", description = "swagger from kafka")
        })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found users",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResponseDTO.class))}),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = {@Content})
    })
    @GetMapping("/{id}")
    @SecurityRequirement(name = "Public-Bearer-Jwt")
    public UserResponseDTO getUserById(@PathVariable("id") Long id) {
        for (User user : users) {
            if (id == user.getId()) {
                return mapper.toDTO(user);
            }
        }
        throw new RuntimeException("User not found");
    }

    @Operation(summary = "get users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found users",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResponseDTO.class))})
    })
    @GetMapping
    @SecurityRequirement(name = "Internal-Token")
    public List<UserResponseDTO> getUsers() {
        return users.stream().map(mapper::toDTO)
                .collect(Collectors.toList());
    }


    @Operation(summary = "create new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "user created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResponseDTO.class))})
    })
    @PostMapping
    public UserResponseDTO createUser(
            @Validated @RequestBody UserCreateRequestDTO request) {
        User user = mapper.toEntityFromCreateRequestDTO(request);
        users.add(user);
        return mapper.toDTO(user);
    }

    @Operation(summary = "update user info")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResponseDTO.class))}),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = {@Content})
    })
    @PutMapping
    public UserResponseDTO updateUser(
            @Validated @RequestBody UserUpdateRequestDTO request) {
        for (User user : users) {
            if (request.getId() == user.getId()) {
                user.setNickname(request.getNickname());
                user.setEmail(request.getEmail());
                return mapper.toDTO(user);
            }
        }
        throw new RuntimeException("User not found");
    }

    @Operation(summary = "delete user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User deleted",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResponseDTO.class))}),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = {@Content})
    })
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                break;
            }
        }
    }
}
