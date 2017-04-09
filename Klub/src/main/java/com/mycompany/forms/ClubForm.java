package com.mycompany.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

public class ClubForm {

    @NotNull
    @Size(min = 3, max = 50)
    private String name;

    @NotNull
    private MultipartFile logo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getLogo() {
        return logo;
    }

    public void setLogo(MultipartFile logo) {
        this.logo = logo;
    }

}
