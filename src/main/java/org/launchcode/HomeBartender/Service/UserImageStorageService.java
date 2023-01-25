package org.launchcode.HomeBartender.Service;

import org.launchcode.HomeBartender.data.UserImageRepository;
import org.launchcode.HomeBartender.models.UserImageData;
import org.launchcode.HomeBartender.util.UserImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@Service
public class UserImageStorageService {

    @Autowired
    private UserImageRepository repository;

    public String uploadImage(UserImageData file) throws IOException {
//
//        UserImageData imageData = new UserImageData(file.getOriginalFilename(), file.getContentType(), UserImageUtils.compressImage(file.getBytes()));

        repository.save(file);

//        if(file!=null) {
//            return "file uploaded successfully: " + file.getOriginalFilename();
//        }
        return null;
    }

    public byte[] downloadImage(String fileName) {
        System.out.println(fileName);
        Optional<UserImageData> dbImageData = repository.findById(211);

//        System.out.println(dbImageData.get().getName());
//        System.out.println(Arrays.toString(dbImageData.get().getImageData()));
//
//        byte[] images = UserImageUtils.decompressImage(dbImageData.get().getImageData());

        byte[] images = dbImageData.get().getImageData();

//        System.out.println(Arrays.toString(images));

        return images;
    }

}
