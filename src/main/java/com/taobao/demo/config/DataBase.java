package com.taobao.demo.config;



import com.taobao.demo.entity.Book;
import com.taobao.demo.entity.ClassInfo;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author zhaoxu
 */
@Component
public class DataBase {
    private static Map<String,String> userMap = new HashMap<>();

    private static Map<String, Book> bookMap = new HashMap<>();

    private static Map<String,ClassInfo> classInfoMap = new HashMap<>();

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
        Book b1 = new Book(3L,"三年高考，五年模拟",new BigDecimal(22),32,"王羲之");
        Book b2 = new Book(4L,"Java 核心技术",new BigDecimal(89),21,"周立新");
        Book b3 = new Book(4L,"Java开发实战",new BigDecimal(99.00),33,"J");
        Book b4 = new Book(5L,"Effective Java",new BigDecimal(109),77,"Joshua Bloch");
        Book b5 = new Book(6L,"Spring揭秘",new BigDecimal(67),11,"王福强");
        Book b6 = new Book(7L,"分布式 Java 应用：基础与实践",new BigDecimal(189),87,"林昊");
        Book b7 = new Book(8L,"http权威指南",new BigDecimal(134),9,"David Gourley");
        Book b8 = new Book(9L,"深入理解 Java 虚拟机",new BigDecimal(231),19,"周志明");
        userMap.put("admin","123");
        bookMap.put(book.getName(),book);
        bookMap.put(book1.getName(),book1);
        bookMap.put(b1.getName(),b1);
        bookMap.put(b2.getName(),b2);
        bookMap.put(b3.getName(),b3);
        bookMap.put(b4.getName(),b4);
        bookMap.put(b5.getName(),b5);
        bookMap.put(b6.getName(),b6);
        bookMap.put(b7.getName(),b7);
        bookMap.put(b8.getName(),b8);

        ClassInfo c1 = new ClassInfo(1L,"初一三班","老王","66");
        ClassInfo c2 = new ClassInfo(2L,"初一五班","二哈","66");
        ClassInfo c3 =new ClassInfo(3L,"高三八班","老张","45");
        ClassInfo c4 =new ClassInfo(4L,"高三九班","老张","45");
        ClassInfo c5 =new ClassInfo(5L,"高三二班","老张","45");
        ClassInfo classInfo = new ClassInfo();
        classInfo.setId(7L);
        classInfo.setName("不知道");
        classInfo.setStuNum("111");
        classInfo.setTeacherName("12323213123");
        classInfoMap.put(c1.getName(),c1);
        classInfoMap.put(c2.getName(),c2);
        classInfoMap.put(c3.getName(),c3);
        classInfoMap.put(c4.getName(),c4);
        classInfoMap.put(c5.getName(),c5);
        classInfoMap.put("1",classInfo);

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




    public Map<String, ClassInfo> findAllClass(){
        return classInfoMap;
    }


}
