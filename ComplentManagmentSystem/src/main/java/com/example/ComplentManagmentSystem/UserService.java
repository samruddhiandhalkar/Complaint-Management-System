package com.example.ComplentManagmentSystem;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService 
{

	@Autowired
    private UserRepository userRepo;

    public UserEntity saveUser(UserEntity user)
    {
        return userRepo.save(user);
    }

    public List<UserEntity> getAllUsers() 
    {
        return userRepo.findAll();
    }

    public Optional<UserEntity> getUserById(Long id)
    {
        return userRepo.findById(id);
    }

    
    public UserEntity updateUser(Long id, UserEntity updatedUser) 
    {
        Optional<UserEntity> optional = userRepo.findById(id);
        if (optional.isPresent()) 
        {
            UserEntity user = optional.get();
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            return userRepo.save(user);
        }
        return null;
    }

  
    public boolean deleteUser(Long id) 
    {
        if (userRepo.existsById(id))
        {
            userRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
