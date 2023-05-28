import org.junit.Assert;
import org.junit.Test;
import tank.ResourceMgr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * Author 杨冬冬
 * Date 2023/5/28 17:25
 * Desc
 */
public class ImageIOTest {

    public static void main(String[] args) {
        try {
            File file = new File("src/test/java/images/BadTank1.png");
            BufferedImage read = ImageIO.read(file);
            assertNotNull(read);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        InputStream resourceAsStream = ImageIOTest.class.getClassLoader().getResourceAsStream("images/BadTank1.png");
        assertNotNull(resourceAsStream);
//        ImageIO.read()
    }
}
