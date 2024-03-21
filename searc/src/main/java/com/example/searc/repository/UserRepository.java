// 文件路径: src/main/java/com/example/searc/repository/UserRepository.java
package com.example.searc.repository;

import com.example.searc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
