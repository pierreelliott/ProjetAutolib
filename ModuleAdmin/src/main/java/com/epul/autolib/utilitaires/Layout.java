package com.epul.autolib.utilitaires;

import org.springframework.web.servlet.ModelAndView;

public class Layout extends ModelAndView {
    public Layout(String view) {
        this.setViewName(view);
//        if(view == null) {
//            this.setViewName("redirect:404");
//        } else if(!view.isEmpty() && view.startsWith("redirect:")) {
//            this.setViewName(view);
//        } else {
//            this.addObject("page", view);
//            this.setViewName("layout");
//        }
    }

    public Layout(String view, String title) {
        this(view);
        this.addObject("title", title);
    }
}
