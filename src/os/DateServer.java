package os;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Heper
 * @title
 * @date 2019/4/14 21:09
 */
public class DateServer {
    public static void main(String[] args) {
        try {
            //监听端口6013
            ServerSocket socket = new ServerSocket(6013);
            //轮询监听
            while (true) {
                //阻塞在方法上，等待客户请求连接
                //获得Socket与客户端进行通信
                Socket client = socket.accept();
                //服务器通过PrintWriter向客户端进行写操作。
                PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
                pout.println(new java.util.Date().toString());
                //关闭socket，重新监听其他请求。
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
