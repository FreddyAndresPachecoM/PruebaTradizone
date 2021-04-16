package com.ista.tradizone.di.app.service.cloudinary;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CloudinaryService {
    
    private Cloudinary cloudinary;
    private Map<String, String> cloudinaryDataConfig = new HashMap<>();

    public CloudinaryService(){
        cloudinaryDataConfig.put("cloud_name", "dvtvnjgle");
        cloudinaryDataConfig.put("api_key", "995159349112295");
        cloudinaryDataConfig.put("api_secret", "p9xq4APlEQ_vXRgV1JuisnuG2eg");
        cloudinary = new Cloudinary(cloudinaryDataConfig);
    }

    public Map<?,?> subirImagen(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream fileWriter = new FileOutputStream(file);
        fileWriter.write(multipartFile.getBytes());
        fileWriter.close();
        Map<?,?> imagenData = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        file.delete();
        return imagenData;
    }


    public Map<?,?> eliminarImagen(String id)throws IOException {
        Map<?,?> imagenData = cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
        return imagenData;
    }
}
