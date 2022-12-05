package com.bptn.repository;

import com.bptn.models.UserID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserID, String> {

    @Query(value = "select * from \"UserID\" where username=?1", nativeQuery = true)
    UserID findByUsername(String userName);

}
