package canglangpoxiao.smart_store_back;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class ByteArrayToFile {
    public static void main(String[] args) throws IOException {
        // 读取图像
        BufferedImage bImage = ImageIO.read(new File("src/main/resources/QQX.jpg"));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        // 将图像写入字节数组输出流
        ImageIO.write(bImage, "jpg", bos);

        byte[] bytes = bos.toByteArray();
        // 这里的bytes就是你需要的字节数组

        // 指定要创建的文件的路径和名称  
        File file = new File("src/main/java/canglangpoxiao/smart_store_back/trans.jpg");

        try (FileOutputStream fos = new FileOutputStream(file)) {
            // 将 byte 数组写入文件  
            fos.write(bytes);
            // 刷新输出流并关闭它（在 try-with-resources 语句中自动完成）  
        } catch (IOException e) {
            e.printStackTrace();
            // 处理文件写入过程中可能发生的异常  
        }

        // 此时，文件已经创建并包含了 byte 数组中的数据  
        System.out.println("File created successfully: " + file.getAbsolutePath());
    }
}