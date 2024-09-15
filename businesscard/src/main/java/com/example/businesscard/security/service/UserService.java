package com.example.businesscard.security.service;

import com.example.businesscard.entity.User_Profiles;
import com.example.businesscard.security.entity.User;
import com.example.businesscard.security.repository.UserRepo;
import com.example.businesscard.Repository.UserProfilesRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final UserProfilesRepo userProfilesRepo;

    public User createUser(User user) {
        // Perform additional validation if necessary
        return userRepo.save(user);
    }

    public Optional<User> getUserById(UUID id) {
        return userRepo.findById(id);
    }

    public List<User> getAllUsers(int page, int size) {
        // Implement pagination logic if needed
        return userRepo.findAll(); // Customize to include pagination
    }

    public Optional<User> updateUser(UUID id, User user) {
        if (!userRepo.existsById(id)) {
            return Optional.empty();
        }
        user.setUserId(id); // Ensure the ID is set
        return Optional.of(userRepo.save(user));
    }

    public boolean deleteUser(UUID id) {
        if (!userRepo.existsById(id)) {
            return false;
        }
        userRepo.deleteById(id);
        return true;
    }

    public void ensureProfileExists(User user) {
        if (userProfilesRepo.findByUser(user).isEmpty()) {
            User_Profiles profile = User_Profiles.builder()
                    .user(user)
                    .portfolio(null)  // Initialize with default values if needed
                    .build();
            userProfilesRepo.save(profile);
        }
    }

    public List<User> getAllUsers() {
        return null;
    }
}
