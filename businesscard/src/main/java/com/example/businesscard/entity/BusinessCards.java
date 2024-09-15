package com.example.businesscard.entity;

import com.example.businesscard.security.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "business_cards", schema = "public")
public class BusinessCards {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private Long cardId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "business_name", nullable = false, length = 100)
    private String businessName;

    @Column(name = "contact_details", length = 255)
    private String contactDetails;

    @Column(name = "website", length = 100)
    private String website;

    @Column(name = "card_design", length = 255)
    private String cardDesign;
}
