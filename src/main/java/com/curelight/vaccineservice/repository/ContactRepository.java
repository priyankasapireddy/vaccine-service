package com.curelight.vaccineservice.repository;

import com.curelight.vaccineservice.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Long> {


   Optional<ContactEntity> findByEmailIdEquals(String emailId);

   @Query(name = "SELECT * FROM contacts where phone_number = ?1 ",
   nativeQuery = true)
   Optional<ContactEntity> findByPhoneNumber(String phone);

}
