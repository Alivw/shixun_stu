package com.jalivv.stu.web;

import com.jalivv.stu.constant.RedisKeyPrefixConstant;
import com.jalivv.stu.entity.Result;
import com.jalivv.stu.entity.User;
import com.jalivv.stu.service.UserService;
import com.jalivv.stu.utils.ValidateImageCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;



    @RequestMapping("/image")
    public void getImage(HttpSession session, HttpServletResponse response) throws IOException {
        //获取验证码id，放入redis中
        String code = ValidateImageCodeUtils.getSecurityCode();
        System.out.println("code = " + code);
        //放入 redis
        redisTemplate.opsForValue().set(RedisKeyPrefixConstant.CAPTURE + session.getId(), code, 1, TimeUnit.MINUTES);
        //生成验证码图片
        BufferedImage image = ValidateImageCodeUtils.createImage(code);
        ImageIO.write(image, "png", response.getOutputStream());
    }


    @RequestMapping("/register")
    public Result register(User user, String code, HttpSession session) {
        Result result = new Result();
        try {
            // 判断 code
            String codeInRedis = (String) redisTemplate.opsForValue().get(RedisKeyPrefixConstant.CAPTURE + session.getId());
            if (StringUtils.isEmpty(codeInRedis)) {
                throw new RuntimeException("验证码已过期");
            }
            if (!codeInRedis.equalsIgnoreCase(code)) {
                throw new RuntimeException("验证码不正确");
            }
            result = userService.register(user, code);
        } catch (Exception e) {
            result.setMessage("注册失败:" + e.getMessage()).setStatus(false);
        }
        return result;
    }

    @PostMapping("/login")
    public Result login(User user, String code, HttpSession session) {
        Result result = new Result();
        try {
            // 判断 code
            String codeInRedis = (String) redisTemplate.opsForValue().get(RedisKeyPrefixConstant.CAPTURE + session.getId());
            if (StringUtils.isEmpty(codeInRedis)) {
                throw new RuntimeException("验证码已过期");
            }
            if (!codeInRedis.equalsIgnoreCase(code)) {
                throw new RuntimeException("验证码不正确");
            }

            User u = userService.getUserByName(user.getName());
            session.setAttribute("user", u);
            // redisTemplate.opsForValue().set(RedisKeyPrefixConstant.USER_INFO + session.getId(), u);
            redisTemplate.opsForValue().set(RedisKeyPrefixConstant.USER_INFO + session.getId(), u);
            return result.setStatus(true).setMessage("登陆成功！").setData(u);
        } catch (Exception e) {
            result.setMessage("登陆失败:" + e.getMessage()).setStatus(false);
        }
        return result;
    }

    @PostMapping("/logout")
    public Result logout(HttpSession session) {
        Result r = new Result();
        try {
            session.removeAttribute("user");
            r.setStatus(true).setMessage("退出成功");
        } catch (Exception e) {
            r.setStatus(false).setMessage("退出失败：" + e.getMessage());
        }

        return r;
    }
}
