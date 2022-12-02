package com.example.RestApi;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MyController {

    Map<Integer, User> users  = new HashMap<>();
 @GetMapping("/get_users")
    public List<User> getUsers(){
        List<User> listOfUsers = new ArrayList<>();
        for(User user:users.values())
            listOfUsers.add(user);
        return listOfUsers;
    }
    @PostMapping("/add_user")
    public void adduser(@RequestParam(value="id") int id,
                        @RequestParam("name") String name,
                        @RequestParam("age") int age,
                        @RequestParam("country") String country){
     User user = new User(id,name, country, age);
     users.put(id, user);
    }
    @PostMapping("/add_user_body")
    public void addUserBody(@RequestBody(required = true) User u){
     users.put(u.getId(), u);
    }
    @GetMapping("get_user/{id}")
    public User getuser(@PathVariable("id") int x)
    {
        return users.get(x);
    }
    @DeleteMapping("/del_user/{id}")
    public void deleteuser(@PathVariable("id") int idx)
    {
        users.remove(idx);
    }
    @PutMapping("/update/{id} ")
    public void updateUser(@PathVariable("id") int id, @RequestBody() User u)
    {
        users.put(id, u);
    }

}
