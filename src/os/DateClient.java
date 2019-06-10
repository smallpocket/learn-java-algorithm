package os;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Heper
 * @title
 * @date 2019/4/14 21:09
 */
public class DateClient {
    public static void main(String[] args) {
        try {
            //请求的IP地址为127.0.0.1，端口为6013
            Socket sock = new Socket("127.0.0.1", 6013);
            //向socket写入
            InputStream in = sock.getInputStream();
            //写入到缓冲区当中
            BufferedReader bin = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = bin.readLine()) != null) {
                System.out.println(line);
            }
            sock.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
