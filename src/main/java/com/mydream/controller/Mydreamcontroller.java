package com.mydream.controller;

import com.mydream.doman.*;
import com.mydream.repository.*;
import com.mydream.service.Mydreamservice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

/**
 * @Author: 张灿
 * @Time: 2019/11/25 15:10
 */
@RestController
@CrossOrigin
public class Mydreamcontroller {


    private final static Logger logger = LoggerFactory.getLogger(Mydreamcontroller.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private ActirRepository actirRepository;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private ActirNoteRepository actirNoteRepository;

    @Autowired
    private Mydreamservice mydreamservice;

    @Autowired
    private AdminRepository adminRepository;


    @Autowired
    private UserProjectRepository userRepos;

    /**
     * 查询所有用户
     * @return
     */
    @GetMapping("/listuser")
    public List<MydreamUser> listuser(){
        return userRepository.findAll();
    }


    /**
     * 通过userId查用户
     * @param userId
     * @return
     */
    @GetMapping("/listactir/userId")
    public MydreamUser findByUserId(@RequestParam("userId") Integer userId){
        return userRepository.findById(userId).orElse(null);
    }

    /**
     * 根据用户名查询某人
     * @param username
     * @return
     */
    @GetMapping("/listuser/name")
    public MydreamUser findUserByName(@RequestParam("username") String username){
        return userRepository.findByUsername(username).orElse(null);
    }

    /**
     * 登录
     * @param name
     * @param passwd
     * @param request
     * @param session
     * @return
     */
//    @PostMapping("/login")
//    @CrossOrigin
//    public boolean Login(@RequestParam("username") String name,@RequestParam("password") String password,HttpServletRequest request, HttpSession session,HttpServletResponse response){
//        MydreamUser mydreamUser = new MydreamUser();
//        Optional<MydreamUser> optional = userRepository.findByUsername(name);
//        if(optional.isPresent()){
//            mydreamUser = optional.get();
//        }
//        if(!(mydreamUser.getPassword().equals(password))){
//            return false;
//        }else {
//            Cookie[] cookies = request.getCookies();
//            if (cookies != null && cookies.length > 0) {
//                for (Cookie cookie : cookies) {
//                    if (cookie.getName().contains("JSEEION")) {
//                        System.out.println(cookie.getName() + "=" + cookie.getValue());
//                    }
//                }
//            }
//            Object value = session.getAttribute("username");
//            if (value == null) {
//                System.out.println("用户名不存在");
//                session.setAttribute("user", "{username:'" + name + "',old:'" + mydreamUser.getOld() + "',stuId:'" + mydreamUser.getStuid() + "'}");
//                stringRedisTemplate.opsForValue().set(session.getId(),mydreamUser.toString());
//                Cookie cook_name = new Cookie("username",name);
//                response.addCookie(cook_name);
//
//            } else {
//                System.out.println("用户存在");
//            }
//
//
//
//            response.setHeader("Access-Control-Allow-Origin", "*");
////            response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
////            response.addHeader("Access-Control-Allow-Origin", "*");
////            response.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
//
//
//
//            return true;
//        }
//    }


    /**
     * 退出
     * @param request
     * @param session
     * @return
     */
//    @RequestMapping("/out")
//    public boolean Out(HttpServletRequest request, HttpSession session){
//        session = request.getSession();
//        session.invalidate();
//        if(stringRedisTemplate.delete(session.getId())){
//            return true;
//        }else {
//            return false;
//        }
//    }





    /**
     * 注册服务
     * @param username
     * @param passwd
     * @param word
     * @param sco
     * @param stuid
     * @param edu
     * @param real_name
     * @param tel
     * @param tal
     * @param old
     * @param sex
     * @return
     */
     @PostMapping("/sign")
    public MydreamUser sign(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             @RequestParam(value = "word" ,required = false) String word,
                             @RequestParam(value = "sco",required = false) Integer sco,
                             @RequestParam(value = "stuid",required = false) Integer stuid,
                             @RequestParam("edu") String edu,
                             @RequestParam("real_name") String real_name,
                             @RequestParam("tel") String tel,
                             @RequestParam(value = "tal",required = false) String tal,
                             @RequestParam("old") Integer old,
                             @RequestParam("sex") String sex){
        MydreamUser mydreamUser = new MydreamUser();
        mydreamUser.setUsername(username);
        mydreamUser.setPassword(passwordEncoder.encode(password));
        mydreamUser.setOld(old);
        mydreamUser.setSex(sex);
        mydreamUser.setReal_name(real_name);
        mydreamUser.setEdu(edu);
        mydreamUser.setTel(tel);
        mydreamUser.setTal(tal);
        mydreamUser.setStuid(stuid);
        mydreamUser.setWord(word);
        mydreamUser.setSco(sco);
        mydreamUser.setRoles("user");
        return userRepository.save(mydreamUser);
    }


    /**
     * 通过活动名查询某个活动
     * @param name
     * @return
     */
    @GetMapping("/admin/listactir/name")
    public MydreamActir findActirByName(@RequestParam("name") String name){
        return actirRepository.findAllByNameEquals(name).orElse(null);
    }


    /**
     * 通过actirId查活动
     * @param actirId
     * @return
     */
    @GetMapping("/admin/listactir/actirId")
    public MydreamActir findByActirId(@RequestParam("actirId") Integer actirId){
        return actirRepository.findById(actirId).orElse(null);
    }

    /**
     * 查询所有活动
     * @return
     */
    @GetMapping("/user/listcatir")
    public List<MydreamActir> listactir(){
        return actirRepository.findAll();
    }


    /**
     * 创建活动
     * @param userId
     * @param actirId
     * @param name
     * @param place
     * @param job
     * @param num
     * @param qua
     * @param reward
     * @return
     */
    @PostMapping("/user/creatactir")
    public MydreamActir creatactir(@RequestParam("userId") Integer userId,
                              @RequestParam("actirId") Integer actirId,
                              @RequestParam("name") String name,
                              @RequestParam("place") String place,
                              @RequestParam("job") String job,
                              @RequestParam(value = "num",required = false) Integer num,
                              @RequestParam(value = "qua",required = false) String qua,
                              @RequestParam(value = "reward",required = false) String reward){
        MydreamActir mydreamActir = new MydreamActir();
        mydreamActir.setUserId(userId);
        mydreamActir.setActirId(actirId);
        mydreamActir.setJob(job);
        mydreamActir.setName(name);
        mydreamActir.setPlace(place);
        mydreamActir.setNum(num);
        mydreamActir.setReward(reward);
        mydreamActir.setQua(qua);

        return actirRepository.save(mydreamActir);

    }


    /**
     * 通过actirId修改活动
     * @param actirId
     * @param name
     * @param place
     * @param job
     * @param num
     * @param qua
     * @param reward
     * @return
     */
    @PostMapping("/user/updateactir")
    public MydreamActir updateactir(@RequestParam(value = "actirId",required = true) Integer actirId,
                                    @RequestParam(value = "name",required = false) String name,
                                    @RequestParam(value = "place",required = false) String place,
                                    @RequestParam(value = "job",required = false) String job,
                                    @RequestParam(value = "num",required = false) Integer num,
                                    @RequestParam(value = "qua",required = false) String qua,
                                    @RequestParam(value = "reward",required = false) String reward){
        MydreamActir mydreamActir = new MydreamActir();
        System.out.println(actirId);
        Optional<MydreamActir> mydreamActirOptional = actirRepository.findById(actirId);
        if(mydreamActirOptional.isPresent()){
            mydreamActir = mydreamActirOptional.get();
        }

        mydreamActir.setJob(mydreamservice.isNull(job,mydreamActir.getJob()));
        mydreamActir.setName(mydreamservice.isNull(name,mydreamActir.getName()));
        mydreamActir.setPlace(mydreamservice.isNull(place,mydreamActir.getPlace()));
        mydreamActir.setNum(mydreamservice.isNull(num,mydreamActir.getNum()));
        mydreamActir.setReward(mydreamservice.isNull(reward,mydreamActir.getReward()));
        mydreamActir.setQua(mydreamservice.isNull(qua,mydreamActir.getQua()));

        return actirRepository.save(mydreamActir);

    }


    /**
     * 添加用户收藏
     * @param userId
     * @param actirId
     * @return
     */
    @PostMapping("/user/likeactir")
    public ActirNotes likeactir(@RequestParam("userId") Integer userId,@RequestParam("actirId") Integer actirId){

        ActirNotes actirNotes = new ActirNotes();
        actirNotes.setUserId(userId);
        actirNotes.setActirId(actirId);
        return actirNoteRepository.save(actirNotes);


    }


    @PostMapping("/user/dellike")
    public boolean dellike(@RequestParam("userId") Integer userId,@RequestParam("actirId") Integer actirId){


        ActirNotes actirNotes = new ActirNotes();

        Optional<ActirNotes> optional = actirNoteRepository.findByUserIdEqualsAndActirIdEquals(userId,actirId);

        if (optional.isPresent()){
            actirNotes = optional.get();
        }


        actirNoteRepository.deleteByNoteId(actirNotes.getNoteId());
       optional = actirNoteRepository.findByUserIdEqualsAndActirIdEquals(userId,actirId);

       if (optional.isPresent()){

           return  false;
       }
        return true;
    }


    /**
     * 查询用户的活动
     * @param userId
     * @return
     */
    @PostMapping("/user/useractir")
    public List<ActirNotes> actirNotesList(@RequestParam("userId") Integer userId){



        return actirNoteRepository.findAllByUserIdEquals(userId);

    }



    @PostMapping("/adminlogin")
    public boolean adminlogin(@RequestParam("adminId") Integer adminId,@RequestParam("passwd") String passwd,HttpSession session,HttpServletRequest request){

        Optional<Admin> adminOptional = adminRepository.findById(adminId);

        Admin admin = new Admin();

        if (adminOptional.isPresent()){
            admin = adminOptional.get();
        }

        if(!(admin.getPasswd().equals(passwd))){
            return false;
        }else {
            Cookie[] cookies = request.getCookies();
            if (cookies != null && cookies.length > 0) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().contains("admin")) {
                        System.out.println(cookie.getName() + "=" + cookie.getValue());
                    }
                }
            }

