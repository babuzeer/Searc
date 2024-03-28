package com.example.searc.repository;

import com.example.searc.model.UserLabel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLabelRepository extends JpaRepository<UserLabel, Long> {
}