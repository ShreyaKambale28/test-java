package com.example.shreya_test;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RatingDetailsRepository extends JpaRepository<RatingDetails, Character>{

	@Query("SELECT r FROM RatingDetails r WHERE r.category = :category")
	Optional<RatingDetails> findByCategory(@Param("category") char category);

	AppraisalDetails save(AppraisalDetails apprasial);
}