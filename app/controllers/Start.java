package controllers;

import play.Logger;
import play.mvc.Controller;

public class Start extends Controller {

  //method to render the start view
  public static void index() {
    Logger.info("Rendering Start");
    render("start.html");
  }
}
