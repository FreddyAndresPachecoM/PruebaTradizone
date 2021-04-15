package com.ista.tradizone.di.app.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ista.tradizone.di.app.models.Imagen;
import com.ista.tradizone.di.app.repositories.ImagenRepository;
import com.ista.tradizone.di.app.utils.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImagenService {

    private Cloudinary cloudinary;
    private Map<String, String> cloudinaryDataConfig = new HashMap<>();

    @Autowired
    private ImagenRepository imagenRepository;

    public ImagenService(){
        cloudinaryDataConfig.put("cloud_name", "dvtvnjgle");
        cloudinaryDataConfig.put("api_key", "995159349112295");
        cloudinaryDataConfig.put("api_secret", "p9xq4APlEQ_vXRgV1JuisnuG2eg");
        cloudinary = new Cloudinary(cloudinaryDataConfig);
    }


    public Response<Imagen> guardarImagen(MultipartFile archivo){
        try {
            if(ImageIO.read(archivo.getInputStream()) == null){
                return new Response<>(400, "Error", null);
            }
            File file = new File(archivo.getOriginalFilename());
            FileOutputStream fileWriter = new FileOutputStream(file);
            fileWriter.write(archivo.getBytes());
            fileWriter.close();
            Map<?, ?> imgData = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
            file.delete();
            Imagen imagen = new Imagen();
            imagen.setNombre((String)imgData.get("original_filename"));
            imagen.setUrl((String)imgData.get("url"));
            imagen.setCloudinaryId((String)imgData.get("public_id"));
            imagenRepository.insert(imagen);
            return new Response<>(201, "Recurso Creado con exito", null);
        } catch (IOException e) {
            return new Response<>(400, "Imagen no valida!", null);
        }
    }
    
    public Response<Imagen> getImagenes(){
        return new Response<>(200, "Ok", imagenRepository.findAll());
    }

}
