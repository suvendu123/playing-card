package com.playing.cards.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.playing.cards.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    public User findByEmail(String email);
}