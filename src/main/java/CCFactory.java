public class CCFactory {
    public void create() {
        CarController cc = new CarController();
        cc.frameHeight = cc.frame.drawPanel.getPreferredSize().height - 60;
        cc.frameWidth = cc.frame.drawPanel.getPreferredSize().width;

        cc.checker = new CarChecker(cc);
        cc.addCar(Models_enum.VOLVO240);
        cc.addCar(Models_enum.SCANIA);
        cc.addCar(Models_enum.SAAB95);
        System.out.println(cc.cars);

        cc.timer.start();

    }
}
