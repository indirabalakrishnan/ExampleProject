package com.app.aws.s3;


import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class S3Download {
    public static void main(String[] args) throws IOException {
        String bucket = "indiras3";
        String key = "Indira_QAM_Resume.pdf";
        String region = " ap-south-1";
        String s3_uri = "s3://indiras3/Indira_QAM_Resume.pdf";
        String arn = "arn:aws:s3:::indiras3/Indira_QAM_Resume.pdf";
        String obj_url = "https://indiras3.s3.ap-south-1.amazonaws.com/Indira_QAM_Resume.pdf";

        S3Client s3Client = S3Client.builder().build();
        GetObjectRequest request = GetObjectRequest.builder().bucket(bucket).key(key).build();
        ResponseInputStream<GetObjectResponse> response = s3Client.getObject(request);
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(key));

        byte[] buffer = new byte[4096];
        int bytesRead = -1;

        while ((bytesRead = response.read(buffer)) !=  -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        response.close();
        outputStream.close();
    }
}
