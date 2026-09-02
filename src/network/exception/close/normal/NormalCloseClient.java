package network.exception.close.normal;

import java.io.*;
import java.net.Socket;

import static util.MyLogger.log;

public class NormalCloseClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);
        log("소캣 연결: " + socket);

        InputStream input = socket.getInputStream();

        readByInputStream(input, socket);
        readByBufferdReader(input, socket);
        readByDataInputStream(input, socket);


    }

    // InputStream 이미지, 파일, 네트워크 원본 데이터 read() -> -1
    private static void readByInputStream(InputStream input, Socket socket) throws IOException {
        int read = input.read();
        log("read = " + read);
        if (read != -1) { // read = -1 -> 상대방이 FIN 패킷을 보냄
            input.close();
            socket.close();
        }
    }

    // BufferedReader 텍스트, 줄 단위 메세지 readLine() -> null
    private static void readByBufferdReader(InputStream input, Socket socket) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(input));
        String readString = br.readLine();
        log("readString: " + readString);
        if (readString != null) {
            br.close();
            socket.close();
        }
    }

    // DataInputStream 숫자, boolean, UTF문자열 등 형식 도중 종료 -> EOFException
    private static void readByDataInputStream(InputStream input, Socket socket) throws IOException {
        DataInputStream dis = new DataInputStream(input);

        try {
            dis.readUTF();
        } catch (EOFException e) {
            log(e);
        } finally {
            dis.close();
            socket.close();
        }
    }

}
