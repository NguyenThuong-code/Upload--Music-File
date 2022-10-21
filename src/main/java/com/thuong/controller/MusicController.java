package com.thuong.controller;

import com.thuong.model.Music;
import com.thuong.model.MusicForm;
import com.thuong.service.IMusicService;
import com.thuong.service.MusicService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/music")
public class MusicController {
    @Value("${file-upload}")
    private String fileUpload;
    private final IMusicService musicService= new MusicService();

    @GetMapping("")
    public String index(Model model){
        List<Music> musics = musicService.findAll();
        model.addAttribute("musics", musics);
        return "/index";
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView=new ModelAndView("/create");
        modelAndView.addObject("musicForm", new MusicForm());
        return  modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView saveMusic(@ModelAttribute MusicForm musicForm) {
        MultipartFile multipartFile = musicForm.getLink();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(musicForm.getLink().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Music music = new Music(musicForm.getId(), musicForm.getName(),
                musicForm.getProducer(), musicForm.getClassification(), fileName);
        musicService.save(music);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("musicForm", musicForm);
        modelAndView.addObject("message", "Created new music successfully !");
        return modelAndView;
    }
}
