package com.example.mappingProject.service;

import com.example.mappingProject.entity.*;
import com.example.mappingProject.models.AdminModel;
import com.example.mappingProject.models.AlbumModel;
import com.example.mappingProject.models.SongDetailsModel;
import com.example.mappingProject.models.SongsModel;
import com.example.mappingProject.repository.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    private PlayListRepo playListRepo;

    @Autowired
    private AlbumRepo albumRepo;
    @Autowired
    private AdminModel adminModel;

    @Autowired
    private SongsRepo songsRepo;

    @Autowired
    private SongDetailsRepo songDetailsRepo;

    @Autowired
    private UserRepo userRepo;

    public boolean checkCredentials(AdminModel adminModel2) {
        return adminModel.getUsername().equals(adminModel2.getUsername()) && adminModel.getPassword().equals(adminModel2.getPassword());
    }

    public AlbumModel addAlbum(AlbumModel albumModel) {
        Album album=new Album();
        BeanUtils.copyProperties(albumModel,album);
        List<Album> albumList=albumRepo.findAll();
        Album albumFound=albumList.stream().filter(album1 -> album1.getAlbumTitle().equals(album.getAlbumTitle())).findFirst().orElse(null);
        if(albumFound==null){
            albumRepo.save(album);
            BeanUtils.copyProperties(album,albumModel);
            return albumModel;
        }
        return null;
    }

    public void saveSong(int albumId,String title, String genre, String duration) {
        SongsModel songsModel=new SongsModel();
        songsModel.setTitle(title);
        Album album=albumRepo.getReferenceById(albumId);
        songsModel.setAlbum(album);

        SongDetailsModel songDetailsModel=new SongDetailsModel();
        songDetailsModel.setDuration(duration);
        songDetailsModel.setGenre(genre);
        SongDetails songDetails=new SongDetails();
        BeanUtils.copyProperties(songDetailsModel,songDetails);

        songsModel.setSongDetails(songDetails);
        Songs songs=new Songs();

        BeanUtils.copyProperties(songsModel,songs);
        songs.setSongDetails(songDetails);

        songDetails.setSongs(songs);
        List<Songs> songsList=album.getSongsList();
        songsList.add(songs);
        album.setSongsList(songsList);
        songs.setAlbum(album);

        System.out.println(album);
        System.out.println(songs);
        System.out.println(songDetails);

        songDetailsRepo.save(songDetails);
        songsRepo.save(songs);
        albumRepo.save(album);

        songs.setAlbum(album);
        album.setSongsList(songsList);
        album.setNumberOfTracks(album.getSongsList().size());
        songsRepo.save(songs);
        albumRepo.save(album);

        System.out.println(album);
        System.out.println(songs);
        System.out.println(songDetails);
    }

    public AlbumModel getAlbumModel(int albumId) {
        Album album= albumRepo.getReferenceById(albumId);
        AlbumModel albumModel = new AlbumModel();
        BeanUtils.copyProperties(album,albumModel);
        return albumModel;
    }

    public List<AlbumModel> getAllAlbums() {
        List<Album> albumList=albumRepo.findAll();
        List<AlbumModel> albumModelList=new ArrayList<>();
        albumList.forEach(album ->{
            AlbumModel albumModel=new AlbumModel();
            BeanUtils.copyProperties(album,albumModel);
            albumModelList.add(albumModel);
        });
        return albumModelList;
    }

    public void deleteSong(int albumID, int songId) {
        Album album=albumRepo.getReferenceById(albumID);
        Songs song=songsRepo.getReferenceById(songId);
        SongDetails songDetails=song.getSongDetails();

        songDetailsRepo.delete(songDetails);
        song.setSongDetails(null);
        List<Songs> songsList=album.getSongsList();
        songsList.remove(song);
        album.setSongsList(songsList);
        album.setNumberOfTracks(songsList.size());

        List<PlayList> playLists=playListRepo.findAll();
        playLists.forEach(playList -> {
            List<Songs> songList=playList.getSongsList();
            if(songList.contains(song)){
                songList.remove(song);
                playList.setSongsList(songList);
                playListRepo.save(playList);
            }
        });

        songsRepo.delete(song);
        albumRepo.save(album);
    }

    public List<User> getAllUsers() {
        List<User> userList=userRepo.findAll();
        return userList;
    }

    public void deleteUser(int userId) {
        User user=userRepo.getReferenceById(userId);
        if(user!=null){
            List<PlayList> playLists= user.getPlayLists();
            playLists.forEach(playList -> {
                playList.getSongsList().forEach(song -> song.setPlayList(new ArrayList<>()));
                playList.setSongsList(new ArrayList<>());
                playListRepo.delete(playList);
            });
            userRepo.delete(user);
        }
    }
}
