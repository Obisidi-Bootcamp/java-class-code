package com.bptn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bptn.models.UserID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginRepository extends JpaRepository<UserID, String> {

    @Query(value = "select * from public.\"UserID\" where username=?1", nativeQuery = true)
    List<UserID> getUserByUserId(String username);

}
