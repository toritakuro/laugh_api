package com.c4ccup.laugh.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.c4ccup.laugh.controller.bean.TopBean;
import com.c4ccup.laugh.controller.bean.UserBean;
import com.c4ccup.laugh.domain.User;
import com.c4ccup.laugh.repository.ComedianRepository;
import com.c4ccup.laugh.repository.ComedyStyleRepository;
import com.c4ccup.laugh.repository.ComposerRepository;
import com.c4ccup.laugh.repository.UserRepository;


/**
 * CRUDを操作するTopクラス
 *
 */
@RequestMapping(value = "top")
@RestController
public class TopController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ComedianRepository comedianRepository;
    @Autowired
    private ComposerRepository composerRepository;
    @Autowired
    private ComedyStyleRepository comedyStyleRepository;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public TopBean init(UserBean userBean) {
        TopBean topBean = new TopBean();
        User user = new User();
        user.setUserType(0);
        userBean.setUserType(0);
        List<User> userList = new ArrayList<>();
        List<String> belongList = new ArrayList<>();
        
        if (userBean.getUserType() == 0) {
            userList = userRepository.getComposerList(userBean);
            belongList = composerRepository.getBelongList();
        } else {
            userList = userRepository.getComedianList(userBean);
            belongList = comedianRepository.getBelongList();
        }
        
//        List<String> comedyStyleList = new ArrayList<>();
//        comedyStyleList = comedyStyleRepository.getcomedyStyleList();
//        
//        List<Integer> feeList = new ArrayList<>();
//        feeList = composerRepository.getFeeList();
//        
//        List<String> skillList = new ArrayList<>();
//        skillList = composerRepository.getSkillList();
        
        topBean.setUserList(userList);
        topBean.setBelongList(belongList);
//        topBean.setComedyStyleList(comedyStyleList);
//        topBean.setOwnComedyStyleList(comedyStyleList);
//        topBean.setFeeList(feeList);
//        topBean.setSkillList(skillList);
        
        return topBean;
    }
}
