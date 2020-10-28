
public class RecursiveDescentParserOriginal {

    private final String[] tokens;
    private int pos = 0; // индекс текущего токена

    public RecursiveDescentParserOriginal(String[] tokens) {
        this.tokens = tokens;
    }

    public Double parse() {
        Double result = expression();
        if (pos != tokens.length) {
            throw new IllegalStateException("Error in expression at " + tokens[pos]);
        }
        return result;
    }

    // E -> T±T±T±T± ... ±T
    private Double expression() {
        // находим первое слагаемое
        Double first = term();

        while (pos < tokens.length) {
            String operator = tokens[pos];
            if (!operator.equals("+") && !operator.equals("-")) {
                break;
            } else {
                pos++;
            }

            // находим второе слагаемое (вычитаемое)
            Double second = term();
            if (operator.equals("+")) {
                first += second;
            } else {
                first -= second;
            }
        }
        return first;
    }

    // T -> F*/F*/F*/*/ ... */F
    private Double term() {
        // находим первый множитель
        Double first = factor();

        while (pos < tokens.length) {
            String operator = tokens[pos];
            if (!operator.equals("*") && !operator.equals("/")) {
                break;
            } else {
                pos++;
            }

            // находим второй множитель (делитель)
            Double second = factor();
            if (operator.equals("*")) {
                first *= second;
            } else {
                first /= second;
            }
        }
        return first;
    }
    
    // F -> N | (E)
    private Double factor() {
        String next = tokens[pos];
        Double result;
        if (next.equals("(") || next.equals("-(")) {
            pos++;
            // если выражение в скобках, то рекурсивно переходим на обработку подвыражения типа Е
            result = expression();  
            String closingBracket;
            if (pos < tokens.length) {
                closingBracket = tokens[pos];
            } else {
                throw new IllegalStateException("Unexpected end of expression");
            }
            if (pos < tokens.length && closingBracket.equals(")")) {
                pos++;
                if(next.equals("-("))
                	return -1*result;
                return result;
            }
            throw new IllegalStateException("')' expected but " + closingBracket);
        }
        pos++;
        // в противном случае токен должен быть числом
        return Double.parseDouble(next);
    }
}
