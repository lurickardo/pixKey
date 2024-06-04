package com.itau.pixkey.core.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PersonCategory personCategory;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountType accountType;

    @Column(nullable = false)
    private Integer agency;

    @Column(nullable = false)
    private Integer accountNumber;

    @Column(nullable = false)
    private String holderName;

    private String holderSurname;

    @CreationTimestamp
    @Column(nullable = false)
    private OffsetDateTime registrationDate;

    @UpdateTimestamp
    @Column(nullable = false)
    private OffsetDateTime updateDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    @Column(nullable = false)
    private List<PixKey> pixKeys;

    public Integer getNumberOfPixKeys() {
        return pixKeys.size();
    }

    public void addPixKey(PixKey pixKey) {
        pixKey.connectAccount(this);
        pixKeys.add(pixKey);
    }

    public PixKey getLastPixKey() {
        return pixKeys.get(getNumberOfPixKeys() - 1);
    }

}
