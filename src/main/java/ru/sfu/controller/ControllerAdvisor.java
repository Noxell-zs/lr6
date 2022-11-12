package ru.sfu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.NoHandlerFoundException;


/** Exception class for 404 error */
@Controller
@ControllerAdvice
public class ControllerAdvisor extends RuntimeException {
  /** Routing the error-page */
  @RequestMapping("/error")
  public String error(ModelMap model) {
    return "error";
  }

  /** Redirect to error-page */
  @ExceptionHandler(NoHandlerFoundException.class)
  public String handle(Exception ex) {
    return "redirect:/error";
  }
}
