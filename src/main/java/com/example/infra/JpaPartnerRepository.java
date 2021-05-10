package com.example.infra;

import com.example.domain.Partner;
import com.example.repository.PartnerRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPartnerRepository
        extends PartnerRepository, JpaRepository<Partner, Long> {
    Partner save(Partner partner);
}
