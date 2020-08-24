package com.mary.instragram.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository 있으면 @Repository가 필요없음 IOC 자동으로 됨
public interface UserRepository extends JpaRepository<User, Integer> {

}
