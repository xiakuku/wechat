package com.wechat.controller;

import com.wechat.model.*;
import com.wechat.service.Lost_itemService;
import com.wechat.service.Pick_itemService;
import com.wechat.service.UserService;
import com.wechat.uitl.AesCbcUtil;
import com.wechat.uitl.HttpRequest;

import com.wechat.uitl.MD5Demo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class Maincontroller {

    @Autowired
    private Lost_itemService lost_itemService;


    @Autowired
    private Pick_itemService pick_itemService;

    @Autowired
    private UserService userService;



    /**
     *  查找所有丢失物品
     * @return
     */
    @RequestMapping(value = "/getAllLostitem",method = RequestMethod.GET)
    @ResponseBody
    public Map getAllLostitem(){
        Map map = new HashMap();
        List<Lost_item> lost_items =lost_itemService.findAll();
        //map.put("Lost_items",lost_items);

        List<Lost_and_photo> list =lost_itemService.findAllInfo(lost_items);
        map.put("list",list);
        return map;
    }

    /**
     * 查找所有的 招领的物品
     * @return
     */
    @RequestMapping(value = "/getAllPickitem",method = RequestMethod.GET)
    @ResponseBody
    public Map getAllPickitem(){
        Map map = new HashMap();
        List<Pick_up_items> Pick_items =pick_itemService.findAll();
       // map.put("Pick_items",Pick_items);

        List<Pick_and_photo> list =pick_itemService.findAllInfo(Pick_items);

        System.out.println(list);


        map.put("list",list);

        return map;
    }

    @RequestMapping(value = "/test" , method = RequestMethod.GET)
    @ResponseBody
    public String getAllLost_up_Items (HttpServletRequest request,HttpSession session){
        String head=request.getHeader("Cookie");
        System.out.println("head:-----"+head);


        session.setAttribute("1","222");


        String sessionid=request.getSession().getId();

        System.out.println("sessionid:------"+sessionid);

        return null;
    }

    //测试
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    @ResponseBody
    public Lost_item getStudent(HttpServletRequest request,HttpSession session){
        Lost_item l=lost_itemService.findById(1);

        String sessionid=request.getSession().getId();
        System.out.println("sessionid:------"+sessionid);

        return l;
    }

    @ResponseBody
    @RequestMapping(value = "/authorize", method = RequestMethod.POST)
    public Map decodeUserInfo(String encryptedData, String iv, String code, HttpRequest request, HttpSession session) {

        Map map = new HashMap();
//        System.out.println("1:"+encryptedData);
//        System.out.println("2:"+iv);
//        System.out.println("3:"+code);


        //登录凭证不能为空
        if (code == null || code.length() == 0) {
            map.put("status", 0);
            map.put("msg", "code 不能为空");
            return map;
        }

        //小程序唯一标识   (在微信小程序管理后台获取)
        String wxspAppid = "wxb6ce3f3f9a80a47a";
        //小程序的 app secret (在微信小程序管理后台获取)
        String wxspSecret = "215be1eaca90f6c1f5f4d13440e461c8";
        //授权（必填）
        String grant_type = "authorization_code";


        //////////////// 1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid ////////////////
        //请求参数
        String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + code + "&grant_type=" + grant_type;
        //发送请求

        String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
                                        // https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code
        System.out.println("sr:"+sr);
        //解析相应内容（转换成json对象）
        JSONObject json = JSONObject.fromObject(sr);

        //获取会话密钥（session_key）
        String session_key = json.get("session_key").toString();
        //用户的唯一标识（openid）
        String openid = (String) json.get("openid");

        String rd_session = MD5Demo.MD5_100(openid);

        //session.setAttribute(rd_session,openid);

        //////////////// 2、对encryptedData加密数据进行AES解密 ////////////////
        try {
            String result = AesCbcUtil.decrypt(encryptedData, session_key, iv, "UTF-8");
            if (null != result && result.length() > 0) {
                map.put("status", 1);
                map.put("msg", "解密成功");

                JSONObject userInfoJSON = JSONObject.fromObject(result);
                Map userInfo = new HashMap();
                //  userInfo.put("openId", userInfoJSON.get("openId"));
                userInfo.put("rd_session",rd_session);
                userInfo.put("nickName", userInfoJSON.get("nickName"));
                userInfo.put("gender", userInfoJSON.get("gender"));
                userInfo.put("city", userInfoJSON.get("city"));
                userInfo.put("province", userInfoJSON.get("province"));
                userInfo.put("country", userInfoJSON.get("country"));
                userInfo.put("avatarUrl", userInfoJSON.get("avatarUrl"));
                userInfo.put("unionId", userInfoJSON.get("unionId"));
                map.put("userInfo", userInfo);
                if(userService.findByOPenid(openid)==null){
                    // 则是新用户，需要插入用户信息
                    User user =getUser(userInfoJSON);
                    userService.insertnewObject(user);
                }
                session.setAttribute(rd_session,openid);
                return map;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("status", 0);
        map.put("msg", "解密失败");
        return map;
    }

    public static User getUser(JSONObject jsonObject){
        User user =new  User();
        user.setOpenid((String) jsonObject.get("openId"));
        user.setGender((String) jsonObject.get("gender"));
        user.setName((String) jsonObject.get("nickName"));
        return user;
    }

}
