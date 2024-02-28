package com.example.mappingProject.controller;

import com.example.mappingProject.entity.SongDetails;
import com.example.mappingProject.entity.Songs;
import com.example.mappingProject.entity.User;
import com.example.mappingProject.models.AdminModel;
import com.example.mappingProject.models.AlbumModel;
import com.example.mappingProject.models.SongsModel;
import com.example.mappingProject.repository.AlbumRepo;
import com.example.mappingProject.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/adminOperations")
public class adminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/mainPage")
    public String gotoMainPage(){
        return "adminMainPage";
    }

    @RequestMapping("/addAlbum")
    public String addAlbum(){
        return "addAlbum";
    }

    @RequestMapping("/saveAlbum")
    public String  saveAlbum(String albumTitle, String artist,Model model){
        AlbumModel albumModel=new AlbumModel(albumTitle,artist,0);
        AlbumModel albumModelResult = adminService.addAlbum(albumModel);
        model.addAttribute("albumModel",albumModelResult);
        if(albumModelResult==null){
            return "albumTitleExists";
        }
        return "albumDetails";
    }

    @RequestMapping("/albumDetails")
    public String viewAlbumDetails(int albumID,Model model){
        AlbumModel albumModel=adminService.getAlbumModel(albumID);
        model.addAttribute("albumModel",albumModel);
        return "albumDetails";
    }

    @RequestMapping("/addSong")
    public String addSong(int albumID, Model model){
        model.addAttribute("albumID",albumID);
        System.out.println(albumID);
        return "addSong";
    }

    @RequestMapping("/saveSong")
    public String saveSong(int albumID,String title,String genre,String duration,Model model){
        System.out.println(albumID);
        adminService.saveSong(albumID,title,genre,duration);
        model.addAttribute("albumID",albumID);
        return "addSong";
    }

    @RequestMapping("/goToAlbumDetails")
    public String goToAlbumDetails(int albumID,Model model){
        AlbumModel albumModel=adminService.getAlbumModel(albumID);
        model.addAttribute("albumModel",albumModel);
        return "albumDetails";
    }

    @RequestMapping("/viewAlbums")
    public String viewAllAlbums(Model model){
        List<AlbumModel> albumModelList=adminService.getAllAlbums();
        model.addAttribute("albumModelList",albumModelList);
        return "viewAllAlbums";
    }

    @RequestMapping("/deleteSong")
    public String deleteSong(int albumID,int songId,Model model){
        adminService.deleteSong(albumID,songId);
        AlbumModel albumModel=adminService.getAlbumModel(albumID);
        model.addAttribute("albumModel",albumModel);
        return "albumDetails";
    }

    @RequestMapping("/viewUsers")
    public String viewAllUsers(Model model){
        List<User> userList=adminService.getAllUsers();
        model.addAttribute("userList",userList);
        return "viewAllUsers";
    }

    @RequestMapping(value = "/deleteUser")
    public String deleteUser(int userId,Model model){
        adminService.deleteUser(userId);
        List<User> userList=adminService.getAllUsers();
        model.addAttribute("userList",userList);
        return "viewAllUsers";
    }
}
