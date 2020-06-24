package com.taobao.demo.config;



import com.taobao.demo.entity.Book;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author zhaoxu
 */
@Component
public class DataBase {
    private static Map<String,String> userMap = new HashMap<>();

    private static Map<String, Book> bookMap = new HashMap<>();

    public DataBase(){
        Book book = new Book();
        book.setId(1L);
        book.setPrice(new BigDecimal(100));
        book.setAuthor("cc");
        book.setName("JAVA编程思想");
        book.setNum(10);
        Book book1 = new Book();
        book1.setId(1L);
        book1.setPrice(new BigDecimal(124));
        book1.setAuthor("校花");
        book1.setName("红楼梦");
        book1.setNum(9);
        userMap.put("admin","123");

        bookMap.put(book.getName(),book);
        bookMap.put(book1.getName(),book1);
    }
     public Boolean addUser(String userName,String passWord){
         if (userName==null||"".equals(userName)||null==passWord||"".equals(passWord)){
             return false;
         }
       if (userMap.containsKey(userName)){
           return false;
       }
         userMap.put(userName,passWord);
       return true;
     }


     public Boolean updatePassWord(String userName,String passWord){
         if (userName==null||"".equals(userName)||null==passWord||"".equals(passWord)){
             return false;
         }
         if (!userMap.containsKey(userName)){
             return false;
         }
         userMap.put(userName,passWord);
         return true;
     }

     public Boolean deleteUser(String userName){
         if (userName==null||"".equals(userName)){
             return false;
         }
         userMap.remove(userName);
         return true;
     }

     public Map<String,String> findUserByName(String userName){
         Map<String,String> reMap = new HashMap<>(1);
         if (userName==null||"".equals(userName)){
             return reMap;
         }
        String re =  userMap.get(userName);
         if (re!=null){
             reMap.put(userName,re);
         }

         return reMap;
     }

     public Map<String,String> findAllUser(){
        return userMap;
     }


     public boolean addBook(Book book){
           if (book==null){
               return false;
           }
            Book book1 = bookMap.get(book.getName());
            if (book1!=null){
                return false;
            }
           bookMap.put(book.getName(),book);
            return true;
    }

    public boolean delBook(String name){
        if (!bookMap.containsKey(name)){
            return false;
        }
        bookMap.remove(name);
        return true;
    }

    public Map<String,Book> findAllBook(){
        return bookMap;
    }
    public Boolean updateBook(Book book){
        if (book==null){
            return false;
        }
        if (bookMap.containsKey(book.getName())){
            bookMap.put(book.getName(),book);
            return true;
        }
        return false;
    }
}
