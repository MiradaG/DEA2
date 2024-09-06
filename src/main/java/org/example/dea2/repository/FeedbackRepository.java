package org.example.dea2.repository;

import org.example.dea2.entity.FeedbackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  // Marks this interface as a Spring Data repository that handles database operations
public interface FeedbackRepository extends JpaRepository<FeedbackEntity, Integer> {

}
