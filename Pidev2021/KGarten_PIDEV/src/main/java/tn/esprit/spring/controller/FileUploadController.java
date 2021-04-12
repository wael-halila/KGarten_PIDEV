package tn.esprit.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import tn.esprit.spring.entity.Bean;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;

@CrossOrigin("*")
@RequestMapping("/upload")
@RestController
@Controller
public class FileUploadController {
    // TODO: server url
    String url = "http://0.0.0.0/dari.tn/upload/upload";


    @RequestMapping(value="/upload", method= RequestMethod.POST)
    @ResponseBody
    public Bean handleFileUpload(HttpServletRequest request){
        String uid = request.getHeader("uid");
        List<MultipartFile> files = ((MultipartHttpServletRequest)request).getFiles("file");
        MultipartFile file = null;
        Bean bean = new Bean();
        BufferedOutputStream stream = null;
        for (int i =0; i< files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(
                            new File(uid + file.getOriginalFilename())));
                    stream.write(bytes);
                    stream.close();
                    bean.setResult(url + file.getOriginalFilename());
                } catch (Exception e) {
                    stream =  null;
                    bean.setStatus(500);
                    bean.setMessage("failed " + i + " => " + e.getMessage());
                    return bean;
                }
            } else {
                bean.setStatus(500);
                bean.setMessage("file is empty");
                return bean;
            }
        }

        bean.setStatus(200);
        bean.setMessage("success");
        return bean;
    }


}
