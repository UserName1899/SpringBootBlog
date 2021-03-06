package com.blog.controllers;

import com.blog.models.Post;
import com.blog.services.PostService;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {
@Autowired
private PostService  postService;;
    @RequestMapping("/")
    public String index(Model model){

        List<Post> latest5Post = postService.findLatest5();
        model.addAttribute("latest5posts", latest5Post);

        List<Post> latest3Posts = latest5Post.stream()
                .limit(3).collect(Collectors.toList());
        model.addAttribute("latest3posts" , latest3Posts);

        return "index";
    }
}
