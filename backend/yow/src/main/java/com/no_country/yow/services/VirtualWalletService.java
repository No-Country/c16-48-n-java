package com.no_country.yow.services;

import com.no_country.yow.exceptions.YOWException;
import com.no_country.yow.models.Movement;
import com.no_country.yow.models.Person;
import com.no_country.yow.models.VirtualWallet;
import com.no_country.yow.repositories.MovementRepository;
import com.no_country.yow.repositories.PersonRepository;
import com.no_country.yow.repositories.VirtualWalletRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Slf4j
@Service
public class VirtualWalletService implements CRUDServices<VirtualWallet, Long> {


    @Autowired
    private VirtualWalletRepository repository;

    @Autowired
    private MovementService  movementService;
    
    @Autowired
    private ServiceService serviceService;
    
    
    @Transactional
    @SuppressWarnings("null")
    @Override
    public ResponseEntity<?> save(VirtualWallet wallet) throws YOWException {
        repository.save(wallet);
        return ResponseEntity.ok("Billetera Creada / Actualizada");
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
    public ResponseEntity<?> updateById(VirtualWallet t, Long id) throws YOWException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<?> findById(Long id) throws YOWException {
        VirtualWallet virtualWallet = repository.findById(id).orElseThrow();
        return ResponseEntity.ok().body(virtualWallet);
    }

    public ResponseEntity<?> findByIdClient(Person person) {

        try {
            VirtualWallet virtualWallet = repository.virtualWalletByIdClient(person);

            if (virtualWallet == null) {
                throw new Exception("El usuario no tiene billetera activa");

            }
            return ResponseEntity.ok().body(virtualWallet);
        } catch (Exception e) {
            log.info("Error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
    
    @Transactional
    public ResponseEntity<?> recharge(Person person, Double mount){
        
        try {
            repository.recharge(person, mount);
            Movement movement = new Movement(new Date(), mount, true,serviceService.findByName("Recarga"),(VirtualWallet) findByIdClient(person).getBody());
            movementService.save(movement);
            return ResponseEntity.ok().body("Recargar Exitosa");
        } catch (Exception e) {
            log.info("Error: " + e.getMessage());
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al recargar intente mas tarde");
        }
        
    }

    public List<VirtualWallet> listVirtualWallet() {
        return repository.findAll();
    }

}
