package com.itau.pixkey.core.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;
import java.util.UUID;

import static com.itau.pixkey.core.domain.Status.ACTIVE;

@Entity
@Getter
@Setter
public class PixKey {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private KeyType keyType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(nullable = false)
    private String keyValue;

    @CreationTimestamp
    @Column(nullable = false)
    private OffsetDateTime registrationDate;

    @UpdateTimestamp
    @Column(nullable = false)
    private OffsetDateTime updateDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Account account;

    public void connectAccount(Account account) {
        this.account = account;
        status = ACTIVE;
    }

}
