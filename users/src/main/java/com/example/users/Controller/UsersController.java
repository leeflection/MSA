package com.example.users.Controller;

import com.example.users.dto.UserDto;
import com.example.users.entity.UserEntity;
import com.example.users.service.UserService;
import com.example.users.vo.RequestUser;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UsersController {
    private final UserService userService;
    private final Greeting greeting;

    @GetMapping("/health_check")
    public String status(){
        return "It's Working in UserService";
    }

    @GetMapping("/welcome")
    public String welcome(){
        return greeting.getMessage();
    }

    @PostMapping("users")
    public String createUser(@RequestBody RequestUser user){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto userDto = mapper.map(user, UserDto.class);
        userService.createUser(userDto);
        return "Create user method is called";
    }
}
