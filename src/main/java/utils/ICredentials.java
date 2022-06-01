package utils;

public interface ICredentials {
    default String getFileName(String filename){
        return filename;
    }

    String getJson();
}
