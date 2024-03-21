// 文件路径: src/main/java/com/example/searc/repository/SchoolRepository.java
package com.example.searc.repository;

import com.example.searc.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {
}
