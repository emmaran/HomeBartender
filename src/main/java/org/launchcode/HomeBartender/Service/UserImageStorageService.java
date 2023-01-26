package org.launchcode.HomeBartender.Service;

import org.launchcode.HomeBartender.data.UserImageRepository;
import org.launchcode.HomeBartender.models.UserImageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserImageStorageService {

    @Autowired
    private UserImageRepository repository;

    public String uploadImage(UserImageData file) {

        repository.save(file);

        return null;
    }

    public byte[] downloadImage(String fileName) {
        System.out.println(fileName);
        Optional<UserImageData> dbImageData = repository.findByName(fileName);

//        System.out.println(dbImageData.get().getName());
//        System.out.println(Arrays.toString(dbImageData.get().getImageData()));
//
//        byte[] images = UserImageUtils.decompressImage(dbImageData.get().getImageData());

        byte[] images = dbImageData.get().getImageData();

//        System.out.println(Arrays.toString(images));

        return images;
    }

}
