package org.example.dea2.repository;

import org.example.dea2.entity.BidEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//interface for bidRepository service for implement
public interface BidRepository extends JpaRepository <BidEntity,Integer> {

}
