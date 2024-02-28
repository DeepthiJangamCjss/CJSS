package com.example.mappingProject.controller;

import com.example.mappingProject.entity.PlayList;
import com.example.mappingProject.entity.Songs;
import com.example.mappingProject.models.PlayListModel;
import com.example.mappingProject.models.UserModel;
import com.example.mappingProject.repository.PlayListRepo;
import com.example.mappingProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/userOperations")
public class userController {
    @Autowired
    private UserService userService;
    @RequestMapping("/gotoMainPage")
    public String mainPage(int userId,Model model){
        UserModel userModel=userService.getUserModelById(userId);
        model.addAttribute("userModel",userModel);
        return "userMainPage";
    }
    @RequestMapping("viewPlaylists")
    public String viewPlayList(int userId,Model model){
        List<PlayList> playListsList=userService.getAllPlayLists(userId);
        model.addAttribute("userId",userId);
        model.addAttribute("playLists",playListsList);
        return "viewPlayLists";
    }

    @RequestMapping("/addPlayList")
    public String addPlayList(int userId,Model model){
        model.addAttribute("userId",userId);
        return "addPlayList";
    }

    @RequestMapping("/savePlayList")
    public String savePlayList(PlayListModel playListModel,Model model){
        userService.savePlayList(playListModel);
        int userId=playListModel.getUser().getUserId();
        List<PlayList> playListsList=userService.getAllPlayLists(userId);
        model.addAttribute("userId",userId);
        model.addAttribute("playLists",playListsList);
        return "viewPlayLists";
    }

    @RequestMapping("/deletePlayList")
    public String deletePlayList(int userId,int playListId,Model model){
        userService.deletePlayList(userId,playListId);
        List<PlayList> playListsList=userService.getAllPlayLists(userId);
        model.addAttribute("userId",userId);
        model.addAttribute("playLists",playListsList);
        return "viewPlayLists";
    }

    @RequestMapping("/viewPlayList")
    public String viewPlayListDetails(int userId,int playListId,Model model){
        List<Songs> songsList=userService.getAllSongs();
        PlayList playList=userService.getPlayList(playListId);
        model.addAttribute("playList",playList);
        model.addAttribute("songsList",songsList);
        System.out.println(songsList);
        return "viewPlayListDetails";
    }

    @RequestMapping("addSongToPlayList")
    public String addSongToPlayList(int songId,int playListId,Model model){
        userService.addSongToPlayList(songId,playListId);

        List<Songs> songsList=userService.getAllSongs();
        PlayList playList=userService.getPlayList(playListId);
        model.addAttribute("playList",playList);
        model.addAttribute("songsList",songsList);
        System.out.println(songsList);
        return "viewPlayListDetails";
    }

    @RequestMapping("/removeSongFromPlayList")
    public String removeSongFromPlayList(int songId,int playListId,Model model){
        userService.removeSongFromPlayList(songId,playListId);

        List<Songs> songsList=userService.getAllSongs();
        PlayList playList=userService.getPlayList(playListId);
        model.addAttribute("playList",playList);
        model.addAttribute("songsList",songsList);
        System.out.println(songsList);
        return "viewPlayListDetails";
    }
}
