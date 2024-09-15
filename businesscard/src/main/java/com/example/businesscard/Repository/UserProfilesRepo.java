package com.example.businesscard.Repository;

import com.example.businesscard.entity.User_Profiles;
import com.example.businesscard.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserProfilesRepo extends JpaRepository<User_Profiles, Long> {
    Optional<User_Profiles> findByUser(User user);
}
