package utils;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;

public class ScreenCapture {
    private BufferedImage capturedImage;
    private String fileName;
    private String format;
    private byte[] imageData;

    // Constructor to capture the screen
    public ScreenCapture() {
        try {
            Robot robot = new Robot();
            format = "png";

            // Capture the screen size
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            capturedImage = robot.createScreenCapture(screenRect);

            // Draw mouse cursor on the screenshot
            Point mouseLocation = MouseInfo.getPointerInfo().getLocation();
            int mouseX = mouseLocation.x - screenRect.x;
            int mouseY = mouseLocation.y - screenRect.y;
            Graphics2D g2d = capturedImage.createGraphics();
            g2d.setColor(Color.RED);
            g2d.fillOval(mouseX, mouseY, 15, 15); // Draw a red circle for the cursor
            g2d.dispose();

            // Generate the file name based on current timestamp
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
            fileName = "screenshot_" + dateFormat.format(new Date()) + "." + format;

            // Convert the image to byte array
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(capturedImage, format, baos);
            imageData = baos.toByteArray();
        } catch (AWTException | IOException e) {
            System.err.println("Error capturing the screen: " + e.getMessage());
        }
    }

    // Save the image to the "images" folder
    public void saveImage() {
        File folder = new File("images");
        if (!folder.exists() && !folder.mkdir()) {
            System.err.println("Failed to create the images folder.");
            return;
        }

        try {
            File file = new File(folder, fileName);
            ImageIO.write(capturedImage, format, file);
            System.out.println("Screenshot saved: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error saving the image: " + e.getMessage());
        }
    }

    // Getter for the image data
    public byte[] getImageData() {
        return imageData;
    }

    // Main method for testing
    public static void main(String[] args) {
        ScreenCapture screenCapture = new ScreenCapture();
        screenCapture.saveImage();
    }
}
