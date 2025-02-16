package com.heitor.ocb

import grails.util.Holders
import org.springframework.web.multipart.MultipartFile

class FileUtil {
    public static String getRootPath(){
        return Holders.servletContext?.getRealPath("")
    }

    public static File makeDirectory(String path){
        File file = new File(path)
        if (!file.exists()){
            file.mkdirs()
        }
        return file
    }

//    request.getFile("productFile")
    public static String uploadContactImage(Integer contactId, MultipartFile multipartFile){
        if (contactId && multipartFile){
            String contactImagePath = "${getRootPath()}contact-image/"
            makeDirectory(contactImagePath)
            multipartFile.transferTo(new File(contactImagePath, contactId + "-" + multipartFile.originalFilename))
            return multipartFile.originalFilename
        }
        return ""
    }

    public static Boolean deleteContactImage(String filename, Integer contactID){
        try{
            String contactImagePath = "${getRootPath()}contact-image/"
            String contactImageFile = contactImagePath + contactID + "-" + filename
            File file = new File(contactImageFile)
            if(file.delete()){
                return true
            }else{
                return false
            }
        }
            catch (Exception e)
            {
                return false;
            }
    }
}

