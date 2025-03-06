public class CCFactory {
    public void create() {
        CarController cc = new CarController();

        cc.frame = new CarView("CarSim 1.0", cc);
        cc.frameHeight = cc.frame.drawPanel.getPreferredSize().height - 60;
        cc.frameWidth = cc.frame.drawPanel.getPreferredSize().width;

        cc.checker = new CarChecker(cc);
        System.out.println("--before adding of cars--");
        cc.addCar(Models_enum.VOLVO240);
        System.out.println("adding volvo in factory");
        cc.addCar(Models_enum.SCANIA);
        System.out.println("adding scania in factory");
        cc.addCar(Models_enum.SAAB95);
        System.out.println("adding saab in factory");
        System.out.println("current carlist");
        System.out.println(cc.cars);

        cc.timer.start();

    }
}