            Object value = session.getAttribute("admin");
            if (value == null) {
                System.out.println("用户名不存在");
                session.setAttribute("admin", "{adminId:'" + adminId + "'}");
                stringRedisTemplate.opsForValue().set(session.getId(),admin.toString());
            } else {
                System.out.println("用户存在");
            }


            return true;
        }



    }

    @PostMapping("/admin/deluser")
    public boolean deluser(@RequestParam("userId") Integer userId,HttpSession session){
        if(session.getAttribute(session.getId()).equals("admin")){

            userRepository.deleteById(userId);

            return true;
        }

        return false;

    }

    @PostMapping("/admin/examine")
    public boolean examine(@RequestParam("actirId") Integer actirId,HttpSession session,HttpServletRequest request){

        MydreamActir mydreamActir = new MydreamActir();

        Optional<MydreamActir> mydreamActirOptional = actirRepository.findById(actirId);
        if(session.getAttribute(session.getId()).equals("admin")){

        if (mydreamActirOptional.isPresent()){

            mydreamActir = mydreamActirOptional.get();


            }

            mydreamActir.setAllow("1");
            return true;
        }

        return false;

    }

    @PostMapping("/admin/delexamine")
    public boolean delexamine(@RequestParam("actirId") Integer actirId,HttpSession session){

        MydreamActir mydreamActir = new MydreamActir();

        Optional<MydreamActir> mydreamActirOptional = actirRepository.findById(actirId);
        if(session.getAttribute(session.getId()).equals("admin")){

            if (mydreamActirOptional.isPresent()){

                mydreamActir = mydreamActirOptional.get();


            }

            mydreamActir.setAllow("0");
            return true;
        }

        return false;

    }


    @PostMapping("/joinactir")
    public UserProject joinactir(@RequestParam("actirId") Integer actirId, @RequestParam("userId") Integer userId){


        UserProject userProject = new UserProject();

        userProject.setActirId(actirId);

        userProject.setUserId(userId);


        return userRepos.save(userProject);


    }



}
