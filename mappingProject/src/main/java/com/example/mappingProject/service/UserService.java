package com.example.mappingProject.service;

import com.example.mappingProject.entity.PlayList;
import com.example.mappingProject.entity.Songs;
import com.example.mappingProject.entity.User;
import com.example.mappingProject.models.PlayListModel;
import com.example.mappingProject.models.UserModel;
import com.example.mappingProject.repository.PlayListRepo;
import com.example.mappingProject.repository.SongsRepo;
import com.example.mappingProject.repository.UserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PlayListRepo playListRepo;

    @Autowired
    private SongsRepo songsRepo;

    public boolean checkUsernameAvailability(String username) {
        List<User> userList= userRepo.findAll();
        User foundUser= userList.stream().filter(user -> {
            if(user.getUsername()!=null){
                return user.getUsername().equals(username);
            }
            return false;
        }).findFirst().orElse(null);
        return (foundUser==null);
    }

    public void saveUserDetails(UserModel userModel) {
        if(userModel!=null){
            User user=new User();
            BeanUtils.copyProperties(userModel,user);
            userRepo.save(user);
            System.out.println(user);
        }
    }

    public UserModel getUser(String username, String password) {
        List<User> userList=userRepo.findAll();
        User userObj= userList.stream().filter(user -> (user.getUsername().equals(username) && user.getPassword().equals(password))).findFirst().orElse(null);
        if(userObj!=null){
            UserModel userModel=new UserModel();
            BeanUtils.copyProperties(userObj,userModel);
            return userModel;
        }
        return null;
    }

    public List<PlayList> getAllPlayLists(int userId) {
        User user=userRepo.getReferenceById(userId);
        return user.getPlayLists();
    }

    public PlayList returnPlayList(PlayListModel playListModel){
        PlayList playList=new PlayList();
        playList.setPlayListId(playListModel.getPlayListId());
        playList.setPlayListName(playListModel.getPlayListName());
        playList.setUser(playListModel.getUser());
        playList.setDescription(playListModel.getDescription());
        playList.setSongsList(playListModel.getSongsList());
        return playList;
    }
    public void savePlayList(PlayListModel playListModel) {
        PlayList playList=returnPlayList(playListModel);
        User user=playList.getUser();
        List<PlayList> playList1=user.getPlayLists();
        playList1.add(playList);
        playListRepo.save(playList);
    }

    public void deletePlayList(int userId, int playListId) {
        PlayList playList=playListRepo.getReferenceById(playListId);
        playListRepo.delete(playList);
    }

    private UserModel returnUserModel(User user) {
        UserModel userModel=new UserModel();

        userModel.setUsername(user.getUsername());
        userModel.setUserId(user.getUserId());
        userModel.setAddress(user.getAddress());
        userModel.setPassword(user.getPassword());
        userModel.setLastName(user.getLastName());
        userModel.setFirstName(user.getFirstName());
        userModel.setPlayLists(user.getPlayLists());
        return userModel;
    }

    public UserModel getUserModelById(int userId) {
        User user=userRepo.getReferenceById(userId);
        UserModel userModel=returnUserModel(user);
        return userModel;
    }

    public List<Songs> getAllSongs() {
        return songsRepo.findAll();
    }

    public PlayList getPlayList(int playListId) {
        return playListRepo.getReferenceById(playListId);
    }

    public void addSongToPlayList(int songId, int playListId) {
        Songs songs=songsRepo.getReferenceById(songId);
        PlayList playList=playListRepo.getReferenceById(playListId);

        List<Songs> songsList=playList.getSongsList();
        songsList.add(songs);
        playList.setSongsList(songsList);
        playListRepo.save(playList);
    }

    public void removeSongFromPlayList(int songId, int playListId) {
        Songs songs=songsRepo.getReferenceById(songId);
        PlayList playList=playListRepo.getReferenceById(playListId);

        List<Songs> songsList=playList.getSongsList();
        if(songsList.contains(songs)){
            songsList.remove(songs);
            playList.setSongsList(songsList);
            playListRepo.save(playList);
        }
    }

    public int getUserIdFromPlayList(int playListId) {
        PlayList playList=playListRepo.getReferenceById(playListId);
        return playList.getUser().getUserId();
    }
}
