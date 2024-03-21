// 文件路径: src/main/java/com/example/searc/repository/SpotRepository.java
package com.example.searc.repository;

import com.example.searc.model.Spot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpotRepository extends JpaRepository<Spot, Long> {
}
