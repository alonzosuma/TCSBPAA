package com.TCSBPAA.Abdiel_Alonzo.Interface;

import com.TCSBPAA.Abdiel_Alonzo.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
