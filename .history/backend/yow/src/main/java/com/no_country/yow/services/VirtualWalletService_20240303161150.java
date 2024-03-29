package com.no_country.yow.services;

import com.no_country.yow.exceptions.YOWException;
import com.no_country.yow.models.VirtualWallet;
import com.no_country.yow.repositories.VirtualWalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VirtualWalletService implements CRUDServices<VirtualWallet, String> {

    @Autowired
    private VirtualWalletRepository repository;

    @Override
    public ResponseEntity<?> save(VirtualWallet wallet) throws YOWException {
        repository.save(wallet);
        return ResponseEntity.ok("Billetera Creada");
    }

//    @Override
//    public ResponseEntity<List<VirtualWallet>> findAll() {
//       List<VirtualWallet> listVirtualWallet = repository.findAll();
//
//       return ResponseEntity.ok().body(listVirtualWallet);
//    }

//    @Override
//    public ResponseEntity<?> updateById(VirtualWallet virtualWallet, String id) throws YOWException {
//        Optional<VirtualWallet> virtualWalletOptional = repository.findById(id);
//        if(virtualWalletOptional.isPresent()){
//            VirtualWallet virtualWalletDb = virtualWalletOptional.get();
//            virtualWalletDb.setBalance(virtualWallet.getBalance());
//            virtualWalletDb.setServices(virtualWallet.getServices());
//            return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(virtualWalletDb));
//        }
//        return ResponseEntity.notFound().build();
//    }


//    @Override
//    public ResponseEntity<?> findById(String id) throws YOWException {
//        Optional<VirtualWallet> virtualWalletOptional = repository.findById(id);
//        if(virtualWalletOptional.isPresent())
//            return ResponseEntity.ok(virtualWalletOptional.get());
//        return ResponseEntity.notFound().build();
//    }

    @Override
    public ResponseEntity<List<VirtualWallet>> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ResponseEntity<?> updateById(VirtualWallet t, String id) throws YOWException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ResponseEntity<?> findById(String id) throws YOWException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
