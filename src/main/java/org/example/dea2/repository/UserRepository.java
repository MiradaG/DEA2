package org.example.dea2.repository;

import org.example.dea2.entity.UserDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository // Marks this interface as a Spring Data repository, indicating it provides data access functionality.
public interface UserRepository extends JpaRepository<UserDetailsEntity, Integer> {


    UserDetailsEntity findByEmail(String email);
}
