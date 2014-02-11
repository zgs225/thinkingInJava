import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author <a href="http://yuez.me">yuez</a> created at 14-2-3
 */
public class TestImageIO {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Thumbnail width and height
        int w = 100;
        int h = 100;

        // Load image
        Image image = Toolkit.getDefaultToolkit()
                .getImage("/Users/yuez/Documents/blog/140125/0123_java-800x480.jpg");
        MediaTracker mediaTracker = new MediaTracker(new Container());
        mediaTracker.addImage(image, 0);
        mediaTracker.waitForID(0);

        // Determine thumbnail width and height
        double thumbRatio = w / h;
        double imageRatio = image.getWidth(null) / image.getHeight(null);
        if (thumbRatio < imageRatio)
            h = (int) (w / imageRatio);
        else
            w = (int) (h * imageRatio);

        // Generate a thumbnail
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(image, 0, 0, w, h, null);

        // Save to file
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("/tmp/thumb.jpg"));
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(bi);
        param.setQuality(0.5f, false);
        encoder.setJPEGEncodeParam(param);
        encoder.encode(bi);
        out.close();
    }
}
