import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;



public class DrawPanel extends JPanel{


    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(300,300);
    List<Point> carPoints = new ArrayList<>();
    List<BufferedImage> carImages = new ArrayList<>();



    // TODO: Make this general for all cars
    void moveit(int x, int y, int index){
        Point point = new Point(x, y);
        carPoints.set(index, point);
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {

            carPoints.add(new Point(0, 0));
            carPoints.add(new Point(0, 0));
            carPoints.add(new Point(0, 0));

            carImages.add(ImageIO.read(DrawPanel.class.getResourceAsStream("/images/Volvo240.jpg")));
            carImages.add(ImageIO.read(DrawPanel.class.getResourceAsStream("/images/Saab95.jpg")));
            carImages.add(ImageIO.read(DrawPanel.class.getResourceAsStream("/images/Scania.jpg")));
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("/images/VolvoBrand.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < carImages.size(); i++) {
            g.drawImage(carImages.get(i), carPoints.get(i).x, carPoints.get(i).y, null); // see javadoc for more info on the parameters
        }
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
    }
}
