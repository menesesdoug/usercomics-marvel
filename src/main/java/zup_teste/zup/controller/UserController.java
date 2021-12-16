package zup_teste.zup.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import zup_teste.zup.exception.InvalidFieldException;
import zup_teste.zup.exception.ResourceNotFoundException;
import zup_teste.zup.model.Comic;
import zup_teste.zup.model.User;
import zup_teste.zup.model.UserDTOComics;
import zup_teste.zup.model.UserResponse;
import zup_teste.zup.repository.UserRepository;
import zup_teste.zup.service.UserService;

@RestController
public class UserController {
    
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public ResponseEntity<Object> getAllUsers(){
        List<User> l = userRepository.findAll();
        UserResponse response = new UserResponse();
        if(l.isEmpty()){
             response.setMessage("Nenhum usuário cadastrado");
             return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }else
            return new ResponseEntity<>(l, HttpStatus.OK);
    }

    @PostMapping("/user/add")
    public ResponseEntity<UserResponse> addUser(@Valid @RequestBody User user){
        List<User> cpf = userRepository.findByCpf(user.getCpf());
        List<User> email = userRepository.findByEmail(user.getEmail());
        UserResponse response = new UserResponse();
        if(!cpf.isEmpty() || !email.isEmpty()){
            if (cpf.isEmpty() && email.isEmpty()) {
                response.setMessage("E-mail is required and must be unique. " +
                    "CPF is required and must be unique");
            } else if(email.isEmpty()){ 
                response.setMessage("CPF is required and must be unique");
            }else{
                response.setMessage("E-mail is required and must be unique.");
            }
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        else{
           if(user.getCpf().isBlank())
                throw new InvalidFieldException("CPF em branco!");

            response.setUser(userRepository.save(user));
            response.setMessage("Success");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
    }
    

    @GetMapping("/user/{cpf}/comics")
    public ResponseEntity<UserResponse> getComicsFromUserByCPF(@Valid @PathVariable String cpf) throws ResourceNotFoundException {
        UserResponse response = new UserResponse();
        List<User> resultado = userRepository.findByCpf(cpf);
        if(resultado == null)
            throw new ResourceNotFoundException("User not found for this cpf :: ");
        List<Comic> l;
        if(resultado.size()== 1){
            l = userService.getComicsFromUserByCPF(cpf);
            resultado.get(0).setComics(l);
            UserDTOComics u = new UserDTOComics(l);
            response.setUser(u);
            //response.setUserD(resultado.get(0));
            response.setMessage("Success");
            return new ResponseEntity<>(response, HttpStatus.OK);

        }else if (resultado.size()>1){
            response.setMessage("Client duplicated");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }else if (resultado.isEmpty()){
            response.setMessage("Client cpf: "+cpf+" cannot be found");
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        }
        return null;
    }

   
}
