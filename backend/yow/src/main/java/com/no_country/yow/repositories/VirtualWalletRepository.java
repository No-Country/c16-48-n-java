package com.no_country.yow.repositories;

import com.no_country.yow.models.VirtualWallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VirtualWalletRepository extends JpaRepository<VirtualWallet, Long> {
    
    @Query("SELECT MAX(v.numberAccount) FROM VirtualWallet v")
    public String numberAccount();
}
