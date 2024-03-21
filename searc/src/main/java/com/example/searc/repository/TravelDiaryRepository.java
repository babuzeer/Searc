// 文件路径: src/main/java/com/example/searc/repository/TravelDiaryRepository.java
package com.example.searc.repository;

import com.example.searc.model.TravelDiary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelDiaryRepository extends JpaRepository<TravelDiary, Long> {
}
