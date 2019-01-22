/**
 * Date: 2019/1/19
 * Created by Liuian
 */

class DecorationModel {

}


abstract class AbsComponent {
    abstract int cost();

    abstract void description();

}


class Coffee extends AbsComponent {

    @Override
    int cost() {
        return 10;
    }

    @Override
    void description() {
        System.out.print("this is coffee");
    }
}


abstract class DecorateCoffee extends AbsComponent {

    AbsComponent component;

    DecorateCoffee(AbsComponent component) {
        this.component = component;
    }

    @Override
    int cost() {
        return 0;
    }

    @Override
    void description() {
        System.out.print("this is coffee with " + component.toString());
    }

}


class Cabuccino extends DecorateCoffee {

    AbsComponent component;

    Cabuccino(AbsComponent component) {
        super(component);
    }


    @Override
    int cost() {
        return component.cost() + 10;
    }

    @Override
    void description() {
        super.description();
        System.out.print(component.toString());
    }
}