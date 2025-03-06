import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;



public class DrawPanel extends JPanel{


    BufferedImage volvoWorkshopImage;
    BufferedImage volvo240Image;
    BufferedImage saab95Image;
    BufferedImage scaniaImage;


    Point volvoWorkshopPoint = new Point(300, 300);
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
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("/images/VolvoBrand.jpg"));
            volvo240Image = ImageIO.read(DrawPanel.class.getResourceAsStream("/images/Volvo240.jpg"));
            saab95Image = ImageIO.read(DrawPanel.class.getResourceAsStream("/images/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("/images/Scania.jpg"));

            //carPoints.add(new Point(0, 0));
            //carPoints.add(new Point(0, 0));


            //carImages.add(saab95Image);
            //carImages.add(scaniaImage);
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    public void addModelToPanel(Models_enum model) {
        switch (model) {
            case VOLVO240:
                carPoints.add(new Point(0, 0));
                carImages.add(volvo240Image);
                break;
            case SAAB95:
                carPoints.add(new Point(0, 0));
                carImages.add(saab95Image);
                break;
            case SCANIA:
                carPoints.add(new Point(0, 0));
                carImages.add(scaniaImage);
                break;
        }
    }

    public void removeModelFromPanel() {
        carPoints.remove(carPoints.size() - 1);
        carImages.remove(carImages.size() - 1);
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
