package com.example.demo.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository
        extends JpaRepository<Member, Long> {

    List<Member> findByMemberType(MemberType memberType);

    @Query("SELECT s FROM Member s where s.email=?1")
    Optional<Member> findByEmail(String email);

    @Query("SELECT s FROM Member s where s.username=?1")
    Optional<Member> findByUsername(String username);
}
