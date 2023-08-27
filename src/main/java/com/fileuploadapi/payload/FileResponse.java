package com.fileuploadapi.payload;

public class FileResponse {

    private String file;
    private String message;

    public FileResponse() {
    }

    public FileResponse(String file, String message) {
        this.file = file;
        this.message = message;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
