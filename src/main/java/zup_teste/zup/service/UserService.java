package zup_teste.zup.service;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zup_teste.zup.model.Comic;
import zup_teste.zup.repository.ComicRepository;
import zup_teste.zup.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ComicRepository comicRepository;

    public List<Comic> getComicsFromUserByCPF(String cpf){
        List<Comic> comics = userRepository.getById(cpf).getComics();

        for(Comic c : comics){
            aplicarDesconto(c);
        }
        return comics;
    }

    public void aplicarDesconto(Comic c){
        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));
        int day = cal.get(Calendar.DAY_OF_WEEK);
        //System.out.println("DAY = "+ day);

        switch(day){
            case 2:
                if(c.getIsbn().endsWith("0") || c.getIsbn().endsWith("1") ){
                    //System.out.println("ENTROU no 2");
                    c.setDesconto(true);
                    c.setPreco(c.getPreco()*0.9f);
                }
                break;
                
            case 3: 
                if(c.getIsbn().endsWith("2") || c.getIsbn().endsWith("3") ){
                    //System.out.println("ENTROU no 3");
                    c.setDesconto(true);
                    c.setPreco(c.getPreco()*0.9f); 
                }
                break;
                
            case 4:
                if(c.getIsbn().endsWith("4") || c.getIsbn().endsWith("5") ){
                   // System.out.println("ENTROU no 4");
                    c.setDesconto(true);
                    c.setPreco(c.getPreco()*0.9f);
                }  
                break;
                
            case 5:
                if(c.getIsbn().endsWith("6") || c.getIsbn().endsWith("7") ){
                    //System.out.println("ENTROU no 5");
                    c.setDesconto(true);
                    c.setPreco(c.getPreco()*0.9f);
                }    
                break;
                
            case 6:
                if (c.getIsbn().endsWith("8") || c.getIsbn().endsWith("9") ){
                    //System.out.println("ENTROU no 6");
                    c.setDesconto(true);
                    c.setPreco(c.getPreco()*0.9f);
                } 
                break;
                
            default:
                c.setDesconto(false); 
                System.out.println("ENTROU no DEFAULT");  
         }
      
    }
    
}
