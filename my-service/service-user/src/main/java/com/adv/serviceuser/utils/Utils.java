package com.adv.serviceuser.utils;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.PicturesManager;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.usermodel.Picture;
import org.apache.poi.hwpf.usermodel.PictureType;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.List;

/**
 * @ClassName:Utils
 * @Description:TODO
 * @Author:nano
 * @Date:20-2-23 上午10:49
 * @Version:1.0
 */
public class Utils {

    public static void WordToHtml(String path,String file){
       // final String path = "D:\\poi-test\\wordToHtml\\";
       // final String file = "人员选择系分.doc";
        InputStream input = null;
        try {
            input = new FileInputStream(path + file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        HWPFDocument wordDocument = null;
        try {
            wordDocument = new HWPFDocument(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        WordToHtmlConverter wordToHtmlConverter = null;
        try {
            wordToHtmlConverter = new WordToHtmlConverter(
                    DocumentBuilderFactory.newInstance().newDocumentBuilder()
                            .newDocument());
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        wordToHtmlConverter.setPicturesManager(new PicturesManager() {
            public String savePicture(byte[] content, PictureType pictureType,
                                      String suggestedName, float widthInches, float heightInches) {
                return suggestedName;
            }
        });
        wordToHtmlConverter.processDocument(wordDocument);
        List pics = wordDocument.getPicturesTable().getAllPictures();
        if (pics != null) {
            for (int i = 0; i < pics.size(); i++) {
                Picture pic = (Picture) pics.get(i);
                try {
                    try {
                        pic.writeImageContent(new FileOutputStream(path
                                + pic.suggestFullFileName()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        Document htmlDocument = wordToHtmlConverter.getDocument();
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        DOMSource domSource = new DOMSource(htmlDocument);
        StreamResult streamResult = new StreamResult(outStream);
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer serializer = null;
        try {
            serializer = tf.newTransformer();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        serializer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
        serializer.setOutputProperty(OutputKeys.INDENT, "yes");
        serializer.setOutputProperty(OutputKeys.METHOD, "html");
        try {
            serializer.transform(domSource, streamResult);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        try {
            outStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String content = new String(outStream.toByteArray());
        try {
            FileUtils.writeStringToFile(new File(path, "校园贷的特征有哪些-01.html"), content, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args){
      Utils.WordToHtml("/home/nano/Desktop/temp001/","校园贷的特征有哪些.docx");
    }

}
