package mysite.expense.repository;

import mysite.expense.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    //이메일로 유저를 찾는 메서드
    Optional<User> findByEmail(String email);
}
