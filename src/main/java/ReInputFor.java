import java.util.function.Supplier;

public class ReInputFor {
    OutputView outputView = OutputView.of();

    // 재입력 받는 포멧
    private <T> T retry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get(); // return 정상적으로 종료시 while문 종료
            } catch (IllegalArgumentException e) { // 예외 발생 시 while문 계속 반복
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

//    private PurchaseAmount readPurchaseAmount() {
//        return retry(() -> {
//            String input = inputView.readPurchaseAmount();
//            int amount = InputParser.parseInt(input);
//            return new PurchaseAmount(amount);
//        });
//    }

//    private WinningNumbers readWinningNumbers() {
//        return retry(() -> {
//            String input = inputView.readWinningNumbers();
//            List<Integer> numbers = InputParser.parseNumbers(input);
//            return new WinningNumbers(numbers);
//        });
//    }

    public static class OutputView {
        public static OutputView of(){
            return new OutputView();
        }

        public static void printErrorMessage(String message) {

        }
    }
}
