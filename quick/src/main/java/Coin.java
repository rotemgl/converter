public abstract class Coin implements ICalculate {
    public abstract double getValue();
}
class ILS extends Coin{
    final double value=0.28;
    @Override
    public double getValue()
    {
        return value;
    }

    @Override
    public double Calculate(double input) {
        return input*getValue();
    }
}

class USD extends Coin{
    final double value=3.52;

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public double Calculate(double input) {
        return input*getValue();
    }
}