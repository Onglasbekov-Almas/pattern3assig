interface Pizza {
    String getDescription();
    double getCost();
}

// MargheritaPizza class
class MargheritaPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Margherita Pizza";
    }

    @Override
    public double getCost() {
        return 6.99;
    }
}

abstract class ToppingDecorator implements Pizza {
    protected Pizza pizza;

    public ToppingDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }

    @Override
    public double getCost() {
        return pizza.getCost();
    }
}

// CheeseTopping class
class CheeseTopping extends ToppingDecorator {
    public CheeseTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Cheese";
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.50;
    }
}

// PizzaShop class
class PizzaShop {
    public static void main(String[] args) {
        Pizza pizza = new MargheritaPizza();
        System.out.println(pizza.getDescription() + " - $" + pizza.getCost());

        pizza = new CheeseTopping(pizza);
        System.out.println(pizza.getDescription() + " - $" + pizza.getCost());
    }
}
