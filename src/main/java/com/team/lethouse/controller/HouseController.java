package com.team.lethouse.controller;

import com.github.pagehelper.PageInfo;
import com.team.lethouse.entity.House;
import com.team.lethouse.entity.Users;
import com.team.lethouse.service.HouseService;
import com.team.lethouse.util.Params;
import com.team.lethouse.util.UploadFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @创建人 廖明超
 * @创建时间 2020/9/6
 * @描述
 */
@RestController
public class HouseController {
    @Autowired
    private HouseService houseService;

    @RequestMapping("/addHouse")
    @CrossOrigin(allowCredentials ="true")
    public int addHouse(House house, HttpSession session,
                        @RequestParam(value = "pic_path",required = false) MultipartFile pfile){
        Users user = (Users) session.getAttribute("userInfo");
        if (user!=null) {
            house.setUserId(user.getId());
            house.setId(System.currentTimeMillis() + "");
            String filename = UploadFileUtil.upload(pfile, "E:\\myPicture");
            house.setPath(filename);
            return houseService.insertHouse(house);
        } else {
            return 0;
        }
    }

    @RequestMapping("/showHouse")
    @CrossOrigin
    public Map<String,Object> showHouse(HttpSession session,Integer page){
        Integer pageSize=2;
        Users user = (Users) session.getAttribute("userInfo");
        if (user!=null){
            PageInfo<House> pageInfo = houseService.selectHouses(user.getId(), page, pageSize);
            Map<String,Object> map=new HashMap<>();
            map.put("pages",pageInfo.getPages());
            map.put("houses",pageInfo.getList());
            map.put("curPage",pageInfo.getPageNum());
            return map;
        }else {
            return null;
        }
    }

    @RequestMapping("/delHouse")
    @CrossOrigin
    public boolean delHouse(String id,String filename){
        int i = houseService.deleteHouseById(id);
        if (i>0){
            File file=new File("E:\\myPicture/"+filename);
            if (file.exists()) {
                return file.delete();
            }
        }
        return false;
    }

    @RequestMapping("/showHouseByParams")
    @CrossOrigin
    public Map<String,Object> showHouseByParams(Params params){
        PageInfo<House> housePageInfo = houseService.selectHousesByParams(params);
        Map<String,Object> map=new HashMap<>();
        map.put("houseInfo",housePageInfo.getList());
        map.put("pages",housePageInfo.getPages());
        map.put("curPage",housePageInfo.getPageNum());
        map.put("prePage",housePageInfo.getPrePage());
        map.put("nextPage",housePageInfo.getNextPage());
        return map;
    }
}
