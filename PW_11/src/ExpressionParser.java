import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ExpressionParser {
	void TripleExpressionParser(String str) {
		Scanner in = new Scanner(System.in);
		//очистим от пробелов
		str = str.replaceAll("\\s+", "");
		
		//подстановка значений
		//Добавить читалку с консоли
		String x = "";
		String y = "";
		String z = "";
		
		while(!isNumeric(x)&&!isNumeric(y)&&!isNumeric(z)) {
			x = in.nextLine();
			y = in.nextLine();
			z = in.nextLine();
		}
		str = str.replaceAll("[x]", x);
		str = str.replaceAll("[y]", y);
		str = str.replaceAll("[z]", z);
		System.out.println(str);
		//разбиваем на токены. Учесть многозначные цифры
		String[] tokens = tokenParser(str);
		
		//String[] tokens = {"-(","1","+","1",")","*","10","/","10","-","-4"};
		System.out.println(str + " = " + new RecursiveDescentParser(tokens).parse());
	}
	String[] tokenParser(String str) {
		ArrayList<String> tokens = new ArrayList<String>();
		StringBuffer  strB = new StringBuffer();
		for(int i = 0;i < str.length();i++)
		{
			String tmp = Character.toString(str.charAt(i));
			//if digit
			if(isNumeric(tmp))
			{
				strB.append(tmp);
				if(i+1==str.length())
				{
					tokens.add(strB.toString());
				}
			}else if(isOperation(tmp))
			{
				if(i+1<=str.length() && tmp.equals("-"))
				{
					if(str.charAt(1+i)=='(')
					{
						tokens.add("-(");
						i++;
						continue;
					}
					if(isNumeric(Character.toString(str.charAt(1+i))))
					{
						strB.append("-");
						continue;
					}
				}
				if(strB.length()!=0)
				{
					tokens.add(strB.toString());
					strB = new StringBuffer();
				}
				tokens.add(tmp);
			}
			else
			{
				tokens.add(strB.toString());
				strB = new StringBuffer();
			}
		}
		String[] arr = new String[tokens.size()]; 
        return tokens.toArray(arr);
	}
	 
	public boolean isNumeric(String strNum) {
		Pattern pattern = Pattern.compile("\\d");
		if (strNum == null) {
	        return false; 
	    }
	    return pattern.matcher(strNum).matches();
	}
	public boolean isOperation(String strNum) {
		Pattern pattern = Pattern.compile("[+-/*//()]");
		if (strNum == null) {
	        return false; 
	    }
	    return pattern.matcher(strNum).matches();
	}
	
}

class RecursiveDescentParser {

    private final String[] tokens;
    private int pos = 0; // индекс текущего токена

    public RecursiveDescentParser(String[] tokens) {
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
                first = new Add(new Const(first),new Const(second)).evaluate(0);
            } else {
                first = new Subtract(new Const(first),new Const(second)).evaluate(0);
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
                first = new Multiply(new Const(first),new Const(second)).evaluate(0);
            } else {
                first = new Divide(new Const(first),new Const(second)).evaluate(0);
            }
        }
        return first;
    }
    
    // F -> N | (E)
    private Double factor() {
        String next = tokens[pos];
        Double result;
        if (next.equals("(") ) {
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
                return result;
            }
            throw new IllegalStateException("')' expected but " + closingBracket);
        }else if(next.equals("-(")) {
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
                return -1*result;
            }
            throw new IllegalStateException("')' expected but " + closingBracket);
        }
        pos++;
        // в противном случае токен должен быть числом
        return Double.parseDouble(next);
    }
}