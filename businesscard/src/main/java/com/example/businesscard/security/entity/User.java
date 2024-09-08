package com.example.businesscard.security.entity;

import com.example.businesscard.entity.User_Profiles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user_details", schema = "public")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private UUID userId;

    @NonNull
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @NonNull
    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @NonNull
    @Column(name = "email", unique = true, nullable = false, length = 100)
    private String email;

    @NonNull
    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @NonNull
    @Column(name = "phone_number", nullable = false, length = 20)
    private String phoneNumber;

    @NonNull
    @Column(name = "city", nullable = false, length = 20)
    private String city;

    @NonNull
    @Column(name = "profession", nullable = false, length = 100)
    private String profession;

    @Column(name = "profile_picture", length = 255)
    private String profilePicture;

    @Column(name = "bio")
    private String bio;

    @Column(name = "card_template", length = 255)
    private String cardTemplate;

    @Column(name = "latitude", precision = 9, scale = 6)
    private Double latitude;

    @Column(name = "longitude", precision = 9, scale = 6)
    private Double longitude;


    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private User_Profiles userProfile;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
