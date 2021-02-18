package com.teamtreehouse.giflib.controller;

import com.teamtreehouse.giflib.data.GifRepository;
import com.teamtreehouse.giflib.model.Gif;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GifController {
  @Autowired
  private GifRepository gifRepository;

  // map a certain URI request to a Java method
  @RequestMapping(value = "/") // the URI pattern that we want to map to the method below
  // @ResponseBody // to indicate that the strings we return should be used as the response without any
  // further processing
  // Since we need further processing by Thymeleaf, we will return a string that matches the name of HTML
  // templates minus the file extension
  public String listGifs(ModelMap modelMap) {
    List<Gif> allGifs = gifRepository.getAllGifs();
    modelMap.put("gifs", allGifs);
    return "home";
  }

  // URL => http://localhost:8080/gif/android-explosion
  @RequestMapping(value="/gif/{name}")
  /**
   * This method display the details of a gif on a gif uri.
   * (In Spring Framework) To make the gif object available to the view, we add the object to
   * "model map"
   * @parem When the Spring framework calls our controller method as a result of a user
   * requesting the gif path, Spring will pass in an instance of a model map into this parameter.
   * In our method, we add the instance to the map, which is like a hashmap with strings as keys
   * @return method will render the gif-details template when the gif-details
   * controller method is called
   */
  public String gifDetails(@PathVariable String name, ModelMap modelMap) {
    // create a GIF object available to the view
    // create a new date by using the of method
    //Gif gif = new Gif("compiler-bot", LocalDate.of(2021,1,24), "Zach Htet", true);
    Gif gif = gifRepository.findByName(name);
    modelMap.put("gif", gif);
    return "gif-details";
  }
}
