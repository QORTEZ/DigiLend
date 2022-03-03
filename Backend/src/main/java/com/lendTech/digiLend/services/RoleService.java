package com.lendTech.digiLend.services;

import com.lendTech.digiLend.models.Role;
import com.lendTech.digiLend.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    public Role updateRole(Role role) {
        return roleRepository.save(role);
    }

    public Role getRole(long id) {
        return roleRepository.getById(id);
    }

    public void deleteRole(long id) {
        roleRepository.deleteById(id);
    }
}
