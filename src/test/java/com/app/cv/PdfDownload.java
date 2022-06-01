package com.app.cv;

import org.testng.annotations.Test;

import java.io.IOException;

public class PdfDownload extends BaseTest{
    @Test
    public void pdfDownloadTest() throws InterruptedException, IOException {
        startDownload();
        copyYouTubeLink();
       }
}
