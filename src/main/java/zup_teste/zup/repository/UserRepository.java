package zup_teste.zup.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import zup_teste.zup.model.User;

public interface UserRepository extends JpaRepository<User, String> {
    List<User> findByCpf(String cpf);
    List<User> findByEmail(String email);
}
