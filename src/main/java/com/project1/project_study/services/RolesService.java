package com.project1.project_study.services;

import com.project1.project_study.DTOs.RolesDTO;
import com.project1.project_study.core.utils.ApiObjectMapper;
import com.project1.project_study.models.Roles;
import com.project1.project_study.repositories.RolesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RolesService {
    private final RolesRepository rolesRepository;
    private final ApiObjectMapper<Roles> apiObjectMapper;

    public void create(RolesDTO rolesDTO) {
        var roles = this.convert(rolesDTO);
        rolesRepository.save(roles);
    }

    public void update(RolesDTO rolesDTO, Long id) {
        var roles = this.convert(rolesDTO);
        var oldRoles =this.getById(id);
        var newRoles = apiObjectMapper.updateModel(
                roles,
                        oldRoles
        );
        rolesRepository.save(newRoles);

    }

    private void delete(Long id){
        var roles =getById(id);
        rolesRepository.delete(roles);
    }

    public List<Roles> getAll() {
        return rolesRepository.findAll();
    }

    public Roles findOne(Long id) {
        return this.getById(id);
    }

    private Roles convert(RolesDTO rolesDTO) {
        return apiObjectMapper.dtoToModel(rolesDTO, Roles.class);
    }

    private Roles getById(Long id) {
        return rolesRepository.findById(id).orElseThrow(
                                RuntimeException::new
        );

    }
}
