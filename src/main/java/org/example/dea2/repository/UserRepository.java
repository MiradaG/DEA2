package org.example.dea2.repository;

import org.example.dea2.entity.UserDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDetailsEntity,Integer> {
    UserDetailsEntity findByEmail(String email);


}
