package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.User;
import mk.finki.ukim.mk.lab.model.UserFullname;
import mk.finki.ukim.mk.lab.repository.UserRepositoryInterface;
import mk.finki.ukim.mk.lab.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepositoryInterface userRepositoryInterface;

    public UserServiceImpl(UserRepositoryInterface userRepositoryInterface) {
        this.userRepositoryInterface = userRepositoryInterface;
    }
    @Override
    public List<User> getAllUsers() {
        return userRepositoryInterface.findAll();
    }

    @Override
    public Optional<User> saveUser(String username,String name,String surname, String password , LocalDate dateOfBirth) {
        UserFullname fullname=new UserFullname();
        fullname.setName(name);
        fullname.setSurname(surname);
        User user=new User(username,fullname,password,dateOfBirth);
        return Optional.of(userRepositoryInterface.save(user));

    }

}