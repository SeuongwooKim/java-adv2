package io.file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class OldFileMain {

    public static void main(String[] args) throws IOException {
        File file = new File("temp/example.txt");
        File directory = new File("temp/exampleDir");

        // exists() : 파일 or디렉토리 존재 여부 확인
        System.out.println("File exists : " + file.exists());

        // createNewFile() : 새 파일 생성
        boolean created = file.createNewFile();
        System.out.println("File created:" + created);

        // mkdir(): 새 디렉토리 생성
        boolean dirCreated = directory.mkdir();
        System.out.println("Directory created:" + dirCreated);

        // delete(): 파일이나 디렉토리 삭제
//        boolean fileDeleted = file.delete();
//        System.out.println("File deleted:" + fileDeleted);

        // isFile(): 파일인지 확인
        System.out.println("Is file: " + file.isFile());

        // isDirectory(): 디렉토리인지 확인
        System.out.println("Is directory: " + directory.isDirectory());

        // getName(): 파일이나 디렉토리 이름을 반환
        System.out.println("File Name: " + file.getName());

        // length(): 파일의 크기를 바이트로 반환
        System.out.println("File Size: " + file.length() + " bytes");

        // renameTo(File dest): 파일의 이름을 변경하거나 이동
        File newFile = new File("temp/newExample.txt");
        boolean renamed = file.renameTo(new File("temp/newExample.txt"));
        System.out.println("File renamed:" + renamed);

        // lastModified(): 마지막으로 수정된 시간
        long lastModified = newFile.lastModified();
        System.out.println("Last modified:" + new Date(lastModified));

    }

}
