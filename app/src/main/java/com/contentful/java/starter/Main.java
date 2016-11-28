package com.contentful.java.starter;

import com.contentful.java.cda.CDAArray;
import com.contentful.java.cda.CDAClient;
import com.contentful.java.cda.CDAEntry;
import com.github.mjeanroy.springmvc.view.mustache.core.ModelAndMustacheView;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;


@Controller
@EnableAutoConfiguration
public class Main {

  private static final String SPACE_ID = "wl1z0pal05vy";
  private static final String ACCESS_TOKEN = "0e3ec801b5af550c8a1257e8623b1c77ac9b3d8fcfc1b2b7494e3cb77878f92a";

  private static final String CONTENT_TYPE_PRODUCT = "2PqfXUJwE8qSYKuM0U6w8M";
  private static final String CONTENT_TYPE_BRAND = "sFzTZbSuM8coEwygeUYes";
  private static final String CONTENT_TYPE_CATEGORY = "6XwpTaSiiI2Ak2Ww0oi6qa";

  private static CDAClient client;

  @RequestMapping("/")
  @SuppressWarnings("unused")
  public ModelAndView root() {
    return products();
  }

  @RequestMapping("/products")
  @SuppressWarnings("unused")
  public ModelAndView products() {
    CDAArray array = client
        .fetch(CDAEntry.class)
        .where("content_type", CONTENT_TYPE_PRODUCT)
        .all();

    ModelAndMustacheView view = new ModelAndMustacheView("products");
    view.addObject("products", array);
    return view;
  }

  @RequestMapping(value = "/products/{id}")
  @SuppressWarnings("unused")
  public ModelAndView product(@PathVariable("id") String id) {
    CDAEntry entry = client
        .fetch(CDAEntry.class)
        .where("content_type", CONTENT_TYPE_PRODUCT)
        .one(id);

    ModelAndMustacheView view = new ModelAndMustacheView("product_single");
    view.addObject("product", Collections.singleton(entry));
    return view;
  }

  @RequestMapping("/brands")
  @SuppressWarnings("unused")
  public ModelAndView brands() {
    CDAArray array = client
        .fetch(CDAEntry.class)
        .where("content_type", CONTENT_TYPE_BRAND)
        .all();

    ModelAndMustacheView view = new ModelAndMustacheView("brands");
    view.addObject("brands", array);
    return view;
  }

  @RequestMapping("/brands/{id}")
  @SuppressWarnings("unused")
  public ModelAndView brand(@PathVariable String id) {
    CDAEntry entry = client
        .fetch(CDAEntry.class)
        .where("content_type", CONTENT_TYPE_BRAND)
        .one(id);

    ModelAndMustacheView view = new ModelAndMustacheView("brand_single");
    view.addObject("brand", Collections.singleton(entry));
    return view;
  }

  @RequestMapping("/categories")
  @SuppressWarnings("unused")
  public ModelAndView categories() {
    CDAArray categories = client
        .fetch(CDAEntry.class)
        .where("content_type", CONTENT_TYPE_CATEGORY)
        .all();

    CDAArray products = client
        .fetch(CDAEntry.class)
        .where("content_type", CONTENT_TYPE_PRODUCT)
        .all();

    ModelAndMustacheView view = new ModelAndMustacheView("categories");
    view.addObject("categories", categories);
    view.addObject("products", products);
    return view;
  }

  @RequestMapping("/categories/{id}")
  @SuppressWarnings("unused")
  public ModelAndView category(@PathVariable String id) {
    CDAArray categories = client
        .fetch(CDAEntry.class)
        .where("content_type", CONTENT_TYPE_CATEGORY)
        .all();

    CDAArray products = client
        .fetch(CDAEntry.class)
        .where("content_type", CONTENT_TYPE_PRODUCT)
        .where("fields.categories.sys.id[in]", id)
        .all();

    ModelAndMustacheView view = new ModelAndMustacheView("categories");
    view.addObject("categories", categories);
    view.addObject("products", products);
    return view;
  }

  public static void main(String[] args) throws Exception {
    client = CDAClient.builder()
        .setSpace(SPACE_ID)
        .setToken(ACCESS_TOKEN)
        .build();

    SpringApplication app = new SpringApplication(Main.class);
    Banner banner = (environment, sourceClass, out) -> {
      out.println("  ______   ____            _             _    __       _   ____             _              ______  ");
      out.println(" / / / /  / ___|___  _ __ | |_ ___ _ __ | |_ / _|_   _| | / ___| _ __  _ __(_)_ __   __ _  \\ \\ \\ \\ ");
      out.println("/ / / /  | |   / _ \\| '_ \\| __/ _ \\ '_ \\| __| |_| | | | | \\___ \\| '_ \\| '__| | '_ \\ / _` |  \\ \\ \\ \\");
      out.println("\\ \\ \\ \\  | |__| (_) | | | | ||  __/ | | | |_|  _| |_| | |_ ___) | |_) | |  | | | | | (_| |  / / / /");
      out.println(" \\_\\_\\_\\  \\____\\___/|_| |_|\\__\\___|_| |_|\\__|_|  \\__,_|_(_)____/| .__/|_|  |_|_| |_|\\__, | /_/_/_/ ");
      out.println("                                                                |_|                 |___/          ");
      out.println();
    };

    app.setBanner(banner);
    app.run(args);
  }
}
