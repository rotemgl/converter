public class CoinFactory {
    public static Coin getCoinInstance(Coins coin){
        switch (coin){
            case ILS:
                System.out.println("ILS->USD");
                return new ILS();
            case USD:
                System.out.println("USD->ILS");
                return new USD();
            }
        return null;
    }
}
