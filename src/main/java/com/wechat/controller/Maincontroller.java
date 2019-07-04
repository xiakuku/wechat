package com.wechat.controller;

import com.wechat.service.Lost_itemService;
import com.wechat.service.Pick_itemService;
import com.wechat.service.UserService;
import com.wechat.uitl.AesCbcUtil;
import com.wechat.uitl.HttpRequest;

import com.wechat.uitl.MD5Demo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
//        Map map = new HashMap();
//
//        List<Lostitem_photo_user> list= lost_itemService.findAll();
//
//        list=lost_itemService.findAllInfo(list);
//        map.put("list",list);

//        return map;
        return null;
    }



    /**
     * 查找所有的 招领的物品
     * @return
     */
    @RequestMapping(value = "/getAllPickitem",method = RequestMethod.GET)
    @ResponseBody
    public Map getAllPickitem(){
//        Map map = new HashMap();
//
//        List<Pickitem_photo_user> allInfo = pick_itemService.findAll();
//        allInfo=pick_itemService.findAlladdpath(allInfo);
//        map.put("list",allInfo);
//        return map;
        return null;
    }


    //---zkt
    @RequestMapping(value = "/getPickitem",method = RequestMethod.GET)
    @ResponseBody
    public Map getPickitem(@RequestParam("pick_id") String id){
//        Integer ID = Integer.parseInt(id);
//        //System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz"+ID);
//        Map map = new HashMap();
//        Pickitem_photo_user pickitem_photoUser = pick_itemService.findOne(ID);
//        map.put("list", pickitem_photoUser);

//        return map;
        return null;
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

//    //测试
//    @RequestMapping(value = "/get",method = RequestMethod.GET)
//    @ResponseBody
//    public Lost_item getStudent(HttpServletRequest request,HttpSession session){
//       // Lost_item l=lost_itemService.findById(1);
//
//        String sessionid=request.getSession().getId();
//
//        System.out.println("sessionid:------"+sessionid);
//
////        return l;
//        return null;
//    }

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
//                if(userService.findByOPenid(openid)==null){
//                    // 则是新用户，需要插入用户信息
//                    User user =getUser(userInfoJSON);
//                    userService.insertnewObject(user);
//                }
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
//
//    public static User getUser(JSONObject jsonObject){
////        User user =new  User();
////        user.setOpenid((String) jsonObject.get("openId"));
////        user.setGender((String) jsonObject.get("gender"));
////        user.setName((String) jsonObject.get("nickName"));
////        return user;
//        return null;
//    }

//    @RequestMapping(value = "/test1", method = RequestMethod.GET)
//    public Map test1(@RequestBody User user){
//
//        Map map = new HashMap();
//        if(user.getOpenid().equals("123")){
//            map.put("status",1);
//            map.put("msg","正确");
//        }else{
//            map.put("status",0);
//            map.put("msg","错误");
//        }
//
//        return map;
//    }


//    @Autowired
//    private TestMapper testMapper;
//
//    @ResponseBody
//    @RequestMapping(value = "/test2", method = RequestMethod.GET)
//    public List<Pickitem_photo_user> test2(){
//
////        //List<Pickitem_photo_user> itemandUserAll = testMapper.getItemandUserAll();
////
////        return itemandUserAll;
//
//        return null;
//    }


}
