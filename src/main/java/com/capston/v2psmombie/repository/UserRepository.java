package com.capston.v2psmombie.repository;

import com.capston.v2psmombie.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByDeviceId(String deviceId);

    @Query(value = "SELECT * FROM user WHERE ap_id =:connectedApId", nativeQuery = true)
    List<User> findByConnectedApId(Integer connectedApId);
}
