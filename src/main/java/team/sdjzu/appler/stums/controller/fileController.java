package team.sdjzu.appler.stums.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * 文件上传与下载
 */
@RestController
@RequestMapping("/file/")
public class fileController {
    /**
     * 注入文件路径（从application.properties）
     */
    private static String filepath;
    @Value("${file.path}")
    public void setFilepath(String filepath){
        fileController.filepath = filepath;
    }

    /**
     * 文件上传
     * @param filename 文件名称（包含后缀名）
     */
    @GetMapping("download/{filename:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {
        Resource resource = loadFileResource(filename);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename);

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
    private Resource loadFileResource(String filename) {
        Path filePath = Paths.get(filepath + filename);
        return new PathResource(filePath);
    }

    /**
     * 上传文件
     * @param file 上传文件
     */

    @PostMapping("upload")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file){
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("请选择一个文件上传");
        }
        try {
            // 获取上传文件的原始名称
            String originalFileName = file.getOriginalFilename();

            // 在指定目录下创建一个新文件，用于保存上传的文件
            File targetFile = new File(filepath, Objects.requireNonNull(originalFileName));

            // 将文件保存到磁盘
            file.transferTo(targetFile);

            return ResponseEntity.status(HttpStatus.OK).body("文件上传成功: " + originalFileName);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("文件上传失败");
        }

    }
}
