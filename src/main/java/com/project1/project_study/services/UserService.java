package com.project1.project_study.services;

import com.project1.project_study.DTOs.UserDTO;
import com.project1.project_study.DTOs.UserUpdateDTO;
import com.project1.project_study.core.utils.ApiObjectMapper;
import com.project1.project_study.models.UserModel;
import com.project1.project_study.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;



@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ApiObjectMapper<UserModel> apiObjectMapper;
    private UserModel user;

    public List<UserModel> getAll(){
        return userRepository.findAll();
    }

    public UserModel findOne(Long id) {
        return this.getById(id);
    }

    public void create (UserDTO userDTO) {
        var user = this.convert(userDTO);
        userRepository.save(user);
    }

    public void updateAll(UserDTO userDTO, Long id) {
        var user = this.convert(userDTO);
        var oldUser = this.getById(id);
        var newUser = apiObjectMapper.updateModel(
                user,
                        oldUser
        );
        userRepository.save(newUser);
    }

    public void updateOnly(UserUpdateDTO userUpdateDTO, Long id) {
        var userDTO = apiObjectMapper.dtoToModel(
                userUpdateDTO,
                        UserModel.class
        );
        var oldUser = getById(id);
        var updatedUser = apiObjectMapper.updateModel(
                oldUser,
                            userDTO
        );
        userRepository.save(updatedUser);
    }

    public void delete(Long id) {
        var user = getById(id);
        userRepository.delete(user);
    }

    private UserModel getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(
                                        RuntimeException::new
                );
    }

    private UserModel convert(UserDTO userDTO) {
        return  apiObjectMapper
                .dtoToModel(userDTO, UserModel.class);
    }
}
