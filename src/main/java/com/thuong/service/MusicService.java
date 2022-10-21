package com.thuong.service;

import com.thuong.model.Music;

import java.util.ArrayList;
import java.util.List;

public class MusicService implements IMusicService{
   private List<Music> musics= new ArrayList<>();
    @Override
    public List<Music> findAll() {
        return musics;
    }

    @Override
    public void save(Music music) {
musics.add(music);
    }

    @Override
    public Music findById(int id) {
        return musics.get(id);
    }

    @Override
    public void update(int id, Music music) {
     for (Music m :musics
          ) {
      if(m.getId()==id){
       m=music;
       break;
      }
     }
    }

    @Override
    public void remove(int id) {
for (int i=0; i< musics.size(); i++){
 if (musics.get(i).getId()==id){
  musics.remove(i);
  break;
 }
}
    }
}
