package com.CibilCalculator.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subject")
/**
 * POJO representation of Subject data from database
 */
public class Subject implements Serializable {

    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "credit_utilisation")
    private String creditUtilisation;

    @Column(name = "debt_to_income")
    private String debtToIncome;

    @Column(name = "account_age")
    private String accountAge;

    @Column(name = "payment_history")
    private String paymentHistory;

    @Column(name = "recent_inquiry")
    private String recentInquiry;
}
