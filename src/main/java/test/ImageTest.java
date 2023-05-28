package test;

import org.junit.Test;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class ImageTest {

    @Test
    public void test1() {
//        assertNotNull(new Object());

        try {
            BufferedImage image = ImageIO.read(new File("D:\\idea\\tankGame\\src\\images\\0.gif"));
            assertNotNull(image);

            BufferedImage image2 = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/0.gif"));
            assertNotNull(image2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
