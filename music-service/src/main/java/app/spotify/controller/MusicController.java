package app.spotify.controller;

import app.spotify.dto.Dto;
import app.spotify.dto.MusicDto;
import app.spotify.service.MusicService;
import app.spotify.service.impl.MusicUploadToFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/v1/music")
public class MusicController {

    private MusicService musicService;
    private MusicUploadToFileService musicUploadToFileService;

    @Autowired
    private SpringTemplateEngine templateEngine;

    @Autowired
    private ThymeleafProperties thymeleafProperties;

    public MusicController(MusicService musicService, MusicUploadToFileService musicUploadToFileService, SpringTemplateEngine templateEngine, ThymeleafProperties thymeleafProperties, ResourceLoader resourceLoader) {
        this.musicService = musicService;
        this.musicUploadToFileService = musicUploadToFileService;
        this.templateEngine = templateEngine;
        this.thymeleafProperties = thymeleafProperties;
        this.resourceLoader = resourceLoader;
    }

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    public MusicController(MusicUploadToFileService musicUploadToFileService, MusicService musicService, ResourceLoader resourceLoader, SpringTemplateEngine templateEngine) {
        this.musicUploadToFileService = musicUploadToFileService;
        this.musicService = musicService;
        this.templateEngine = templateEngine;
    }

    @PostMapping(value = "/create", consumes = {"multipart/form-data"})
    public ResponseEntity<MusicDto> createMusic(@RequestParam MusicDto musicDto, @RequestParam MultipartFile music, @RequestParam MultipartFile text, MultipartRequest multipartRequest) {
        musicService.save(musicDto);
        musicUploadToFileService.uploadMusic(music, text);
        System.out.println("youuu");
        return ResponseEntity.ok(musicDto);
    }


    @PostMapping(value = "/createe", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Dto> createMusiсCheck(@RequestParam Dto dto, @RequestPart(value = "music") MultipartFile music, @RequestPart(value = "text") MultipartFile text) {
        //musicService.save(musicDto);
        System.out.println("youuu");
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<MusicDto>> findall() {
        System.out.println("You are in find all method");
        SpringResourceTemplateResolver resolver = (SpringResourceTemplateResolver) templateEngine.getTemplateResolvers().iterator().next();

        String templatePrefix = resolver.getPrefix();
        String templateSuffix = resolver.getSuffix();

        System.out.println("Путь к папке с шаблонами: " + templatePrefix);
        String pathWithoutClasspath = templatePrefix.replace("classpath:", "");
        Resource resource = resourceLoader.getResource("classpath:/templates/");

        try {
            // Получаем путь к ресурсам и выводим файлы
            Files.list(Paths.get(resource.getURI()))
                    .filter(Files::isRegularFile)
                    .forEach(file -> System.out.println("Файл: " + file.getFileName()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(musicService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showCreateMusicForm() {
        var model = new ModelAndView();
        model.setViewName("create.html");
        return model;
    }

    @GetMapping("/greeting")
    public String greeting(Model model) {
        System.out.println("dkfjgndsnfg");
        model.addAttribute("message", "Welcome to our website!");
        return "index";
    }

    @PostMapping(value = "/saveMusic")
    public ResponseEntity<MusicDto> createMusicToDb(@RequestParam MusicDto musicDto) {
        musicService.save(musicDto);
        System.out.println("youuu");
        return ResponseEntity.ok(musicDto);
    }
}
