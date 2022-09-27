package Examples;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class JavaIODemo {

    public static void main(String[] args) throws IOException {

//        System.getProperties().list(System.out);
//        SendThread sendThread = new SendThread();
//        ReceiveThread receiveThread = new ReceiveThread();
//        sendThread.getOutputStream().connect(receiveThread.getInputStream());
//        new Thread(sendThread, "消息发送线程").start();
//        new Thread(receiveThread, "消息接收线程").start();

//        keyboardIn();

//        keyboardIn2();

        scanEnter();
    }

    private static void scanEnter() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入您的生日：");
        if (scanner.hasNext("\\d{4}-\\d{2}-\\d{2}")) {
            try {
                System.out.println("输入信息为：" + new SimpleDateFormat("yyyy-MM-dd").parse(scanner.next("\\d{4}-\\d{2}-\\d{2}")));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        scanner.close();
    }

    private static void keyboardIn() throws IOException {
        InputStream in = System.in;
        System.out.print("请输入信息：");
        byte[] bytes = new byte[1024];
        int len = in.read(bytes);
        System.out.println("输入内容为：" + new String(bytes, 0, len));
    }

    private static void keyboardIn2() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("请输入您的年龄：");
        String line = input.readLine();
        if (line.matches("\\d{1,3}")) {
            System.out.println("年龄为：" + Integer.parseInt(line));
        } else {
            System.out.println("输入类型不符");
        }
    }

    private void output() {

        File file = new File("D:"
                + File.separator + "program"
                + File.separator + "资料"
                + File.separator + "短信通知"
                + File.separator + "首页_slices"
                + File.separator + "mipmap-hdpi"
                + File.separator + "outputStream.txt");

        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        try {
            OutputStream outputStream = new FileOutputStream(file);
            outputStream.write("www.mldn.cn".getBytes(StandardCharsets.UTF_8));
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void input() {

        File file = new File("D:"
                + File.separator + "program"
                + File.separator + "资料"
                + File.separator + "短信通知"
                + File.separator + "首页_slices"
                + File.separator + "mipmap-hdpi"
                + File.separator + "outputStream.txt");

        try {
            InputStream inputStream = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            while (inputStream.read(bytes) != -1) {
                System.out.println(new String(bytes));
            }
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class SendThread implements Runnable {

    private PipedOutputStream outputStream;//管道的输出流

    public SendThread() {

        this.outputStream = new PipedOutputStream();//实例化管道输出流
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            try {
                this.outputStream.write(("【第" + i + "次信息发送】- " + Thread.currentThread().getName() + "】Juice\n").getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            this.outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public PipedOutputStream getOutputStream() {
        return outputStream;
    }
}

class ReceiveThread implements Runnable {

    private PipedInputStream inputStream;

    public ReceiveThread() {
        this.inputStream = new PipedInputStream();
    }

    @Override
    public void run() {

        byte[] bytes = new byte[1024];
        int len = 0;

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            while ((len = this.inputStream.read(bytes)) != -1) {
                bos.write(bytes, 0, len);//所有的数据保存到内存流
                System.out.println("{" + Thread.currentThread().getName() + "接收消息｝" + bos);
                bos.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public PipedInputStream getInputStream() {
        return inputStream;
    }
}